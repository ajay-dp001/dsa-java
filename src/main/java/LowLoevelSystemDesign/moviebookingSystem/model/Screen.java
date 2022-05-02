package LowLoevelSystemDesign.moviebookingSystem.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class Screen {

  private final String screenId;
  public final List<Seat> seats;
  private final String screenName;
  private final Theatre attachedTheatre;

  public Screen(@NonNull final String screenId, @NonNull final String screenName,
      @NonNull final Theatre attachedTheatre) {
    this.screenId = screenId;
    this.screenName = screenName;
    this.seats = new ArrayList<>();
    this.attachedTheatre = attachedTheatre;
  }

  public void addSeats(@NonNull final Seat seat) {
    seats.add(seat);
  }

}
