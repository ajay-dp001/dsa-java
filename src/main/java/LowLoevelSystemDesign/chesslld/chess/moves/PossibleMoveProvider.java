package LowLoevelSystemDesign.chesslld.chess.moves;

import LowLoevelSystemDesign.chesslld.chess.conditions.MoveBaseCondition;
import LowLoevelSystemDesign.chesslld.chess.conditions.PieceCellOccupyBlocker;
import LowLoevelSystemDesign.chesslld.chess.conditions.PieceMoveFurtherCondition;
import LowLoevelSystemDesign.chesslld.chess.exceptions.PieceNotFoundException;
import LowLoevelSystemDesign.chesslld.chess.model.Board;
import LowLoevelSystemDesign.chesslld.chess.model.Cell;
import LowLoevelSystemDesign.chesslld.chess.model.Piece;
import LowLoevelSystemDesign.chesslld.chess.model.Player;
import java.util.ArrayList;
import java.util.List;

public abstract class PossibleMoveProvider {

  private final int maxSteps;
  private final MoveBaseCondition moveBaseCondition;
  private final PieceMoveFurtherCondition pieceMoveFurtherCondition;
  private final PieceCellOccupyBlocker baseBlocker;

  public PossibleMoveProvider(final int maxSteps, final MoveBaseCondition moveBaseCondition,
      final PieceMoveFurtherCondition pieceMoveFurtherCondition, final PieceCellOccupyBlocker baseBlocker) {
    this.maxSteps = maxSteps;
    this.moveBaseCondition = moveBaseCondition;
    this.pieceMoveFurtherCondition = pieceMoveFurtherCondition;
    this.baseBlocker = baseBlocker;
  }

  /**
   * Method gives all possible cells which can be reached via current type of move.
   *
   * @param piece
   * @param board
   * @param additionalBlockers
   * @param player
   * @return
   */
  public List<Cell> possibleMoves(final Piece piece, final Board board,
      final List<PieceCellOccupyBlocker> additionalBlockers, final Player player)
      throws PieceNotFoundException {
    if (moveBaseCondition.isBaseConditionFullFilled(piece)) {
      return possibleMovesAsPerCurrentType(piece, board, additionalBlockers, player);
    }
    return null;
  }

  /**
   * Abstract Method need to be implemented by eah type of move to give possible move as per their behaviour.
   *
   * @param piece
   * @param board
   * @param additionalBlockers
   * @param player
   * @return
   */
  protected abstract List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board,
      List<PieceCellOccupyBlocker> additionalBlockers, Player player) throws PieceNotFoundException;


  protected List<Cell> findAllNextMoves(final Piece piece, final NextCellProvider nextCellProvider,
      final Board board, final List<PieceCellOccupyBlocker> cellOccupyBlockers, final Player player)
      throws PieceNotFoundException {
    final List<Cell> result = new ArrayList<>();
    Cell nextCell = nextCellProvider.nextCell(piece.getCurrentCell());
    int numStep = 1;
    while (nextCell != null && numStep <= maxSteps) {
      if (checkIfCellCanBeOccupied(piece, nextCell, board, cellOccupyBlockers, player)) {
        result.add(nextCell);
      }
      if (!pieceMoveFurtherCondition.canPieceMoveFurtherFromCell(piece, nextCell, board)) {
        break;
      }
      nextCell = nextCellProvider.nextCell(nextCell);
      numStep++;
    }
    return result;
  }

  private boolean checkIfCellCanBeOccupied(Piece piece, Cell cell, Board board,
      List<PieceCellOccupyBlocker> additionalBlockers, Player player) throws PieceNotFoundException {
    if (baseBlocker != null && baseBlocker.isCellNonOccuipiableForPiece(cell, piece, board, player)) {
      return false;
    }
    for (PieceCellOccupyBlocker cellOccupyBlocker : additionalBlockers) {
      if (cellOccupyBlocker.isCellNonOccuipiableForPiece(cell, piece, board, player)) {
        return false;
      }
    }
    return true;
  }
}
