package LowLoevelSystemDesign.snakeladder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Dice {

  private final int numberOfDice;

  public int rollDice() {
    return ((int) (Math.random() * (6 * numberOfDice - 1 * numberOfDice)) + 1);
  }

}
