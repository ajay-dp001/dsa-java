package matrix;

public class RotateMatrix {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};

    int[][] arr1 = {
        {5, 1, 9, 11},
        {2, 4, 8, 10},
        {13, 3, 6, 7},
        {15, 14, 12, 16}};

    rotate2DMatrix(arr);

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void rotate2DMatrix(int[][] arr) {
    int len = arr.length;

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < i; j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
      }
    }

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < (len / 2); j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[i][len - 1 - j];
        arr[i][len - 1 - j] = temp;
      }
    }
  }

}
