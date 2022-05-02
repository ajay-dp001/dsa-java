package LowLoevelSystemDesign.cabbookingsystem.model;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Location {

  private final double xCoordinate;
  private final double yCoordinate;

  public Double getDistance(final Location loc) {
    return sqrt(pow(this.xCoordinate - loc.xCoordinate, 2) + pow(this.yCoordinate - loc.yCoordinate, 2));
  }

}
