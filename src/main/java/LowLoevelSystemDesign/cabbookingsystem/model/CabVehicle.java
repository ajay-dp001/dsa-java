package LowLoevelSystemDesign.cabbookingsystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class CabVehicle {

  private String cabId;
  private String cabDriverName;
  @Setter
  private boolean isAvailable;
  @Setter
  private Trip cabCurrentTrip;
  @Setter
  private Location cabCurrentLocation;

  public CabVehicle(final String cabId, final String cabDriverName) {
    this.cabId = cabId;
    this.isAvailable = true;
    this.cabDriverName = cabDriverName;
  }

  @Override
  public String toString() {
    return "Cab{" + "Id: " + cabId + ", Driver Name: " + cabDriverName + ", CurrentLocation: "
        + cabCurrentLocation + ", isAvailable: " + isAvailable + '}';
  }
}
