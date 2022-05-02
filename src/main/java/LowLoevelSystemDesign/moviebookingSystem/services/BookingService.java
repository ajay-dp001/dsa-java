package LowLoevelSystemDesign.moviebookingSystem.services;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.BadInputRequestException;
import LowLoevelSystemDesign.moviebookingSystem.exceptions.InValidBookingStatusException;
import LowLoevelSystemDesign.moviebookingSystem.exceptions.NotFoundException;
import LowLoevelSystemDesign.moviebookingSystem.exceptions.SeatNotAvailableException;
import LowLoevelSystemDesign.moviebookingSystem.exceptions.SeatTemporaryUnAvailableException;
import LowLoevelSystemDesign.moviebookingSystem.model.Booking;
import LowLoevelSystemDesign.moviebookingSystem.model.Seat;
import LowLoevelSystemDesign.moviebookingSystem.model.Show;
import LowLoevelSystemDesign.moviebookingSystem.providers.SeatLockProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import lombok.NonNull;

public class BookingService {

  private final Map<String, Booking> showBookings;
  private final SeatLockProvider seatLockProvider;

  public BookingService(@NonNull final SeatLockProvider seatLockProvider) {
    this.seatLockProvider = seatLockProvider;
    this.showBookings = new ConcurrentHashMap<>();
  }

  public Booking getBooking(@NonNull final String bookingId) throws NotFoundException {
    if (!showBookings.containsKey(bookingId)) {
      throw new NotFoundException("Booking with Booking Id:" + bookingId + " doesn't exist.!!");
    }
    return showBookings.get(bookingId);
  }

  public List<Booking> getAllBooking(@NonNull final Show show) {
    List<Booking> bookingList = new ArrayList<>();
    for (Booking booking : showBookings.values()) {
      if (booking.getShow().equals(show)) {
        bookingList.add(booking);
      }
    }
    return bookingList;
  }

  public Booking createBooking(@NonNull final String userId, @NonNull final Show show,
      @NonNull final List<Seat> seats) throws SeatNotAvailableException, SeatTemporaryUnAvailableException {
    if (isAnySeatAlreadyBooked(show, seats)) {
      throw new SeatNotAvailableException("Requested Seat is not available..!");
    }

    seatLockProvider.lockSeats(show, seats, userId);
    final String bookingId = UUID.randomUUID().toString();
    final Booking newBooking = new Booking(bookingId, show, userId, seats);
    showBookings.put(bookingId, newBooking);
    return newBooking;
    // Timer for Booking Expiry
  }

  private boolean isAnySeatAlreadyBooked(final Show show, final List<Seat> seats) {
    final List<Seat> bookedSeats = getBookedSeats(show);
    for (Seat seat : bookedSeats) {
      if (bookedSeats.contains(seat)) {
        return true;
      }
    }
    return false;
  }

  private List<Seat> getBookedSeats(@NonNull final Show show) {
    return getAllBooking(show).stream().filter(Booking::isConfirmed).map(Booking::getSeatsBooked)
        .flatMap(Collection::stream).collect(Collectors.toList());
  }

  public void confirmBooking(@NonNull final Booking booking, @NonNull final String user)
      throws BadInputRequestException, InValidBookingStatusException {
    if (!booking.getUser().equals(user)) {
      throw new BadInputRequestException("User doesn't matches to Booking details.!");
    }

    for (Seat seat : booking.getSeatsBooked()) {
      if (!seatLockProvider.validateLock(booking.getShow(), seat, user)) {
        throw new BadInputRequestException("Booking details not matched with user..!");
      }
    }
    booking.confirmBooking();
  }

  public List<Seat> getAvailableSeats(@NonNull final Show show) {
    final List<Seat> allSeats = show.getCurrentScreen().getSeats();
    final List<Seat> unAvailableSeats = getUnAvailableSeats(show);

    final List<Seat> availableSeats = new ArrayList<>(allSeats);
    availableSeats.removeAll(unAvailableSeats);
    return availableSeats;
  }

  private List<Seat> getUnAvailableSeats(final Show show) {
    final List<Seat> unAvailableSeats = getBookedSeats(show);
    unAvailableSeats.addAll(seatLockProvider.getLockedSeats(show));
    return unAvailableSeats;
  }

}
