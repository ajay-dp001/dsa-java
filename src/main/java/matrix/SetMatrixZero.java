package matrix;

//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZero {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 1, 1, 1},
        {1, 0, 1, 1},
        {1, 1, 0, 1},
        {0, 0, 0, 1}};

    setMatrixZero(arr);
    // setMatrixZeroSnd(arr);
  }

  private static void setMatrixZero(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;

    boolean colZero = false;

    for (int i = 0; i < rows; i++) {
      if (matrix[i][0] == 0) {
        colZero = true;
      }
      for (int j = 1; j < cols; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 1; j--) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
      if (colZero) {
        matrix[i][0] = 0;
      }
    }
  }

  private static void setMatrixZeroSnd(int[][] arr) {
    int col0 = 1, rows = arr.length, cols = arr[0].length;

    for (int i = 0; i < rows; i++) {
      if (arr[i][0] == 0) {
        col0 = 0;
      }

      for (int j = 1; j < cols; j++) {
        if (arr[i][j] == 0) {
          arr[i][0] = arr[0][j] = 0;
        }
      }
    }

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 1; j--) {
        if (arr[i][0] == 0 || arr[0][j] == 0) {
          arr[i][j] = 0;
        }
      }
      if (col0 == 0) {
        arr[i][0] = 0;
      }
    }

    for (int[] ints : arr) {
      for (int j = 0; j < cols; j++) {
        System.out.print(ints[j]);
      }
    }
  }
}
