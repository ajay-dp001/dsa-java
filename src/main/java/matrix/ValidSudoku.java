package matrix;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings
/*
  '4' in row 7 is encoded as "(4)7".
  '4' in column 7 is encoded as "7(4)".
  '4' in the top-right block is encoded as "0(4)2".
 */
public class ValidSudoku {

  //https://leetcode.com/problems/valid-sudoku/discuss/1414911
  public static void main(String[] args) {
    char[][] board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    System.out.println("Sudoku is valid :" + isValidSudoku(board));
  }

  private static boolean isValidSudoku(char[][] grid) {
    Set<String> seen = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] != '.') {
          String num = "(" + grid[i][j] + ")";
          if (!seen.add(num + i) || !seen.add(j + num) || !seen.add(i / 3 + num + j / 3)) {
            return false;
          }
           /*
            char num = grid[i][j];
            if (!seen.add(num + " in row " + i) ||
                !seen.add(num + " in col " + j) ||
                !seen.add(num + " in block " + i / 3 + "-" + j / 3)) {
              return false;
            }
          */
        }
      }
    }
    return true;
  }
}
