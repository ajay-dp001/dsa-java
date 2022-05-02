package matrix;

import java.util.Arrays;
import java.util.Stack;

public class SpiralAndDigonalTraversal {

  public static void main(String[] args) {
    int R = 3;
    int C = 6;
    int a[][] = {
        {1, 2, 3, 4, 5, 6},
        {7, 8, 9, 10, 11, 12},
        {13, 14, 15, 16, 17, 18}};

    //spiralPrint(R, C, a);

    int arr1[][] = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16},
        {17, 18, 19, 20},};

    int row = arr1.length;
    int col = arr1[0].length;
    //System.out.println();
    //diagonalTraversalRowWise(arr1, row, col);
    //System.out.println();
    //diagonalTraversalColWise(arr1, row, col);

    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int rows = matrix.length;
    int cols = matrix[0].length;
    diagonalTraversalRowWise(matrix, rows, cols);
    System.out.println();
    diagonalTraversalColWise(matrix, rows, cols);
    System.out.println();
    int[] result = diaZigZag(matrix, rows, cols);
    for (int nu : result) {
      System.out.print(nu + " ");
    }
  }

  private static int[] diaZigZag(int[][] matrix, int rowEnd, int colEnd) {
    if (matrix == null || matrix.length == 0) {
      return new int[0];
    }
    int rowBeg = 0, colBeg = 0;
    int[] result = new int[rowEnd * colEnd];

    for (int i = 0; i < result.length; i++) {
      result[i] = matrix[rowBeg][colBeg];
      if ((rowBeg + colBeg) % 2 == 0) {
        if (colBeg == colEnd - 1) {
          rowBeg++;
        } else if (rowBeg == 0) {
          colBeg++;
        } else {
          rowBeg--;
          colBeg++;
        }
      } else {
        if (rowBeg == rowEnd - 1) {
          colBeg++;
        } else if (colBeg == 0) {
          rowBeg++;
        } else {
          rowBeg++;
          colBeg--;
        }
      }
    }
    return result;

  }

  private static void diagonalTraversalRowWise(int[][] arr, int rowEnd, int colEnd) {
    for (int i = 0; i < rowEnd - 1; i++) {
      int row = i;
      int col = 0;
      while (row >= 0) {
        System.out.print(arr[row][col] + " ");
        row--;
        col++;
      }
      System.out.println();
    }

    for (int i = 0; i < colEnd; i++) {
      int row = rowEnd - 1;
      int col = i;
      while (col <= colEnd - 1) {
        System.out.print(arr[row][col] + " ");
        row--;
        col++;
      }
      System.out.println();
    }

  }

  private static void diagonalTraversalColWise(int[][] arr, int rowEnd, int colEnd) {
    for (int i = 0; i < rowEnd - 1; i++) {
      int row = i;
      int col = 0;
      while (row >= 0) {
        System.out.print(arr[col][row] + " ");
        row--;
        col++;
      }
      System.out.println();
    }

    for (int i = 0; i < colEnd; i++) {
      int row = rowEnd - 1;
      int col = i;
      while (col <= colEnd - 1) {
        System.out.print(arr[col][row] + " ");
        row--;
        col++;
      }
      System.out.println();
    }

  }

  private static void spiralPrint(int reIdx, int ceIdx, int[][] arr) {
    int rbIdx = 0, cbIdx = 0;

    while (rbIdx < reIdx && cbIdx < ceIdx) {
      for (int i = cbIdx; i < ceIdx; i++) {
        System.out.print(arr[rbIdx][i] + " ");
      }
      rbIdx++;

      for (int i = rbIdx; i < reIdx; i++) {
        System.out.print(arr[i][ceIdx - 1] + " ");
      }
      ceIdx--;

      if (rbIdx < reIdx) {
        for (int i = ceIdx - 1; i >= cbIdx; --i) {
          System.out.print(arr[reIdx - 1][i] + " ");
        }
        reIdx--;
      }

      if (cbIdx < ceIdx) {
        for (int i = reIdx - 1; i >= rbIdx; i--) {
          System.out.print(arr[i][cbIdx] + " ");
        }
        cbIdx++;
      }
    }
  }
}
