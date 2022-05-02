package Arrays;

public class MaxProfit {

  public static void main(String[] args) {
    int[] arr = new int[]{7, 1, 5, 3, 6, 4};
    System.out.println("Max Profit is:" + maxProfit(arr));
  }

  private static int maxProfit(int[] price) {
    int minprice = Integer.MAX_VALUE;
    int maxpofit = 0;
    for (int i = 0; i < price.length; i++) {
      if (price[i] < minprice) {
        minprice = price[i];
      } else if (price[i] - minprice > maxpofit) {
        maxpofit = price[i] - minprice;
      }
    }
    return maxpofit;
  }
}
