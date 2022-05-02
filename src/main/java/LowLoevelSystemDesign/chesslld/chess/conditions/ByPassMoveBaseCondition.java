package LowLoevelSystemDesign.chesslld.chess.conditions;

import LowLoevelSystemDesign.chesslld.chess.model.Piece;

public class ByPassMoveBaseCondition implements MoveBaseCondition {

  @Override
  public boolean isBaseConditionFullFilled(final Piece piece) {
    return true;
  }

}
