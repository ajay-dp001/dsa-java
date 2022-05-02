package LowLoevelSystemDesign.chesslld.chess.conditions;

import LowLoevelSystemDesign.chesslld.chess.exceptions.PieceNotFoundException;
import LowLoevelSystemDesign.chesslld.chess.model.Board;
import LowLoevelSystemDesign.chesslld.chess.model.Cell;
import LowLoevelSystemDesign.chesslld.chess.model.Piece;
import LowLoevelSystemDesign.chesslld.chess.model.Player;

public class PieceCellOccupyBlockerSelfPiece implements PieceCellOccupyBlocker {

  @Override
  public boolean isCellNonOccuipiableForPiece(final Cell cell, final Piece piece, final Board board,
      final Player player) throws PieceNotFoundException {
    if (cell.isFree()) {
      return false;
    }
    return cell.getCurrentPiece().getColor().equals(piece.getColor());
  }
}
