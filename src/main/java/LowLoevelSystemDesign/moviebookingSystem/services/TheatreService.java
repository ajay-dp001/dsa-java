package LowLoevelSystemDesign.moviebookingSystem.services;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.NotFoundException;
import LowLoevelSystemDesign.moviebookingSystem.model.Screen;
import LowLoevelSystemDesign.moviebookingSystem.model.Seat;
import LowLoevelSystemDesign.moviebookingSystem.model.Theatre;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lombok.NonNull;

public class TheatreService {

  private final Map<String, Seat> seats;
  private final Map<String, Screen> screens;
  private final Map<String, Theatre> theatres;

  public TheatreService() {
    seats = new ConcurrentHashMap<>();
    screens = new ConcurrentHashMap<>();
    theatres = new ConcurrentHashMap<>();
  }

  public Seat getSeat(@NonNull final String seatId) throws NotFoundException {
    if (!seats.containsKey(seatId)) {
      throw new NotFoundException("Seat with seatId: " + seatId + " doesn't exist");
    }
    return seats.get(seatId);
  }

  public Screen getScreen(@NonNull final String screenId) throws NotFoundException {
    if (!screens.containsKey(screenId)) {
      throw new NotFoundException("Screen with seatId: " + screenId + " doesn't exist");
    }
    return screens.get(screenId);
  }

  public Theatre getTheatre(@NonNull final String theatreId) throws NotFoundException {
    if (!theatres.containsKey(theatreId)) {
      throw new NotFoundException("Theatre with seatId: " + theatreId + " doesn't exist");
    }
    return theatres.get(theatreId);
  }

  public Theatre createTheatre(@NonNull final String theatreName) {
    String theatreId = UUID.randomUUID().toString();
    Theatre newTheatre = new Theatre(theatreId, theatreName);
    theatres.put(theatreId, newTheatre);
    return newTheatre;
  }

  public Screen createScreen(@NonNull final String screenName, @NonNull Theatre theatre) {
    String screenId = UUID.randomUUID().toString();
    Screen newScreen = new Screen(screenId, screenName, theatre);
    screens.put(screenId, newScreen);
    return newScreen;
  }

  public Screen createScreenInTheatre(@NonNull final String screenName, @NonNull Theatre theatre) {
    Screen screen = createScreen(screenName, theatre);
    theatre.addScreen(screen);
    return screen;
  }

  public Seat createSeatInScreen(@NonNull final int rowNum, @NonNull final int seatNum,
      @NonNull final Screen screen) {
    String seatId = UUID.randomUUID().toString();
    Seat seat = new Seat(seatId, rowNum, seatNum);
    seats.put(seatId, seat);
    screen.addSeats(seat);
    return seat;
  }

}
