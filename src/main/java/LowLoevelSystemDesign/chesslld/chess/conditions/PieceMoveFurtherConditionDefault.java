package LowLoevelSystemDesign.chesslld.chess.conditions;

import LowLoevelSystemDesign.chesslld.chess.model.Board;
import LowLoevelSystemDesign.chesslld.chess.model.Cell;
import LowLoevelSystemDesign.chesslld.chess.model.Piece;
import org.jetbrains.annotations.NotNull;

public class PieceMoveFurtherConditionDefault implements PieceMoveFurtherCondition{

  @Override
  public boolean canPieceMoveFurtherFromCell(Piece piece, @NotNull Cell cell, Board board) {
    return cell.isFree();
  }
}
