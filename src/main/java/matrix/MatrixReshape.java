package matrix;

public class MatrixReshape {

  public static void main(String[] args) {
    int[][] matrix = {{1, 2}, {3, 4}};
    int rows = 1;
    int cols = 4;
    int[][] result = reShape(matrix, rows, cols);

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        System.out.print(result[i][j] + " ");
      }
    }
  }

  private static int[][] reShape(int[][] matrix, int rows, int cols) {
    if (matrix.length * matrix[0].length != rows * cols) {
      return matrix;
    }
    int[][] resultMat = new int[rows][cols];
    int row = 0, col = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        resultMat[row][col] = matrix[i][j];
        col++;
        if (col == cols) {
          col = 0;
          row++;
        }
      }
    }
    return resultMat;
  }

}
