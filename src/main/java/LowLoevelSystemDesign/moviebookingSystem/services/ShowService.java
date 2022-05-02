package LowLoevelSystemDesign.moviebookingSystem.services;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.NotFoundException;
import LowLoevelSystemDesign.moviebookingSystem.exceptions.ScreenAlreayOccupiedException;
import LowLoevelSystemDesign.moviebookingSystem.model.Movie;
import LowLoevelSystemDesign.moviebookingSystem.model.Screen;
import LowLoevelSystemDesign.moviebookingSystem.model.Show;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lombok.NonNull;

public class ShowService {

  private final Map<String, Show> showMap;

  public ShowService() {
    showMap = new ConcurrentHashMap<>();
  }

  public Show createShow(@NonNull final Movie movie, @NonNull final Screen screen,
      @NonNull final Date startTime, @NonNull final double durationINSeconds)
      throws ScreenAlreayOccupiedException {
    if (!checkIfScreenAvailable(screen, startTime, durationINSeconds)) {
      throw new ScreenAlreayOccupiedException("Screen not available to schedule Show at time :" + startTime);
    }

    String showId = UUID.randomUUID().toString();
    final Show newShow = new Show(showId, movie, screen, startTime, durationINSeconds);
    showMap.put(showId, newShow);
    return newShow;
  }

  public Show getShow(@NonNull final String showId) throws NotFoundException {
    if (!showMap.containsKey(showId)) {
      throw new NotFoundException("Show with showId :" + showId + "doesn't exist ");
    }
    return showMap.get(showId);
  }

  public List<Show> getShowsForScreen(@NonNull final Screen screen) {
    List<Show> showList = new ArrayList<>();
    for (Show show : showMap.values()) {
      if (show.getCurrentScreen().equals(screen)) {
        showList.add(show);
      }
    }
    return showList;
  }

  public boolean checkIfScreenAvailable(@NonNull Screen screen, @NonNull Date startTime,
      @NonNull double durationInSeconds) {
    //Check if Screen is available.
    return true;
  }
}
