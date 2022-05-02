package matrix;

import java.util.Arrays;

public class MinPathSumMatrix {

  public static void main(String[] args) {
    int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    int row = grid.length - 1;
    int col = grid[0].length - 1;

    // Recursive Approach (2^3)
    System.out.println(minSumPathRecursion(grid, row, col));

    // Memoization Approach (2^3)
    int[][] dp = new int[row + 1][col + 1];
    for (int[] dpRow : dp) {
      Arrays.fill(dpRow, -1);
    }
    System.out.println(minSumPathMemoization(grid, row, col, dp));

    // Tabulation Approach (2^3)
    System.out.println(minSumPathTabulation(grid));

    // Tabulation Approach (2^3)
    System.out.println(minSumPathTabulationLessCode(grid));

    // Tabulation Approach (2^3)
    System.out.println(minSumPathTabulationEff(grid));
  }

  private static int minSumPathTabulationLessCode(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (i == 0 && j == 0) {
          dp[0][0] = grid[0][0];
        } else {
          dp[i][j] = grid[i][j] + Math.min(
              (i == 0) ? (int) 1e9 : dp[i - 1][j],
              (j == 0) ? (int) 1e9 : dp[i][j - 1]);
        }
      }
    }
    return dp[grid.length - 1][grid[0].length - 1];
  }

  private static int minSumPathTabulationEff(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        dp[i][j] = grid[i][j];
        if (i > 0 && j > 0) {
          dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
        } else if (i > 0) {
          dp[i][j] += dp[i - 1][j];
        } else if (j > 0) {
          dp[i][j] += dp[i][j - 1];
        }
      }
    }
    return dp[grid.length - 1][grid[0].length - 1];
  }

  private static int minSumPathTabulation(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];

    dp[0][0] = grid[0][0];

    for (int i = 1; i < grid.length; i++) {
      dp[0][i] = dp[0][i - 1] + grid[0][i];
    }

    for (int i = 1; i < grid[0].length; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }

    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[i].length; j++) {
        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);

      }
    }
    return dp[grid.length - 1][grid[0].length - 1];
  }

  private static int minSumPathRecursion(int[][] grid, int row, int col) {
    if (row == 0 && col == 0) {
      return grid[row][col];
    }
    if (row < 0 || col < 0) {
      return (int) 1e9; //Integer.MAX
    }

    int up = grid[row][col] + minSumPathRecursion(grid, row - 1, col);
    int left = grid[row][col] + minSumPathRecursion(grid, row, col - 1);
    return Math.min(up, left);
  }

  private static int minSumPathMemoization(int[][] grid, int row, int col, int[][] dp) {
    if (row == 0 && col == 0) {
      return grid[row][col];
    }
    if (row < 0 || col < 0) {
      return (int) 1e9; //Integer.MAX
    }
    if (dp[row][col] != -1) {
      return dp[row][col];
    }
    int up = grid[row][col] + minSumPathRecursion(grid, row - 1, col);
    int left = grid[row][col] + minSumPathRecursion(grid, row, col - 1);
    return dp[row][col] = Math.min(up, left);
  }
}

