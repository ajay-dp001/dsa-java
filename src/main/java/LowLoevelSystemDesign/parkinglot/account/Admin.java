package LowLoevelSystemDesign.parkinglot.account;

import LowLoevelSystemDesign.parkinglot.parking.ParkingFloor;
import LowLoevelSystemDesign.parkinglot.parking.panel.EntryPanel;
import LowLoevelSystemDesign.parkinglot.parking.panel.ExitPanel;
import LowLoevelSystemDesign.parkinglot.parking.spot.ParkingSpot;

public class Admin extends Account {

  public boolean addParkingFloor(ParkingFloor floor) {
    return false;
  }

  public boolean addParkingSpot(String floorName, ParkingSpot spot) {
    return false;
  }

  // public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard) {
  // return false;
  //}

  // public boolean addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel) {
  //  return false;
  //}

  public boolean addEntrancePanel(EntryPanel entrancePanel) {
    return false;
  }

  public boolean addExitPanel(ExitPanel exitPanel) {
    return false;
  }

}
