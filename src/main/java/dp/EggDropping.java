package dp;

public class EggDropping {

  public static void main(String[] args) {
    int num_of_egg = 3;
    int num_of_floor = 7;

    int[][] dp = new int[num_of_egg + 1][num_of_floor + 1];

    for (int i = 1; i <= num_of_egg; i++) {
      for (int j = 1; j <= num_of_floor; j++) {
        if (i == 1) {
          dp[i][j] = j;
        } else if (j == 1) {
          dp[i][j] = 1;
        } else {
          int min = Integer.MAX_VALUE;
          for (int mj = j - 1, pj = 0; mj >= 0; mj--, pj++) {
            int val1 = dp[i][mj];
            int val2 = dp[i - 1][pj];
            int val3 = Math.max(val1, val2);
            min = Math.min(val3, min);
          }
          dp[i][j] = min + 1;
        }
      }
    }
    System.out.println(dp[num_of_egg][num_of_floor]);
  }

}
