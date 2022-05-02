package LowLoevelSystemDesign.snakeladder;

import LowLoevelSystemDesign.snakeladder.models.Dice;
import LowLoevelSystemDesign.snakeladder.models.Ladder;
import LowLoevelSystemDesign.snakeladder.models.Player;
import LowLoevelSystemDesign.snakeladder.models.Snake;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class GameBoard {

  private final int boardSize;
  @Setter
  private List<Snake> boardSnakes;
  @Setter
  private List<Ladder> boardLadders;
  @Setter
  private Map<String, Integer> playerPieces;

  public GameBoard(@NonNull final int boardSize) {
    this.boardSize = boardSize;
    this.boardSnakes = new ArrayList<>();
    this.boardLadders = new ArrayList<>();
    this.playerPieces = new HashMap<>();
  }

}
