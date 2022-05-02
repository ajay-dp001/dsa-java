package LowLoevelSystemDesign.parkinglot.parking.panel;


import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import LowLoevelSystemDesign.parkinglot.exceptions.InvalidParkingFloorException;
import LowLoevelSystemDesign.parkinglot.exceptions.ParkingFullException;
import LowLoevelSystemDesign.parkinglot.parking.ParkingLot;
import LowLoevelSystemDesign.parkinglot.parking.spot.ParkingSpot;
import LowLoevelSystemDesign.parkinglot.ticket.ParkingTicket;
import LowLoevelSystemDesign.parkinglot.vehicle.Vehicle;

@Getter
@AllArgsConstructor
public class EntryPanel {

  private final String id;

  public ParkingTicket getTicket(final Vehicle vehichle) throws ParkingFullException,
      InvalidParkingFloorException {
    final ParkingSpot parkingSpot = ParkingLot.INSTANCE.getParkingSpot(vehichle);
    return buildParkingTicket(vehichle.getLicenseNumber(), parkingSpot.getId());
  }

  private ParkingTicket buildParkingTicket(String licenseNumber, String allocatedSpotId) {
    return ParkingTicket.builder()
        .id(UUID.randomUUID().toString())
        .issuedAt(LocalDateTime.now())
        .assignedVehichleId(licenseNumber)
        .allocatedSpotId(allocatedSpotId)
        .build();
  }
}
