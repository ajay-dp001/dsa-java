package AAAMSPrepare.dp;

import java.util.ArrayDeque;
import java.util.Deque;

public class TargetSumSubSet {

  private static class Pair {

    int i, j;
    String psf;

    public Pair(int i, int j, String psf) {
      this.i = i;
      this.j = j;
      this.psf = psf;
    }
  }

  public static void main(String[] args) {
    int[] arr = {3, 34, 4, 12, 5, 2};
    int sum = 9;
    int len = arr.length;

    if (targetSubSetSum(arr, len, sum)) {
      System.out.println("Found Subset");
    } else {
      System.out.println("No SubSet Exist..");
    }
    targetSumSubSetDp(arr, len, sum);
  }

  //Recursive 2^N
  private static boolean targetSubSetSum(int[] arr, int len, int sum) {
    if (sum == 0) {
      return true;
    }
    if (len == 0) {
      return false;
    }
    if (arr[len - 1] > sum) {
      return targetSubSetSum(arr, len - 1, sum);
    }
    return targetSubSetSum(arr, len - 1, sum) || targetSubSetSum(arr, len - 1, sum - arr[len - 1]);
  }

  //https://www.youtube.com/watch?v=qtqMTgmDpQg
  private static void targetSumSubSetDp(int[] arr, int len, int sum) {
    boolean[][] dp = new boolean[len + 1][sum + 1];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (i == 0) {
          dp[i][j] = false;
        } else if (j == 0) {
          dp[i][j] = true;
        } else {
          if (dp[i - 1][j]) {
            dp[i][j] = true;
          } else {
            int val = arr[i - 1];
            if (j >= val) {
              if (dp[i - 1][j - val]) {
                dp[i][j] = true;
              }
            }
          }
        }
      }
    }
    System.out.println(dp[len][sum]);

    Deque<Pair> dq = new ArrayDeque<>();
    dq.add(new Pair(len, sum, ""));

    while (!dq.isEmpty()) {
      Pair pair = dq.remove();

      if (pair.i == 0 || pair.j == 0) {
        System.out.println(pair.psf);
      } else {
        if (pair.j >= arr[pair.i - 1]) {
          boolean inc = dp[pair.i - 1][pair.j - arr[pair.i - 1]];
          if (inc) {
            dq.add(new Pair(pair.i, pair.j - arr[pair.i - 1], (pair.i - 1) + " " + pair.psf));
          }
        }
        boolean exc = dp[pair.i - 1][pair.j];
        if (exc) {
          dq.add(new Pair(pair.i - 1, pair.j, pair.psf));
        }
      }
    }
  }
}
