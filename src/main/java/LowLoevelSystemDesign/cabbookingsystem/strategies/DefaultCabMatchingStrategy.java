package LowLoevelSystemDesign.cabbookingsystem.strategies;

import LowLoevelSystemDesign.cabbookingsystem.model.CabVehicle;
import LowLoevelSystemDesign.cabbookingsystem.model.Location;
import LowLoevelSystemDesign.cabbookingsystem.model.Rider;
import java.util.List;
import lombok.NonNull;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {

  @Override
  public CabVehicle matchCabToRider(@NonNull final Rider rider,
      @NonNull final List<CabVehicle> cabVehicleList,
      @NonNull final Location fromLoc, @NonNull final Location toLoc) {
    if (!cabVehicleList.isEmpty()) {
      return cabVehicleList.get(0);
    }
    return null;
  }
}
