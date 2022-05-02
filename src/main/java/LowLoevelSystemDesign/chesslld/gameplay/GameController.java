package LowLoevelSystemDesign.chesslld.gameplay;

import LowLoevelSystemDesign.chesslld.chess.conditions.PieceCellOccupyBlockerFactory;
import LowLoevelSystemDesign.chesslld.chess.exceptions.InvalidMoveException;
import LowLoevelSystemDesign.chesslld.chess.exceptions.PieceNotFoundException;
import LowLoevelSystemDesign.chesslld.chess.model.Board;
import LowLoevelSystemDesign.chesslld.chess.model.Player;
import LowLoevelSystemDesign.chesslld.gameplay.contracts.PlayerMove;
import java.util.List;

//https://www.youtube.com/watch?v=RVHNcng0oF0
public class GameController {

  public static void gameplay(List<Player> players, Board board)
      throws PieceNotFoundException, InvalidMoveException {
    int currentPlayer = 0;
    while (true) {
      Player player = players.get(currentPlayer);
      //TODO: Check if current player has any move possible. If no move possible, then its checkmate.
      PlayerMove playerMove = player.makeMove();
      playerMove.getPiece().move(player, playerMove.getToCell(), board,
          PieceCellOccupyBlockerFactory.defaultAdditionalBlocker());
      currentPlayer = (currentPlayer + 1) % players.size();
    }
  }
}
