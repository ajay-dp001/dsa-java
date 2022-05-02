package AAPrep_final_OnlyAmazon;

import java.util.Arrays;

public class GuessNumberHigherOrLower {
  static int[][] best;
  public static void main(String[] args) {
    int number = 10;
    long start_time = System.currentTimeMillis();
    System.out.println("Min Amount need to win is :" + getMoneyAmountNew(number));
    long end_time = System.currentTimeMillis();
    System.out.println("Total time :" + (end_time - start_time));
    long start_time_1 = System.currentTimeMillis();
    System.out.println("Min Amount need to win is :" + getMoneyAmount(number));
    long end_time_1 = System.currentTimeMillis();
    System.out.println("Total time :" + (end_time_1 - start_time_1));
  }

  private static int getMoney(int number) {
    int[][] dp = new int[number + 1][number + 1];
    getMoneyHelper(1, number, dp);
    return dp[1][number];
  }

  private static int getMoneyHelper(int start, int end, int[][] dp) {
    if (start >= end) {
      return 0;
    }
    if (dp[start][end] != 0) {
      return dp[start][end];
    }
    int minCost = Integer.MAX_VALUE;
    for (int i = start; i <= end; i++) {
      int cost = i + Math.max(getMoneyHelper(start, i - 1, dp), getMoneyHelper(i + 1, end, dp));
      minCost = Math.min(minCost, cost);
    }
    dp[start][end] = minCost;
    return minCost;
  }

  public static int getMoneyAmount(int n) {
    // idea is inspired from Metric Chain Multiplication maximum money require to guess the number from i to j
    final int[][] dp = new int[n][n];
    for (int gap = 0; gap < n; gap++) {
      for (int i = 0, j = gap; j < n; i++, j++) {
        if (gap == 0) {
          // gap 0 means we have only one number, if only one number then we can always guess it correctly,
          // so no money required for that
          dp[i][j] = 0;
        } else if (gap == 1) {
          // gap 1 means we have two numbers if we two numbers then we will always guess the smaller number,
          // in worst case if actual number is the larger one then we will pay price for smaller number guess
          dp[i][j] = Math.min(i + 1, j + 1); // plus one as indexing is 0 based
        } else {
          // after that it's interesting
          // say we have numbers from [i, j]
          // so we can guess any number k between [i, j]
          // to guess every number we will pay the cost equal to that (since indexing is 0 based so add 1)
          // say we guessed k between [i, j], now on left side we are left with [i, k -1] and right side [k+1, j]
          // so max money required will be max(dp[i][k-1], dp[k+1][j]) + (k + 1);
          // we need to minimize this maximum value
          dp[i][j] = Integer.MAX_VALUE;
          for (int k = i; k <= j; k++) {
            final int guess = k + 1;
            final int left = k == i ? 0 : dp[i][k - 1];
            final int right = k == j ? 0 : dp[k + 1][j];
            dp[i][j] = Math.min(guess + Math.max(left, right), dp[i][j]);
          }
        }
      }
    }
    return dp[0][n - 1];
  }

  public static int getMoneyAmountBottomUp(int n) {
    // dp[i][j] := min money you need to guarantee a win of picking i..j
    int[][] dp = new int[n + 2][n + 2];

    for (int d = 1; d < n; ++d) {
      for (int i = 1; i + d <= n; ++i) {
        final int j = i + d;
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j; ++k) {
          dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k - 1], dp[k + 1][j]) + k);
        }
      }
    }

    return dp[1][n];
  }

  public static int getMoneyAmountNew(int n) {
    best = new int[n + 1][n + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(best[i], -1);
    }
    return dp(1, n);
  }

  private static int dp(int lo, int hi) {
    if (lo >= hi) {
      return 0;
    } else {
      if (best[lo][hi] != -1) {
        return best[lo][hi];
      }
      //the idea is to  compute the maximum amount of money I need to pay with my guesses ranging from lo to hi.
      //Since I want to minimize my payoff, I'll choose the starting point [lo,hi] that has the minimum payoff.
      //But for each starting point, I'll choose the maximum amount of money I pay, since I need the worst case scenario.
      int res = Integer.MAX_VALUE;
      for (int i = lo; i <= hi; i++) {
        int op1 = 0; //guess = i, i was correct, no cost incurred
        int op2 = i + dp(lo, i - 1);//guess = i = wrong, go lo
        int op3 = i + dp(i + 1, hi);//guess = i = wrong, go hi
        int out = Math.max(op1, Math.max(op2, op3));
        res = Math.min(out, res);
      }
      best[lo][hi] = res;
      return res;
    }
  }
}
