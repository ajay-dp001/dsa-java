package LowLoevelSystemDesign.parkinglot.parking.spot;

import lombok.Getter;
import LowLoevelSystemDesign.parkinglot.vehicle.Vehicle;

public abstract class ParkingSpot {

  @Getter
  private final String id;
  @Getter
  private final ParkingSpotType parkingSpotType;
  private boolean isFree;
  private Vehicle assignedVehichle;

  public ParkingSpot(String id, ParkingSpotType parkingSpotType) {
    this.id = id;
    this.isFree = true;
    this.parkingSpotType = parkingSpotType;
  }

  public void assignVehichle(Vehicle vehichle) {
    isFree = false;
    assignedVehichle = vehichle;
  }

  public void vacateSpot() {
    isFree = false;
    assignedVehichle = null;
  }

}
