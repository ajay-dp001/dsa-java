package LowLoevelSystemDesign.snakeladder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Piece {

  private final int startPoint;
  private final int endPoint;

}
