package LowLoevelSystemDesign.moviebookingSystem.controllers;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.NotFoundException;
import LowLoevelSystemDesign.moviebookingSystem.exceptions.SeatNotAvailableException;
import LowLoevelSystemDesign.moviebookingSystem.exceptions.SeatTemporaryUnAvailableException;
import LowLoevelSystemDesign.moviebookingSystem.model.Seat;
import LowLoevelSystemDesign.moviebookingSystem.model.Show;
import LowLoevelSystemDesign.moviebookingSystem.services.BookingService;
import LowLoevelSystemDesign.moviebookingSystem.services.ShowService;
import LowLoevelSystemDesign.moviebookingSystem.services.TheatreService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class BookingController {

  private final ShowService showService;
  private final BookingService bookingService;
  private final TheatreService theatreService;


  public String createBooking(@NonNull final String userId, @NonNull final String showId,
      @NonNull final List<String> seatsIds)
      throws NotFoundException, SeatNotAvailableException, SeatTemporaryUnAvailableException {
    final Show show = showService.getShow(showId);
    //final List<Seat> seats = seatsIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
    //return bookingService.createBooking(userId, show, seats).getBookingId();
    return null;
  }

}
