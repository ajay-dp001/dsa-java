package matrix;

public class DiagonalPrint {

  public static void main(String[] args) {
    int n = 4;
    int a[][] = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {1, 2, 3, 4},
        {5, 6, 7, 8}};

    printPrincipalDiagonal(a, n);
    System.out.println();
    printSecondaryDiagonal(a, n);
  }

  private static void printPrincipalDiagonal(int[][] arr, int len) {
    System.out.println("Principle Diagonal :");

    //On^2
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (i == j) {
          System.out.print(arr[i][j]+" ");
        }
      }
    }
    System.out.println();
    //On Approach
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i][i]+" ");
    }
  }

  private static void printSecondaryDiagonal(int[][] arr, int len) {
    System.out.println("secondary Diagonal :");

    //On^2
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if ((i + j) == (len - 1)) {
          System.out.print(arr[i][j] + " ");
        }
      }
    }
    System.out.println();
    //On Approach
    int j = len - 1;
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i][j--] + " ");
    }
  }
}
