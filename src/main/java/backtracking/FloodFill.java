package backtracking;

public class FloodFill {

  public static void main(String[] args) {
    int[][] arr = {{0, 1, 0}, {0, 1, 1}, {0, 0, 0}};
    int n = 3, m = 3;
    boolean[][] visited = new boolean[n][m];
    floodFill(arr, 0, 0, "", visited);
  }

  public static void floodFill(int[][] arr, int row, int col, String psf, boolean[][] visited) {
    if (row < 0 || col < 0 || row == arr.length || col == arr[0].length || arr[row][col] == 1
        || visited[row][col]) {
      return;
    }
    if (row == arr.length - 1 && col == arr[0].length - 1) {
      System.out.println(psf);
      return;
    }
    visited[row][col] = true;
    floodFill(arr, row - 1, col, psf + "t", visited);
    floodFill(arr, row, col - 1, psf + "l", visited);
    floodFill(arr, row + 1, col, psf + "d", visited);
    floodFill(arr, row, col + 1, psf + "r", visited);
    visited[row][col] = false;
  }

}
