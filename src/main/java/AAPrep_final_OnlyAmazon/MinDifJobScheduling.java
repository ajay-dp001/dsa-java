package AAPrep_final_OnlyAmazon;

//https://www.youtube.com/watch?v=6EZVJWHt9Qg
//https://www.youtube.com/watch?v=pmQAtRZ3CuE
public class MinDifJobScheduling {

  public static void main(String[] args) {
    int day = 2;
    int[] jobDifficulty = {6, 5, 4, 3, 2, 1};
    System.out.println("Min Job Difficulty : " + minDifficulty(day, jobDifficulty));
  }

  public static int minDifficulty(int day, int[] jobDifficulty) {
    int job_len = jobDifficulty.length;
    if (day > job_len) {
      return -1;
    }

    int[][] dp = new int[day][job_len];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < day; i++) {
      for (int j = i; j < job_len; j++) {
        if (i == 0) {
          max = Math.max(max, jobDifficulty[j]);
          dp[i][j] = max;
        } else {
          max = Integer.MIN_VALUE;
          min = Integer.MAX_VALUE;
          for (int cut = j; cut >= i; cut--) {
            max = Math.max(max, jobDifficulty[cut]);
            min = Math.min(min, max + dp[i - 1][cut - 1]);
          }
          dp[i][j] = min;
        }
      }
    }
    return dp[day - 1][job_len - 1];
  }
}
