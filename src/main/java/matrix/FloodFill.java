package matrix;

public class FloodFill {

  public static void main(String[] args) {
    int[][] grid = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    int srcRow = 1, srcCol = 1, newColor = 2;
    int[][] resultImage = floodFill(grid, srcRow, srcCol, newColor);

    for (int i = 0; i < resultImage.length; i++) {
      for (int j = 0; j < resultImage[0].length; j++) {
        System.out.print(resultImage[i][j] + " ");
      }
    }
  }

  private static int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
    if (grid[sr][sc] == newColor) {
      return grid;
    }
    fill(grid, sr, sc, grid[sr][sc], newColor);
    return grid;
  }

  private static void fill(int[][] image, int i, int j, int color, int newColor) {
    if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color) {
      return;
    }
    image[i][j] = newColor;
    fill(image, i + 1, j, color, newColor);
    fill(image, i - 1, j, color, newColor);
    fill(image, i, j + 1, color, newColor);
    fill(image, i, j - 1, color, newColor);
  }
}
