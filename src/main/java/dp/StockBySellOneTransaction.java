package dp;

public class StockBySellOneTransaction {

  public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    int lsf = Integer.MAX_VALUE;
    int op = 0, pifst = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < lsf) {
        lsf = prices[i];
      }
      pifst = prices[i] - lsf;
      if (pifst > op) {
        op = pifst;
      }
    }
    System.out.println(op);
  }
}
