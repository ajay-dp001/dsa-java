package LowLoevelSystemDesign.moviebookingSystem.exceptions;

import LowLoevelSystemDesign.moviebookingSystem.model.Seat;

public class SeatNotAvailableException extends Exception {

  public SeatNotAvailableException(final String message) {
    super(message);
  }

}
