package LowLoevelSystemDesign.parkinglot.parking.panel;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import LowLoevelSystemDesign.parkinglot.parking.ParkingLot;
import LowLoevelSystemDesign.parkinglot.pricing.PricingStrategy;
import LowLoevelSystemDesign.parkinglot.ticket.ParkingTicket;

@Getter
@AllArgsConstructor
public class ExitPanel {

  private final String id;
  private final PricingStrategy pricingStrategy;

  public void scanAndVaccate(final ParkingTicket parkingTicket) {
    ParkingLot.INSTANCE.vacateParkingSpot(parkingTicket.getAllocatedSpotId());
    parkingTicket.setVacatedAt(LocalDateTime.now());
    parkingTicket.updateAmountCharged(pricingStrategy.calculateAmountCharged(parkingTicket));
  }
}
