package matrix;

import java.util.Arrays;
import org.checkerframework.checker.units.qual.A;

public class CoinChange {

  public static void main(String[] args) {
    int[] arr = {1, 2, 5};
    int amount = 11;
    int result = coinChain(arr, amount);
    int result1 = coinChainPepAllCombinations(arr, amount);
    System.out.println(result);
    System.out.println(result1);
  }

  private static int coinChain(int[] coins, int amt) {
    Arrays.sort(coins);

    int[] dp = new int[amt + 1];
    Arrays.fill(dp, amt + 1);
    dp[0] = 0;

    for (int i = 0; i <= amt; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
        } else {
          break;
        }
      }
    }

    return dp[amt] > amt ? -1 : dp[amt];
  }

  private static int coinChainPepAllCombinations(int[] coins, int amt) {

    int[] dp = new int[amt + 1];
    dp[0] = 1;

    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j < dp.length; j++) {
        dp[j] += dp[j - coins[i]];
      }
    }
    return dp[amt];
  }
}
