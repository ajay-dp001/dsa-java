package LowLoevelSystemDesign.sudokuSolver;

public class SudokuSolver {

  private static int GRID_SIZE = 9;

  public static void main(String[] args) {
    int[][] arr1 = {
        {3, 0, 0, 4, 0, 2, 0, 9, 0},
        {0, 0, 0, 0, 0, 9, 0, 6, 3},
        {0, 0, 7, 0, 6, 3, 1, 0, 0},
        {0, 9, 1, 7, 2, 6, 0, 8, 0},
        {0, 0, 0, 9, 0, 1, 0, 0, 0},
        {0, 2, 0, 3, 8, 5, 9, 1, 0},
        {0, 0, 8, 1, 9, 0, 2, 0, 0},
        {6, 7, 0, 2, 0, 0, 0, 0, 0},
        {0, 3, 0, 6, 0, 4, 0, 0, 9}
    };
    int[][] arr = {
        {0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 12, 0},
        {9, 0, 1, 5, 3, 0, 0, 0, 0, 4, 0, 0},
        {0, 0, 11, 2, 0, 0, 0, 0, 6, 0, 0, 9},
        {4, 11, 0, 0, 0, 5, 12, 0, 0, 3, 1, 0},
        {0, 0, 5, 0, 0, 0, 1, 0, 12, 0, 11, 0},
        {0, 6, 0, 12, 0, 0, 7, 11, 8, 0, 0, 2},
        {3, 0, 0, 1, 10, 9, 0, 0, 11, 0, 6, 0},
        {0, 9, 0, 6, 0, 4, 0, 0, 0, 8, 0, 0},
        {0, 5, 7, 0, 0, 6, 8, 0, 0, 0, 4, 12},
        {2, 0, 0, 9, 0, 0, 0, 0, 10, 7, 0, 0},
        {0, 0, 4, 0, 0, 0, 0, 10, 3, 1, 0, 5},
        {0, 7, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0}
    };
    solveBoard(arr1);

    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        System.out.print(arr1[i][j] + " ");
      }
      System.out.println();
    }

  }

  private static boolean isNumberInRow(int[][] board, int num, int row) {
    for (int i = 0; i < GRID_SIZE; i++) {
      if (board[row][i] == num) {
        return true;
      }
    }
    return false;
  }

  private static boolean isNumberInCol(int[][] board, int num, int col) {
    for (int i = 0; i < GRID_SIZE; i++) {
      if (board[i][col] == num) {
        return true;
      }
    }
    return false;
  }

  private static boolean isNumberInBox(int[][] board, int num, int row, int col) {
    int localBoxRow = row - row % 3;
    int localBoxCol = col - col % 3;
    for (int i = localBoxRow; i < localBoxRow + 3; i++) {
      for (int j = localBoxCol; j < localBoxCol + 3; j++) {
        if (board[i][i] == num) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isValidPlacement(int[][] board, int num, int row, int col) {

    boolean rowResult = isNumberInRow(board, num, row);
    boolean colResult = isNumberInCol(board, num, col);
    boolean boxResult = isNumberInBox(board, num, row, col);
    System.out.println("Num : " + num + " Row " + rowResult + " Col " + colResult + " Box" + boxResult);
    return !rowResult && !colResult && !boxResult;
  }

  private static boolean solveBoard(int[][] board) {
    for (int row = 0; row < GRID_SIZE; row++) {
      for (int col = 0; col < GRID_SIZE; col++) {
        if (board[row][col] == 0) {
          for (int numToTry = 1; numToTry <= GRID_SIZE; numToTry++) {
            if (isValidPlacement(board, numToTry, row, col)) {
              board[row][col] = numToTry;
              if (solveBoard(board)) {
                return true;
              } else {
                board[row][col] = 0;
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }
}
