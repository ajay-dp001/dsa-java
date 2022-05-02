package LowLoevelSystemDesign.chesslld.chess.model;

import LowLoevelSystemDesign.chesslld.chess.conditions.PieceCellOccupyBlocker;
import LowLoevelSystemDesign.chesslld.chess.conditions.PieceCellOccupyBlockerFactory;
import LowLoevelSystemDesign.chesslld.chess.exceptions.PieceNotFoundException;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class Board {

  private final int boardSize;
  private final Cell[][] cells;

  public Board(@NonNull final int boardSize, @NonNull final Cell[][] cells) {
    this.cells = cells;
    this.boardSize = boardSize;
  }

  // Helper method to return cell to the left of current cell
  public Cell getLeftCell(final Cell cell) {
    return getCellAtLocation(cell.getX(), cell.getY() - 1);
  }

  // Helper method to return cell to the right of current cell
  public Cell getRightCell(final Cell cell) {
    return getCellAtLocation(cell.getX(), cell.getY() + 1);
  }

  // Helper method to return cell to the up of current cell
  public Cell getUpCell(final Cell cell) {
    return getCellAtLocation(cell.getX() + 1, cell.getY());
  }

  // Helper method to return cell to the down of current cell
  public Cell getDownCell(final Cell cell) {
    return getCellAtLocation(cell.getX() - 1, cell.getY());
  }

  public Cell getCellAtLocation(final int x, final int y) {
    if (x >= boardSize || x < 0) {
      return null;
    }
    if (y >= boardSize || y < 0) {
      return null;
    }
    return cells[x][y];
  }

  //Helper method to determine whether the player is on check on the current board.
  public boolean isPlayerOnCheck(Player player) throws PieceNotFoundException {
    return checkIfPieceCanBeKilled(player.getPiece(PieceType.KING),
        PieceCellOccupyBlockerFactory.kingCheckEvaluationBlockers(), player);
  }

  /**
   * Method to check if Piece can be killed currently by the opponent as per the current board configuration.
   *
   * @param targetPiece        Piece which has to be checked.
   * @param cellOccupyBlockers Blockers which make cell non occupiable.
   * @param player             player whose piece has to be changed.
   * @return Boolean  indicating whether the piece is in danger or not.
   */
  public boolean checkIfPieceCanBeKilled(final Piece targetPiece,
      final List<PieceCellOccupyBlocker> cellOccupyBlockers, final Player player)
      throws PieceNotFoundException {
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        Piece currentPiece = getCellAtLocation(i, j).getCurrentPiece();
        if (currentPiece != null && !currentPiece.isPieceFromSamePlayer(targetPiece)) {
          List<Cell> nextPossibleCells = currentPiece.nextPossibleCell(this, cellOccupyBlockers, player);
          if (nextPossibleCells.contains(targetPiece.getCurrentCell())) {
            return true;
          }
        }
      }
    }
    return false;
  }

}
