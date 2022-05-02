package LowLoevelSystemDesign.moviebookingSystem.services;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.BadInputRequestException;
import LowLoevelSystemDesign.moviebookingSystem.model.Booking;
import LowLoevelSystemDesign.moviebookingSystem.providers.SeatLockProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.NonNull;

public class PaymentService {

  private final int allowedRetries;
  private final SeatLockProvider seatLockProvider;
  private final Map<Booking, Integer> bookingFailures;

  public PaymentService(@NonNull final int allowedRetries, @NonNull final SeatLockProvider seatLockProvider) {
    this.allowedRetries = allowedRetries;
    this.seatLockProvider = seatLockProvider;
    bookingFailures = new ConcurrentHashMap<>();
  }

  public void processPaymentFailed(@NonNull final Booking booking, @NonNull final String user)
      throws BadInputRequestException {
    if (!booking.getUser().equals(user)) {
      throw new BadInputRequestException("Booking details not matched with User..!");
    }
    if (!bookingFailures.containsKey(booking)) {
      bookingFailures.put(booking, 0);
    }
    final int currentFailureCount = bookingFailures.get(booking);
    final int newFailuresCount = currentFailureCount + 1;
    bookingFailures.put(booking, newFailuresCount);
    if (newFailuresCount > allowedRetries) {
      seatLockProvider.unLockSeats(booking.getShow(), booking.getSeatsBooked(), booking.getUser());
    }
  }

}
