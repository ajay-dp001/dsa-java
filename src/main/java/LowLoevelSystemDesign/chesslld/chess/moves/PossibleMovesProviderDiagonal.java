package LowLoevelSystemDesign.chesslld.chess.moves;

import LowLoevelSystemDesign.chesslld.chess.conditions.MoveBaseCondition;
import LowLoevelSystemDesign.chesslld.chess.conditions.PieceCellOccupyBlocker;
import LowLoevelSystemDesign.chesslld.chess.conditions.PieceMoveFurtherCondition;
import LowLoevelSystemDesign.chesslld.chess.model.Board;
import LowLoevelSystemDesign.chesslld.chess.model.Cell;
import LowLoevelSystemDesign.chesslld.chess.model.Piece;
import LowLoevelSystemDesign.chesslld.chess.model.Player;
import java.util.List;

public class PossibleMovesProviderDiagonal extends PossibleMoveProvider {

  public PossibleMovesProviderDiagonal(final int maxStep, final MoveBaseCondition moveBaseCondition, final
  PieceMoveFurtherCondition pieceMoveFurtherCondition, final PieceCellOccupyBlocker pieceCellOccupyBlocker) {
    super(maxStep, moveBaseCondition, pieceMoveFurtherCondition, pieceCellOccupyBlocker);

  }

  @Override
  protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board,
      List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
    return null;
  }
}
