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

public class PossibleMovesProviderVertical extends PossibleMoveProvider {

  private VerticalMoveDirection verticalMoveDirection;

  public PossibleMovesProviderVertical(int maxSteps,
      MoveBaseCondition moveBaseCondition, PieceMoveFurtherCondition pieceMoveFurtherCondition,
      PieceCellOccupyBlocker baseBlocker, VerticalMoveDirection verticalMoveDirection) {
    super(maxSteps, moveBaseCondition, pieceMoveFurtherCondition, baseBlocker);
    this.verticalMoveDirection = verticalMoveDirection;
  }

  @Override
  protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board,
      List<PieceCellOccupyBlocker> additionalBlockers, Player player) throws PieceNotFoundException {
    List<Cell> result = new ArrayList<>();
    if (this.verticalMoveDirection == VerticalMoveDirection.UP || this.verticalMoveDirection == VerticalMoveDirection.BOTH) {
      result.addAll(findAllNextMoves(piece, board::getUpCell, board, additionalBlockers, player));
    }
    if (this.verticalMoveDirection == VerticalMoveDirection.DOWN || this.verticalMoveDirection == VerticalMoveDirection.BOTH) {
      result.addAll(findAllNextMoves(piece, board::getDownCell, board, additionalBlockers, player));
    }
    return result;
  }
}
