package LowLoevelSystemDesign.cabbookingsystem.strategies;

import LowLoevelSystemDesign.cabbookingsystem.model.Location;

public interface PricingStrategy {

  public double findPrice(final Location fromLoc, final Location toLoc);

}
