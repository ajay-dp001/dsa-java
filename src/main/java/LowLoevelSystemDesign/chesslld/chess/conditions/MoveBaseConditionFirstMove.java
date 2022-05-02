package LowLoevelSystemDesign.chesslld.chess.conditions;

import LowLoevelSystemDesign.chesslld.chess.model.Piece;

public class MoveBaseConditionFirstMove implements MoveBaseCondition {

  @Override
  public boolean isBaseConditionFullFilled(final Piece piece) {
    return piece.getNumberOfMoves() == 0;
  }

}
