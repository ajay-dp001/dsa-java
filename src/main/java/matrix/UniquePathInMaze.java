package matrix;

import java.util.Arrays;

public class UniquePathInMaze {

  static int[][] dp;

  public static void main(String[] args) {
    int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    int[][] grid1 = {{0, 1}, {0, 0}};
    System.out.println("Unique path are :" + uniquePath(grid));
    int[][] grid2 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    System.out.println("Unique path are :" + uniquePathsWithObstacles(grid2));

  }

  private static int uniquePath(int m, int n) {
    int[][] dp = new int[m][n];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[m - 1][n - 1];
  }

  //TopDown Approach
  private static int uniquePath(int[][] grid) {
    if (grid[0][0] == 1) {
      return 0;
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        //First Row && First Col
        if (i == 0 || j == 0) {
          if (grid[i][j] == 1 || (i != 0 && grid[i - 1][j] == 0) || (j != 0 && grid[i][j - 1] == 0)) {
            grid[i][j] = 0;
          } else {
            grid[i][j] = 1;
          }
        } else { //All the other Cells
          if (grid[i][j] == 1) {
            grid[i][j] = 0;
          } else {
            grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
          }
        }
      }
    }
    return grid[grid.length - 1][grid[0].length - 1];
  }

  //Bottom  Up Approach using Memoization.
  private static int uniquePathBruteFore(int[][] grid) {
    dp = new int[grid.length][grid[0].length];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return dfs(grid, 0, 0);
  }

  private static int dfs(int[][] grid, int row, int col) {
    //Exit condition
    if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 1) {
      return 0;
    }
    if (row == grid.length - 1 && col == grid[0].length - 1) {
      return 1;
    }
    if (dp[row][col] >= 0) {
      return dp[row][col];
    }
    dp[row][col] = dfs(grid, row, col + 1) + dfs(grid, row + 1, col);
    return dp[row][col];
  }

  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int R = obstacleGrid.length;
    int C = obstacleGrid[0].length;

    // If the starting cell has an obstacle, then simply return as there would be
    // no paths to the destination.
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }

    // Number of ways of reaching the starting cell = 1.
    obstacleGrid[0][0] = 1;

    // Filling the values for the first column
    for (int i = 1; i < R; i++) {
      obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
    }

    // Filling the values for the first row
    for (int i = 1; i < C; i++) {
      obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
    }

    // Starting from cell(1,1) fill up the values
    // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
    // i.e. From above and left.
    for (int i = 1; i < R; i++) {
      for (int j = 1; j < C; j++) {
        if (obstacleGrid[i][j] == 0) {
          obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
        } else {
          obstacleGrid[i][j] = 0;
        }
      }
    }

    // Return value stored in rightmost bottommost cell. That is the destination.
    return obstacleGrid[R - 1][C - 1];
  }
}
