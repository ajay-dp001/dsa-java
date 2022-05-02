package dp;

public class KnapSackProblemMatchMaxRun {

  public static void main(String[] args) {
    int capacity = 7;
    int[] weight = {2, 5, 1, 3, 4};
    int[] values = {15, 14, 10, 45, 30};
    int n = values.length;

    int[][] dp = new int[n + 1][capacity + 1];

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (j >= weight[i - 1]) {
          int rCap = j - weight[i - 1];
          if (dp[i - 1][rCap] + weight[i - 1] > dp[i - 1][j]) {
            dp[i][j] = dp[i - 1][rCap] + weight[i - 1];
          }else {
            dp[i][j] = dp[i-1][j];
          }
        }else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }
    System.out.println(dp[n][capacity]);
  }

}
