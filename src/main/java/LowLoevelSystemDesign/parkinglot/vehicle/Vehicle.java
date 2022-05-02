package LowLoevelSystemDesign.parkinglot.vehicle;

import lombok.Getter;
import LowLoevelSystemDesign.parkinglot.ticket.ParkingTicket;

@Getter
public abstract class Vehicle {

  private final String licenseNumber;
  private VehichleType vehichleType;
  private ParkingTicket parkingTicket;


  public Vehicle(String licenseNumber, VehichleType vehichleType) {
    this.licenseNumber = licenseNumber;
    this.vehichleType = vehichleType;
  }

  public void assignTicket(ParkingTicket parkingTicket) {
    this.parkingTicket = parkingTicket;
  }
}
