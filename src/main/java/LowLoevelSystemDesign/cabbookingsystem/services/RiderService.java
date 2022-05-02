package LowLoevelSystemDesign.cabbookingsystem.services;

import LowLoevelSystemDesign.cabbookingsystem.exceptions.RiderAlreadyExistException;
import LowLoevelSystemDesign.cabbookingsystem.exceptions.RiderNotFoundException;
import LowLoevelSystemDesign.cabbookingsystem.model.Rider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.NonNull;

public class RiderService {

  private final Map<String, Rider> riders = new ConcurrentHashMap<>();

  public void createRider(@NonNull final Rider rider) throws RiderAlreadyExistException {
    if (riders.containsKey(rider)) {
      throw new RiderAlreadyExistException("Rider with riderId: " + rider.getRiderId() + " already exist.!");
    }

    riders.put(rider.getRiderId(), rider);
  }

  public Rider getRider(@NonNull final String riderId) throws RiderNotFoundException {
    if (!riders.containsKey(riderId)) {
      throw new RiderNotFoundException("Rider with riderId: " + riderId + " does not exist.!");
    }
    return riders.get(riderId);
  }

}
