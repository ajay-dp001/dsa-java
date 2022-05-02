package LowLoevelSystemDesign.chesslld.chess.moves;

import LowLoevelSystemDesign.chesslld.chess.model.Cell;

public interface NextCellProvider {

  public Cell nextCell(final Cell cell);

}
