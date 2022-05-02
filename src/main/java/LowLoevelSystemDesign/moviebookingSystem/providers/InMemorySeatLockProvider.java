package LowLoevelSystemDesign.moviebookingSystem.providers;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.SeatTemporaryUnAvailableException;
import LowLoevelSystemDesign.moviebookingSystem.model.Seat;
import LowLoevelSystemDesign.moviebookingSystem.model.SeatLock;
import LowLoevelSystemDesign.moviebookingSystem.model.Show;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.NonNull;

public class InMemorySeatLockProvider implements SeatLockProvider {

  private final long lockTimeout;
  private final Map<Show, Map<Seat, SeatLock>> locks;

  public InMemorySeatLockProvider(@NonNull final int lockTimeout) {
    this.lockTimeout = lockTimeout;
    this.locks = new ConcurrentHashMap<>();
  }

  @Override
  public void lockSeats(@NonNull final Show show, @NonNull final List<Seat> seats,
      @NonNull final String user) throws SeatTemporaryUnAvailableException {
    for (Seat seat : seats) {
      if (isSeatLocked(show, seat)) {
        throw new SeatTemporaryUnAvailableException("Seat already Booked.");
      }
    }

    for (Seat seat : seats) {
      lockSeat(show, seat, user, lockTimeout);
    }
  }

  private boolean isSeatLocked(final Show show, final Seat seat) {
    return locks.containsKey(show) && locks.get(show).containsKey(seat) && !locks.get(show).get(seat)
        .isLockedExpired();
  }

  private void lockSeat(Show show, Seat seat, String user, long timeoutInSeconds) {
    if (!locks.containsKey(show)) {
      locks.put(show, new HashMap<>());
    }

    final SeatLock lock = new SeatLock(seat, show, timeoutInSeconds, new Date(), user);
    locks.get(show).put(seat, lock);
  }


  @Override
  public void unLockSeats(@NonNull final Show show, @NonNull final List<Seat> seats,
      @NonNull final String user) {
    for (Seat seat : seats) {
      if (validateLock(show, seat, user)) {
        unLockSeat(show, seat);
      }
    }
  }

  private void unLockSeat(final Show show, final Seat seat) {
    if (!locks.containsKey(show)) {
      return;
    }
    locks.get(show).remove(seat);
  }

  @Override
  public boolean validateLock(Show show, Seat seats, String user) {
    return isSeatLocked(show, seats) && locks.get(show).get(seats).getLockedBy().equals(user);
  }

  @Override
  public List<Seat> getLockedSeats(@NonNull final Show show) {
    if (!locks.containsKey(show)) {
      return List.of();
    }
    final List<Seat> lockedSeats = new ArrayList<>();
    for (Seat seat : locks.get(show).keySet()) {
      if (isSeatLocked(show, seat)) {
        lockedSeats.add(seat);
      }
    }
    return lockedSeats;
  }
}
