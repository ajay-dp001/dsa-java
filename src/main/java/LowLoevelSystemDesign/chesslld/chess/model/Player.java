package LowLoevelSystemDesign.chesslld.chess.model;

import LowLoevelSystemDesign.chesslld.chess.exceptions.PieceNotFoundException;
import LowLoevelSystemDesign.chesslld.gameplay.contracts.PlayerMove;
import java.util.List;
import lombok.Getter;

@Getter
public abstract class Player {

  List<Piece> pieces;

  public Player(List<Piece> pieces) {
    this.pieces = pieces;
  }

  public Piece getPiece(final PieceType pieceType) throws PieceNotFoundException {
    for (Piece piece : getPieces()) {
      if (piece.getPieceType() == pieceType) {
        return piece;
      }
    }
    throw new PieceNotFoundException("Piece Not Found.!");
  }
  abstract public PlayerMove makeMove();
}
