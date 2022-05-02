package LowLoevelSystemDesign.moviebookingSystem.controllers;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.NotFoundException;
import LowLoevelSystemDesign.moviebookingSystem.model.Screen;
import LowLoevelSystemDesign.moviebookingSystem.model.Theatre;
import LowLoevelSystemDesign.moviebookingSystem.services.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class TheatreController {

  final private TheatreService theatreService;

  public String createTheatre(@NonNull final String theatreName) {
    return theatreService.createTheatre(theatreName).getTheatreId();
  }

  public String createScreenInTheatre(@NonNull final String screenName, @NonNull final String theatreId)
      throws NotFoundException {
    final Theatre theatre = theatreService.getTheatre(theatreId);
    return theatreService.createScreenInTheatre(screenName, theatre).getScreenId();
  }

  public String createSeatInScreen(@NonNull final Integer rowNo, @NonNull final Integer seatNo,
      @NonNull final String screenId) throws NotFoundException {
    final Screen screen = theatreService.getScreen(screenId);
    return theatreService.createSeatInScreen(rowNo, seatNo, screen).getSeatId();
  }
}
