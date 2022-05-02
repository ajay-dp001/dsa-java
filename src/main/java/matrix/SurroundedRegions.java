package matrix;

public class SurroundedRegions {

  public static void main(String[] args) {
    char[][] charArr = {
        {'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}};
    solve(charArr);

    for (int i = 0; i < charArr.length; i++) {
      for (int j = 0; j < charArr[i].length; j++) {
        System.out.print(charArr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void solve(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return;
    }
    int rows = grid.length;
    int cols = grid[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1 && grid[i][j] == '0') {
          dfs(grid, rows, cols, i, j);
        }
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == '@') {
          grid[i][j] = '0';
        } else if (grid[i][j] == 'O') {
          grid[i][j] = 'X';
        }
      }
    }
  }


  private static void dfs(char[][] grid, int rows, int cols, int i, int j) {
    if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != 'O') {
      return;
    }
    grid[i][j] = '@';
    dfs(grid, rows, cols, i + 1, j);
    dfs(grid, rows, cols, i - 1, j);
    dfs(grid, rows, cols, i, j + 1);
    dfs(grid, rows, cols, i, j - 1);
  }

}
