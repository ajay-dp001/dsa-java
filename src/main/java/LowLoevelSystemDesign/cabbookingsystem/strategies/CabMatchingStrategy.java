package LowLoevelSystemDesign.cabbookingsystem.strategies;

import LowLoevelSystemDesign.cabbookingsystem.model.CabVehicle;
import LowLoevelSystemDesign.cabbookingsystem.model.Location;
import LowLoevelSystemDesign.cabbookingsystem.model.Rider;
import java.util.List;

public interface CabMatchingStrategy {

  public CabVehicle matchCabToRider(final Rider rider, final List<CabVehicle> cabVehicleList,
      final Location fromLoc, final Location toLoc);
}
