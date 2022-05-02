package LowLoevelSystemDesign.cabbookingsystem.services;

import LowLoevelSystemDesign.cabbookingsystem.exceptions.NoCabAvailableException;
import LowLoevelSystemDesign.cabbookingsystem.exceptions.TripNotFoundException;
import LowLoevelSystemDesign.cabbookingsystem.model.CabVehicle;
import LowLoevelSystemDesign.cabbookingsystem.model.Location;
import LowLoevelSystemDesign.cabbookingsystem.model.Rider;
import LowLoevelSystemDesign.cabbookingsystem.model.Trip;
import LowLoevelSystemDesign.cabbookingsystem.strategies.CabMatchingStrategy;
import LowLoevelSystemDesign.cabbookingsystem.strategies.PricingStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import lombok.NonNull;

public class TripService {

  public static final double MAX_TRIP_MATCHING_DISTANCE = 10.0;
  private final Map<String, List<Trip>> trips = new ConcurrentHashMap<>();

  private final CabService cabService;
  private final RiderService riderService;
  private final PricingStrategy pricingStrategy;
  private final CabMatchingStrategy cabMatchingStrategy;

  public TripService(@NonNull final CabService cabService, @NonNull final RiderService riderService,
      @NonNull PricingStrategy pricingStrategy, @NonNull CabMatchingStrategy cabMatchingStrategy) {
    this.cabService = cabService;
    this.riderService = riderService;
    this.pricingStrategy = pricingStrategy;
    this.cabMatchingStrategy = cabMatchingStrategy;
  }

  public void createTrip(@NonNull final Rider rider, @NonNull final Location fromLocation,
      @NonNull Location toLocation) throws NoCabAvailableException {
    final List<CabVehicle> closeByCab = cabService.getCabs(fromLocation, MAX_TRIP_MATCHING_DISTANCE);
    final List<CabVehicle> closeByAvailableCabs = closeByCab.stream()
        .filter(cab -> cab.getCabCurrentTrip() == null).collect(Collectors.toList());

    final CabVehicle selectedCab = cabMatchingStrategy.matchCabToRider(rider, closeByAvailableCabs,
        fromLocation, toLocation);
    if (selectedCab == null) {
      throw new NoCabAvailableException("No Cabs Available at this point of time.!!");
    }

    final double price = pricingStrategy.findPrice(fromLocation, toLocation);
    final String tripId = UUID.randomUUID().toString();
    final Trip newTrip = new Trip(tripId, selectedCab, rider, price, fromLocation,
        toLocation);

    if (!trips.containsKey(rider.getRiderId())) {
      trips.put(rider.getRiderId(), new ArrayList<>());
    }

    trips.get(rider.getRiderId()).add(newTrip);
    selectedCab.setCabCurrentTrip(newTrip);
  }

  public List<Trip> getTripHistory(@NonNull final Rider rider) {
    return trips.get(rider.getRiderId());
  }

  public void endTrip(@NonNull final CabVehicle cabVehicle) throws TripNotFoundException {
    if (cabVehicle.getCabCurrentTrip() == null) {
      throw new TripNotFoundException("No Trip found with Trip details: " + cabVehicle.getCabCurrentTrip());
    }
    cabVehicle.getCabCurrentTrip().endTrip();
    cabVehicle.setAvailable(true);
  }

}
