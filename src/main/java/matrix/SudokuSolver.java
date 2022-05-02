package matrix;

//https://leetcode.com/problems/sudoku-solver/submissions/
// https://leetcode.com/problems/sudoku-solver/discuss/1417032/C%2B%2BJavaPython-Backtracking-with-Bitmasking-Efficient-and-Clean
public class SudokuSolver {

  public static void main(String[] args) {
    char[][] board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    solveSudoku(board);
  }

  private static void solveSudoku(char[][] board) {
    if (board == null || board.length == 0) {
      return;
    }
    System.out.println("Sudoku Can be Solved :" + solveSudokuUtil(board));

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static boolean solveSudokuUtil(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == '.') {
          for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, i, j, num)) {
              board[i][j] = num;
              if (solveSudokuUtil(board)) {
                return true;
              } else {
                board[i][j] = '.';
              }
            }
          }
          return false; // Not able to fill any number form 1-9 at i,j
        }
      }
    }
    return true;
  }

  private static boolean isValid(char[][] board, int row, int col, char num) {
    int blkRow = (row / 3) * 3;
    int blkCol = (col / 3) * 3;
    for (int i = 0; i < board.length; i++) {
      if (board[i][col] == num || board[row][i] == num || board[blkRow + i / 3][blkCol + i % 3] == num) {
        return false;
      }
    }
    return true;
  }
}
