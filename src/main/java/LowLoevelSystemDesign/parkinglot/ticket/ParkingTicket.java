package LowLoevelSystemDesign.parkinglot.ticket;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ParkingTicket {

  public final String id;
  private final LocalDateTime issuedAt;
  @Setter
  private LocalDateTime vacatedAt;
  private final String assignedVehichleId;
  private final String allocatedSpotId;
  private double charge;

  public void updateAmountCharged(double amountCharged) {
    this.charge = amountCharged;
  }

}
