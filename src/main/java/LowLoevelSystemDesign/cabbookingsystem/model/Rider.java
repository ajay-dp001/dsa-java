package LowLoevelSystemDesign.cabbookingsystem.model;

import java.util.UUID;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Rider {

  private String riderId;
  private String riderName;

  public Rider(@NonNull final String riderName) {
    this.riderId = UUID.randomUUID().toString();
    this.riderName = riderName;
  }

}
