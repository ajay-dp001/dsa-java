package Aprepmustdoproblems;

public class NumberOfIsland {

  public static void main(String[] args) {
    int[][] arr = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
    countNoOfIsland(arr);
    System.out.println(countNoOfIslandEff(arr));
  }

  private static int countNoOfIslandEff(int[][] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    int numOfIsLands = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == '1') {
          numOfIsLands += dfs(arr, i, j);
        }
      }
    }
    return numOfIsLands;
  }

  private static int dfs(int[][] arr, int i, int j) {
    if (i < 0 || j < 0 || i >= arr.length || j >= arr[i].length || arr[i][j] == 0) {
      return 0;
    }
    arr[i][j] = '0';
    dfs(arr, i + 1, j);
    dfs(arr, i - 1, j);
    dfs(arr, i, j + 1);
    dfs(arr, i, j - 1);
    return 1;
  }

  private static void countNoOfIsland(int[][] arr) {
    int cnt = 0;
    boolean[][] visited = new boolean[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 0 && !visited[i][j]) {
          checkIsland(arr, i, j, visited);
          cnt++;
        }
      }
    }
    System.out.println("No of Island: " + cnt);
  }

  private static void checkIsland(int[][] arr, int i, int j, boolean[][] visited) {
    if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j]) {
      return;
    }
    visited[i][j] = true;
    checkIsland(arr, i - 1, j, visited);
    checkIsland(arr, i + 1, j, visited);
    checkIsland(arr, i, j - 1, visited);
    checkIsland(arr, i, j + 1, visited);
  }
}
