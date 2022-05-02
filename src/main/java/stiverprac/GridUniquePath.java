package stiverprac;

public class GridUniquePath {

  public static void main(String[] args) {
    int[][] arr = new int[3][2];
    int m = 3, n = 2;
    System.out.println(countUniquePath(3, 2));

  }

  private static int countUniquePath(int m, int n) {
    int N = n + m - 2;
    int r = m - 1;
    double result = 1;

    for (int i = 1; i <= r; i++) {
      result = result * (N - r + i) / i;
    }
    return (int) result;
  }
}
