package matrix;

public class PrintZigZag2DMatrix {

  public static void main(String[] args) {
    int arr[][] = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11, 12, 13, 14, 15}};

    int row = arr.length;
    int col = arr[0].length;
    printZigZag(row, col, arr);
  }

  private static void printZigZag(int row, int col, int[][] arr) {
    int eR = 0, oR = 1;
    while (eR < row) {
      for (int i = 0; i < col; i++) {
        System.out.print(arr[eR][i] + " ");
      }
      System.out.println();
      eR += 2;
      if (oR < row) {
        for (int i = col - 1; i >= 0; i--) {
          System.out.print(arr[oR][i] + " ");
        }
        System.out.println();
      }
      oR += 2;
    }
  }

}
