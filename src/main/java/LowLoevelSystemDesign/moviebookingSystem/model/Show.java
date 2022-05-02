package LowLoevelSystemDesign.moviebookingSystem.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Show {

  private final String showId;
  private final Movie currentMovie;
  private final Screen currentScreen;
  private final Date startTime;
  public final double durationInSecond;

}
