package dp;

public class CoinChange {

  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    int amt = 11;
    System.out.println(coinChange(coins, amt));
  }

  public static int coinChange(int[] coins, int amount) {
    int[] arr = new int[amount + 1];

    for (int i = 1; i < arr.length; i++) {
      arr[i] = amount + 1;
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < coins.length; j++) {
        // Get the amount by the amount represented by coin
        int temp = i - coins[j];
        // if the amount is not negative, calculate the min of arr[i] and arr[temp]+1 for amount i. We are doing +1 as we used a coin to reach our amount from temp amount.
        if (temp >= 0) {
          arr[i] = Math.min(arr[i], arr[temp] + 1);
        }
      }
    }
    if (arr[amount] <= amount) {
      return arr[amount];
    }
    return -1;
  }
}
