package LowLoevelSystemDesign.parkinglot.pricing;

import LowLoevelSystemDesign.parkinglot.ticket.ParkingTicket;

public interface PricingStrategy {

  double calculateAmountCharged(final ParkingTicket parkingTicket);

}
