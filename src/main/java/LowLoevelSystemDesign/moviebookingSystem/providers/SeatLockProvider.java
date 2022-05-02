package LowLoevelSystemDesign.moviebookingSystem.providers;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.SeatTemporaryUnAvailableException;
import LowLoevelSystemDesign.moviebookingSystem.model.Seat;
import LowLoevelSystemDesign.moviebookingSystem.model.Show;
import java.util.List;

public interface SeatLockProvider {

  void lockSeats(final Show show, List<Seat> seats, String user) throws SeatTemporaryUnAvailableException;

  void unLockSeats(final Show show, List<Seat> seats, String user);

  boolean validateLock(final Show show, Seat seats, String user);

  List<Seat> getLockedSeats(final Show show);

}
