package LowLoevelSystemDesign.chesslld.chess.conditions;

import java.util.List;

public class PieceCellOccupyBlockerFactory {

  public static PieceCellOccupyBlocker defaultBaseBlocker() {
    return new PieceCellOccupyBlockerSelfPiece();
  }

  public static List<PieceCellOccupyBlocker> defaultAdditionalBlocker() {
    return List.of(new PieceCellOccupyBlockerKingCheck());
  }

  public static List<PieceCellOccupyBlocker> kingCheckEvaluationBlockers() {
    return List.of();
  }

}
