package matrix;

public class MatrixTranspose {

  public static void main(String[] args) {
    int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5, 6}};

    printMatrix(matrixTranspose(arr));
    System.out.println();
    printMatrix(matrixTransposeInPlace(arr));
  }

  private static int[][] matrixTranspose(int[][] arr) {
    int[][] new_matrix;

    int row = arr.length;
    int col = arr[0].length;

    if (row != col) {
      new_matrix = new int[col][row];
      for (int i = 0; i < col; i++) {
        for (int j = 0; j < row; j++) {
          new_matrix[i][j] = arr[j][i];
        }
      }
    } else {
      new_matrix = new int[row][col];
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          new_matrix[i][j] = arr[j][i];
        }
      }
    }
    return new_matrix;
  }

  private static int[][] matrixTransposeInPlace(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
      }
    }
    return arr;
  }

  private static void printMatrix(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

}
