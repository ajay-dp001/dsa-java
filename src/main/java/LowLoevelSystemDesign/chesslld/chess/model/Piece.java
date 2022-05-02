package LowLoevelSystemDesign.chesslld.chess.model;

import LowLoevelSystemDesign.chesslld.chess.conditions.PieceCellOccupyBlocker;
import LowLoevelSystemDesign.chesslld.chess.exceptions.InvalidMoveException;
import LowLoevelSystemDesign.chesslld.chess.exceptions.PieceNotFoundException;
import LowLoevelSystemDesign.chesslld.chess.moves.PossibleMoveProvider;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Model class representing a single Piece which can be moved on Board.
 */
@Getter
public class Piece {

  private int numberOfMoves;
  private final Color color;
  private final PieceType pieceType;
  private boolean isKilled = false;
  private final List<PossibleMoveProvider> moveProviders;

  @Setter
  @NonNull
  private Cell currentCell;

  public Piece(@NonNull final Color color, @NonNull final List<PossibleMoveProvider> possibleMoveProviders,
      @NonNull final PieceType pieceType) {
    this.color = color;
    this.pieceType = pieceType;
    this.moveProviders = possibleMoveProviders;
  }

  public void KillPiece() {
    this.isKilled = true;
  }

  /**
   * Method to move Piece from current cell to given cell
   */
  public void move(final Player player, final Cell toCell, final Board board,
      final List<PieceCellOccupyBlocker> additionalBlockers)
      throws InvalidMoveException, PieceNotFoundException {
    if (isKilled) {
      throw new InvalidMoveException("Killed Piece can not make a move..!!");
    }

    List<Cell> nextPossibleCells = nextPossibleCell(board, additionalBlockers, player);
    if (!nextPossibleCells.contains(toCell)) {
      throw new InvalidMoveException("Cant Make this move");
    }
    killPieceInCell(toCell);
    this.currentCell.setCurrentPiece(null);
    this.currentCell = toCell;
    this.currentCell.setCurrentPiece(this);
    this.numberOfMoves++;
  }

  /**
   * Helper method to kill Piece on a given Cell
   *
   * @param targetCell
   */
  private void killPieceInCell(final Cell targetCell) {
    if (targetCell.getCurrentPiece() != null) {
      targetCell.getCurrentPiece().KillPiece();
    }
  }

  /**
   * Method which tells what are the next possible cells to which current Piece can move form current Cell.
   *
   * @param board              Board on which teh piece is present.
   * @param additionalBlockers Blocker which make a cell non-occupiable for current Piece
   * @param player             Player who owns the Piece
   * @return List of All next Possible cells.
   */
  public List<Cell> nextPossibleCell(final Board board,
      final List<PieceCellOccupyBlocker> additionalBlockers,
      final Player player) throws PieceNotFoundException {
    List<Cell> resultCells = new ArrayList<>();
      for (PossibleMoveProvider moveProvider : this.moveProviders) {
      List<Cell> cells = moveProvider.possibleMoves(this, board, additionalBlockers, player);
      if (cells != null) {
        resultCells.addAll(cells);
      }
    }
    return resultCells;
  }

  /**
   * Helper method to check if Piece belong to same player.
   *
   * @param piece Piece which need to be validated.
   * @return boolean true if color matches.
   */
  public boolean isPieceFromSamePlayer(final Piece piece) {
    return piece.getColor().equals(this.color);
  }

}
