package LowLoevelSystemDesign.cabbookingsystem.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Trip {

  private final String tripId;
  private final CabVehicle cab;
  private final Rider tripRider;
  private final double tripPrice;
  private TripStatus tripStatus;
  private final Location tripStartLocation;
  private final Location tripEndLocation;

  public Trip(@NonNull final String tripId, @NonNull final CabVehicle cab, @NonNull final Rider tripRider,
      @NonNull double tripPrice, @NonNull Location tripStartLocation, @NonNull Location tripEndLocation) {
    this.tripId = tripId;
    this.cab = cab;
    this.tripRider = tripRider;
    this.tripPrice = tripPrice;
    this.tripStatus = TripStatus.STARTED;
    this.tripStartLocation = tripStartLocation;
    this.tripEndLocation = tripEndLocation;
  }

  public void endTrip() {
    this.tripStatus = TripStatus.FINISHED;
  }

}
