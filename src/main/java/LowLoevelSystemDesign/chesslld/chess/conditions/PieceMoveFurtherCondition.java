package LowLoevelSystemDesign.chesslld.chess.conditions;

import LowLoevelSystemDesign.chesslld.chess.model.Board;
import LowLoevelSystemDesign.chesslld.chess.model.Cell;
import LowLoevelSystemDesign.chesslld.chess.model.Piece;

public interface PieceMoveFurtherCondition {

  boolean canPieceMoveFurtherFromCell(final Piece piece, final Cell cell, final Board board);

}
