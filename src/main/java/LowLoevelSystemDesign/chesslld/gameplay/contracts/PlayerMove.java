package LowLoevelSystemDesign.chesslld.gameplay.contracts;

import LowLoevelSystemDesign.chesslld.chess.model.Cell;
import LowLoevelSystemDesign.chesslld.chess.model.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerMove {

  final Piece piece;
  final Cell toCell;
}
