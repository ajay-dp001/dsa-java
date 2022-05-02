package LowLoevelSystemDesign.moviebookingSystem.controllers;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.NotFoundException;
import LowLoevelSystemDesign.moviebookingSystem.exceptions.ScreenAlreayOccupiedException;
import LowLoevelSystemDesign.moviebookingSystem.model.Movie;
import LowLoevelSystemDesign.moviebookingSystem.model.Screen;
import LowLoevelSystemDesign.moviebookingSystem.model.Seat;
import LowLoevelSystemDesign.moviebookingSystem.model.Show;
import LowLoevelSystemDesign.moviebookingSystem.services.BookingService;
import LowLoevelSystemDesign.moviebookingSystem.services.MovieService;
import LowLoevelSystemDesign.moviebookingSystem.services.ShowService;
import LowLoevelSystemDesign.moviebookingSystem.services.TheatreService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class ShowController {

  private final BookingService bookingService;
  private final ShowService showService;
  private final TheatreService theatreService;
  private final MovieService movieService;

  public String createShow(@NonNull final String movieId, @NonNull final String screenId,
      @NonNull final Date startTime,
      @NonNull final Integer durationInSeconds) throws NotFoundException, ScreenAlreayOccupiedException {
    final Screen screen = theatreService.getScreen(screenId);
    final Movie movie = movieService.getMovie(movieId);
    return showService.createShow(movie, screen, startTime, durationInSeconds).getShowId();
  }

  public List<String> getAvailableSeats(@NonNull final String showId) throws NotFoundException {
    final Show show = showService.getShow(showId);
    final List<Seat> availableSeats = bookingService.getAvailableSeats(show);
    return availableSeats.stream().map(Seat::getSeatId).collect(Collectors.toList());
  }
}
