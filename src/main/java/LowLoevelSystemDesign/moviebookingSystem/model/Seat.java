package LowLoevelSystemDesign.moviebookingSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Seat {

  private final String seatId;
  private final int rowId;
  private final int seatNum;

}
