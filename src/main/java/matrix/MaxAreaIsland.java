package matrix;

public class MaxAreaIsland {

  public static void main(String[] args) {
    int[][] grid = {
        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1}};

    //System.out.println("Max Area of Island is :" + numOfIsland(grid));
    System.out.println("Max Area of Island is :" + findMaxArea(grid));
  }

  private static int findMaxArea(int[][] grid) {
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, dfs(grid, i, j));
        }
      }
    }
    return max;
  }

  private static int dfs(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
      return 0;
    }
    grid[i][j] = 0;
    int cnt = 1;
    cnt += dfs(grid, i + 1, j);
    cnt += dfs(grid, i - 1, j);
    cnt += dfs(grid, i, j + 1);
    cnt += dfs(grid, i, j - 1);
    return cnt;
  }

  private static int numOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int numIslands = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          numIslands += dfsNumOfIsland(grid, i, j);
        }
      }
    }
    return numIslands;
  }

  private static int dfsNumOfIsland(int[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
      return 0;
    }
    grid[i][j] = 0;
    dfsNumOfIsland(grid, i + 1, j);
    dfsNumOfIsland(grid, i - 1, j);
    dfsNumOfIsland(grid, i, j + 1);
    dfsNumOfIsland(grid, i, j - 1);
    return 1;
  }
}
