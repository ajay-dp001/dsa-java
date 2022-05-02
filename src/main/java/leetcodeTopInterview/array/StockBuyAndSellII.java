package leetcodeTopInterview.array;

public class StockBuyAndSellII {

  public static void main(String[] args) {
    int[] price = {7, 1, 5, 3, 6, 4};
    int[] price1 = {1, 2, 3, 4, 5};
    int[] price2 = {7, 6, 4, 3, 1};
    System.out.println("Max profit is  :" + maxProfit(price));
    System.out.println("Max profit is  :" + maxProfit(price1));
    System.out.println("Max profit is  :" + maxProfit(price2));
  }

  private static int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int profit = 0;
    for (int i = 0; i < prices.length-1; i++) {
      if (prices[i + 1] > prices[i]) {
        profit += prices[i + 1] - prices[i];
      }
    }
    return profit;
  }

}
