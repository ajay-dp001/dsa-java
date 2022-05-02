package LowLoevelSystemDesign.parkinglot.parking.spot;

import lombok.Getter;

@Getter
public class CarParkingSpot extends ParkingSpot {

  public CarParkingSpot(String id) {
    super(id, ParkingSpotType.SMALL_VEHICHLE);
  }
}
