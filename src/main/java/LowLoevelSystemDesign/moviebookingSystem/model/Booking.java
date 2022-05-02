package LowLoevelSystemDesign.moviebookingSystem.model;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.InValidBookingStatusException;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class Booking {

  private final Show show;
  private final String user;
  private final String bookingId;
  private final List<Seat> seatsBooked;
  public BookingStatus bookingStatus;

  public Booking(@NonNull final String bookingId, @NonNull final Show show, @NonNull final String user,
      @NonNull final List<Seat> seatsBooked) {
    this.bookingId = bookingId;
    this.show = show;
    this.user = user;
    this.seatsBooked = seatsBooked;
    this.bookingStatus = BookingStatus.CREATED;
  }

  public boolean isConfirmed() {
    return this.bookingStatus == BookingStatus.CONFIRMED;
  }

  public void confirmBooking() throws InValidBookingStatusException {
    if (this.bookingStatus != BookingStatus.CREATED) {
      throw new InValidBookingStatusException("Booking doesn't exist.!");
    }
    this.bookingStatus = BookingStatus.CONFIRMED;
  }

  public void expireBooking() throws InValidBookingStatusException {
    if (this.bookingStatus != BookingStatus.CREATED) {
      throw new InValidBookingStatusException("Booking doesn't exist.!");
    }
    this.bookingStatus = BookingStatus.EXPIRED;
  }

}
