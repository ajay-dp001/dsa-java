package graph.miscgraph;

public class LongestIncreasingPathInMatrix {

  private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) {
    int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    System.out.println("Longest Increasing path is : " + longestIncreasingPath(matrix));
  }

  private static int longestIncreasingPath(int[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    int row = grid.length, col = grid[0].length, maxLen = 1;
    int[][] memo = new int[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int len = dfs(grid, i, j, row, col, memo);
        maxLen = Math.max(maxLen, len);
      }
    }
    return maxLen;
  }

  private static int dfs(int[][] grid, int i, int j, int row, int col, int[][] memo) {
    if (memo[i][j] > 0) {
      return memo[i][j];
    }
    int max = 0;
    for (int[] dir : directions) {
      int x = i + dir[0], y = j + dir[1];
      if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] > grid[i][j]) {
        max = Math.max(max, dfs(grid, x, y, row, col, memo));
      }
    }
    memo[i][j] = max + 1;
    return max + 1;
  }
}
