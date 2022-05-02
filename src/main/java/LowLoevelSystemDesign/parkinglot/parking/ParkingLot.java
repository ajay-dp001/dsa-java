package LowLoevelSystemDesign.parkinglot.parking;


import LowLoevelSystemDesign.parkinglot.account.common.Address;
import LowLoevelSystemDesign.parkinglot.exceptions.InvalidParkingFloorException;
import LowLoevelSystemDesign.parkinglot.exceptions.ParkingFullException;
import LowLoevelSystemDesign.parkinglot.parking.panel.EntryPanel;
import LowLoevelSystemDesign.parkinglot.parking.panel.ExitPanel;
import LowLoevelSystemDesign.parkinglot.parking.spot.ParkingSpot;
import LowLoevelSystemDesign.parkinglot.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.Getter;

@Getter
public class ParkingLot {

  private final String id;
  private Address address;
  private final List<ParkingFloor> parkingFloors;
  private final List<EntryPanel> entryPanels;
  private final List<ExitPanel> exitPanels;
  //private final Map<String, ParkingTicket> activeTickets;

  public static final ParkingLot INSTANCE = new ParkingLot();

  private ParkingLot() {
    this.id = UUID.randomUUID().toString();
    this.parkingFloors = new ArrayList<>();
    this.entryPanels = new ArrayList<>();
    this.exitPanels = new ArrayList<>();
  }

  public void updateAddress(final Address address) {
    this.address = address;
  }

  public void addFloor(final ParkingFloor parkingFloor) {
    final Optional<ParkingFloor> floor = parkingFloors.stream()
        .filter(ep -> ep.getId().equals(parkingFloor.getId()))
        .findFirst();
    if (floor.isPresent()) {
      return;
    }
    parkingFloors.add(parkingFloor);
  }

  public void addEntryPanel(final EntryPanel entryPanel) {
    final Optional<EntryPanel> panel = entryPanels.stream()
        .filter(ep -> ep.getId().equals(entryPanel.getId()))
        .findFirst();
    if (panel.isPresent()) {
      return;
    }
    entryPanels.add(entryPanel);
  }

  public void addExitPanel(final ExitPanel exitPanel) {
    final Optional<ExitPanel> panel = exitPanels.stream()
        .filter(exp -> exp.getId().equals(exitPanel.getId()))
        .findFirst();
    if (panel.isPresent()) {
      return;
    }
    exitPanels.add(exitPanel);
  }

  public void addParkingSpot(final String floorId, final ParkingSpot parkingSpot)
      throws InvalidParkingFloorException {
    final Optional<ParkingFloor> parkingFloor = parkingFloors.stream()
        .filter(pF -> pF.getId().equals(floorId))
        .findFirst();

    if (parkingFloor.isEmpty()) {
      throw new InvalidParkingFloorException("Parking Floor found with Id :" + floorId + " does not exist");
    }

    parkingFloor.get().addParkingSpot(parkingSpot);
  }


  public ParkingSpot getParkingSpot(final Vehicle vehichle) throws ParkingFullException, InvalidParkingFloorException {
    final Optional<ParkingFloor> parkingFloor = parkingFloors.stream()
        .filter(pf -> pf.canPark(vehichle.getVehichleType()))
        .findFirst();
    if (!parkingFloor.isPresent()) {
      throw new ParkingFullException("Sorry ! Parking is full");
    }
    return parkingFloor.get().getParkingSpot(vehichle);
  }

  public void vacateParkingSpot(final String parkingSpotId){
    parkingFloors.stream().filter(parkingFloor -> parkingFloor.vacateParkingSpot(parkingSpotId).isPresent())
        .findFirst();
  }
}
