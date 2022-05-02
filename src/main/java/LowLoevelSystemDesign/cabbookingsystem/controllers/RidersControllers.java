package LowLoevelSystemDesign.cabbookingsystem.controllers;

import LowLoevelSystemDesign.cabbookingsystem.exceptions.NoCabAvailableException;
import LowLoevelSystemDesign.cabbookingsystem.exceptions.RiderNotFoundException;
import LowLoevelSystemDesign.cabbookingsystem.model.Location;
import LowLoevelSystemDesign.cabbookingsystem.model.Trip;
import LowLoevelSystemDesign.cabbookingsystem.services.RiderService;
import LowLoevelSystemDesign.cabbookingsystem.services.TripService;
import java.util.List;

/**
@RestController
public class RidersControllers {

  private final RiderService riderService;
  private final TripService tripService;

  public RidersController(final RidersManager ridersManager, final TripsManager tripsManager) {
    this.ridersManager = ridersManager;
    this.tripsManager = tripsManager;
  }

  @PostMapping("/register/rider")
  public ResponseEntity registerRider(final String riderId, final String riderName) {
    riderService.createRider(riderId, riderName);
    return ResponseEntity.ok("");
  }

  @PostMapping("/book/ride")
  public ResponseEntity registerRider(final String riderId, final double sourceX, final double sourceY,
      final double destX, final double destY) throws RiderNotFoundException, NoCabAvailableException {
    tripService.createTrip(riderService.getRider(riderId), new Location(sourceX, sourceY),
        new Location(destX, destY));
    return ResponseEntity.ok("");
  }

  @GetMapping("/book/")
  public ResponseEntity fetchHistory(final String riderId)
      throws RiderNotFoundException, NoCabAvailableException {
    List<Trip> trips = tripService.getTripHistory(riderService.getRider(riderId));
    return ResponseEntity.ok("");
  }

}
*/
