package LowLoevelSystemDesign.chesslld.chess.conditions;

import LowLoevelSystemDesign.chesslld.chess.exceptions.PieceNotFoundException;
import LowLoevelSystemDesign.chesslld.chess.model.Board;
import LowLoevelSystemDesign.chesslld.chess.model.Cell;
import LowLoevelSystemDesign.chesslld.chess.model.Piece;
import LowLoevelSystemDesign.chesslld.chess.model.Player;

public interface PieceCellOccupyBlocker {

  boolean isCellNonOccuipiableForPiece(final Cell cell, final Piece piece, final Board board,
      final Player player) throws PieceNotFoundException;

}
