package LowLoevelSystemDesign.tictactoe;

import java.util.Random;

public final class TicTacToeUtil {

  public static int getFirstMovePlayer(){
    return new Random().nextInt(2);
  }

}
