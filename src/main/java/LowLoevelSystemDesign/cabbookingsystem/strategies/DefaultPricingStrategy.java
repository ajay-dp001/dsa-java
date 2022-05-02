package LowLoevelSystemDesign.cabbookingsystem.strategies;

import LowLoevelSystemDesign.cabbookingsystem.model.Location;

public class DefaultPricingStrategy implements PricingStrategy {

  public static final double PER_KM_RATE = 10.0;

  @Override
  public double findPrice(Location fromLoc, Location toLoc) {
    return fromLoc.getDistance(toLoc) * PER_KM_RATE;
  }
}
