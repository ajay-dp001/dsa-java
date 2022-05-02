package LowLoevelSystemDesign.moviebookingSystem.controllers;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.BadInputRequestException;
import LowLoevelSystemDesign.moviebookingSystem.exceptions.InValidBookingStatusException;
import LowLoevelSystemDesign.moviebookingSystem.exceptions.NotFoundException;
import LowLoevelSystemDesign.moviebookingSystem.services.BookingService;
import LowLoevelSystemDesign.moviebookingSystem.services.PaymentService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class PaymentController {

  private final PaymentService paymentsService;
  private final BookingService bookingService;


  public void paymentFailed(@NonNull final String bookingId, @NonNull final String user)
      throws NotFoundException, BadInputRequestException {
    paymentsService.processPaymentFailed(bookingService.getBooking(bookingId), user);
  }

  public void paymentSuccess(@NonNull final String bookingId, @NonNull final String user)
      throws NotFoundException, BadInputRequestException, InValidBookingStatusException {
    bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
  }
}
