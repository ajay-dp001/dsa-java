package LowLoevelSystemDesign.moviebookingSystem.model;

import java.time.Instant;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SeatLock {

  private Seat seat;
  private Show show;
  private long timeoutInSeconds;
  private final Date lockTime;
  private String lockedBy;

  public boolean isLockedExpired() {
    final Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutInSeconds);
    final Instant currentInstant = new Date().toInstant();
    return lockInstant.isBefore(currentInstant);
  }

}
