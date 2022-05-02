package LowLoevelSystemDesign.cabbookingsystem.services;

import LowLoevelSystemDesign.cabbookingsystem.exceptions.CabAlreadyExistException;
import LowLoevelSystemDesign.cabbookingsystem.exceptions.CabNotFoundException;
import LowLoevelSystemDesign.cabbookingsystem.model.CabVehicle;
import LowLoevelSystemDesign.cabbookingsystem.model.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.NonNull;

public class CabService {

  private final Map<String, CabVehicle> cabs = new ConcurrentHashMap<>();

  public void createNewCab(@NonNull final CabVehicle newCab) throws CabAlreadyExistException {
    if (cabs.containsKey(newCab.getCabId())) {
      throw new CabAlreadyExistException("Cab with cabId: " + newCab.getCabId() + " already exist.!");
    }
    cabs.put(newCab.getCabId(), newCab);
  }

  public CabVehicle getCab(@NonNull final String cabId) throws CabNotFoundException {
    if (!cabs.containsKey(cabId)) {
      throw new CabNotFoundException("Cab with cabId: " + cabId + " dose not exist.!");
    }
    return cabs.get(cabId);
  }

  public void updateCabLocation(@NonNull final String cabId, @NonNull final Location cabNewLocation)
      throws CabNotFoundException {
    if (!cabs.containsKey(cabId)) {
      throw new CabNotFoundException("Cab with cabId: " + cabId + " dose not exist.!");
    }
    cabs.get(cabId).setCabCurrentLocation(cabNewLocation);
  }

  public void updateCabAvailability(@NonNull final String cabId, @NonNull final boolean newCanAvailability)
      throws CabNotFoundException {
    if (!cabs.containsKey(cabId)) {
      throw new CabNotFoundException("Cab with cabId: " + cabId + " dose not exist.!");
    }
    cabs.get(cabId).setAvailable(newCanAvailability);
  }

  public List<CabVehicle> getCabs(@NonNull final Location fromLocation, @NonNull final double distance) {
    final List<CabVehicle> cabList = new ArrayList<>();
    for (CabVehicle cab : cabs.values()) {
      if (cab.isAvailable() && cab.getCabCurrentLocation().getDistance(fromLocation) <= distance) {
        cabList.add(cab);
      }
    }
    return cabList;
  }

}
