package LowLoevelSystemDesign.chesslld.chess.conditions;

import LowLoevelSystemDesign.chesslld.chess.model.Piece;

public interface MoveBaseCondition {

  boolean isBaseConditionFullFilled(final Piece piece);

}
