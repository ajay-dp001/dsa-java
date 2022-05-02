package LowLoevelSystemDesign.tictactoe;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Player {

  private int playerId;
  private int playerRanking;
  private char playerSymbol;
  private String playerName;

}
