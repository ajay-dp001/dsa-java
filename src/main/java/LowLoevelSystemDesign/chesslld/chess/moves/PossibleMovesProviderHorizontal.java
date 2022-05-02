package LowLoevelSystemDesign.chesslld.chess.moves;

import LowLoevelSystemDesign.chesslld.chess.conditions.MoveBaseCondition;
import LowLoevelSystemDesign.chesslld.chess.conditions.PieceCellOccupyBlocker;
import LowLoevelSystemDesign.chesslld.chess.conditions.PieceMoveFurtherCondition;
import LowLoevelSystemDesign.chesslld.chess.exceptions.PieceNotFoundException;
import LowLoevelSystemDesign.chesslld.chess.model.Board;
import LowLoevelSystemDesign.chesslld.chess.model.Cell;
import LowLoevelSystemDesign.chesslld.chess.model.Piece;
import LowLoevelSystemDesign.chesslld.chess.model.Player;
import java.util.ArrayList;
import java.util.List;

public class PossibleMovesProviderHorizontal extends PossibleMoveProvider {

  public PossibleMovesProviderHorizontal(int maxSteps, MoveBaseCondition baseCondition,
      PieceMoveFurtherCondition moveFurtherCondition, PieceCellOccupyBlocker baseBlocker) {
    super(maxSteps, baseCondition, moveFurtherCondition, baseBlocker);
  }

  @Override
  protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board,
      List<PieceCellOccupyBlocker> additionalBlockers, Player player) throws PieceNotFoundException {
    List<Cell> result = new ArrayList<>();
    result.addAll(findAllNextMoves(piece, board::getLeftCell, board, additionalBlockers, player));
    result.addAll(findAllNextMoves(piece, board::getRightCell, board, additionalBlockers, player));
    return result;
  }
}
