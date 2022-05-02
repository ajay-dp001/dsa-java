package matrix;

public class MaxSizeSubMatrix {

  public static void main(String[] args) {
    int[][] arr = {
        {0, 1, 1, 0, 1},
        {1, 1, 1, 0, 0},
        {1, 1, 1, 1, 0},
        {1, 1, 1, 0, 1}};
    int result = maxSizeSubMatrix(arr);
    System.out.print(result);
  }

  private static int maxSizeSubMatrix(int[][] arr) {
    int[][] dp = new int[arr.length][arr[0].length];
    int max = 0;

    for (int i = 0; i < arr.length; i++) {
      dp[i][0] = arr[i][0];
      if (dp[i][0] == 1) {
        max = 1;
      }
    }

    for (int i = 0; i < arr[0].length; i++) {
      dp[0][i] = arr[0][i];
      if (dp[0][i] == 1) {
        max = 1;
      }
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[i].length; j++) {
        if (arr[i][j] == 1) {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
          max = Math.max(max, dp[i][j]);
        }
      }
    }
    return max;
  }

}
