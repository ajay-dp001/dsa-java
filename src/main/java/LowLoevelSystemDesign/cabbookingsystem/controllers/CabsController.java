package LowLoevelSystemDesign.cabbookingsystem.controllers;

import LowLoevelSystemDesign.cabbookingsystem.exceptions.CabAlreadyExistException;
import LowLoevelSystemDesign.cabbookingsystem.exceptions.CabNotFoundException;
import LowLoevelSystemDesign.cabbookingsystem.exceptions.TripNotFoundException;
import LowLoevelSystemDesign.cabbookingsystem.model.Location;
import LowLoevelSystemDesign.cabbookingsystem.model.SmallHatchBackCab;
import LowLoevelSystemDesign.cabbookingsystem.services.CabService;
import LowLoevelSystemDesign.cabbookingsystem.services.TripService;

/**
@RestController
public class CabsController {

  private final CabService cabService;
  private final TripService tripService;

  public CabsController(final CabService cabService, final TripService tripService) {
    this.cabService = cabService;
    this.tripService = tripService;
  }

  @PostMapping("/register/cab")
  public ResponseEntity registerCab(final String cabId, final String driverName)
      throws CabAlreadyExistException {
    cabService.createNewCab(new SmallHatchBackCab(cabId, driverName));
    return ResponseEntity.ok("");
  }

  @PostMapping("/update/cab/location")
  public ResponseEntity updateCabLocation(final String cabId, final double newX, final double newY)
      throws CabNotFoundException {
    cabService.updateCabLocation(cabId, new Location(newX, newY));
    return ResponseEntity.ok("");
  }

  @PostMapping("/update/cab/availability")
  public ResponseEntity updateCabAvailability(final String cabId, final boolean newAvailability)
      throws CabNotFoundException {
    cabService.updateCabAvailability(cabId, newAvailability);
    return ResponseEntity.ok("");
  }

  @PostMapping("/update/cab/end/trip")
  public ResponseEntity endTrip(final String cabId) throws CabNotFoundException, TripNotFoundException {
    tripService.endTrip(cabService.getCab(cabId));
    return ResponseEntity.ok("");
  }
}
*/
