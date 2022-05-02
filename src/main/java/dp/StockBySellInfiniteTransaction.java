package dp;

//https://www.youtube.com/watch?v=HWJ9kIPpzXs
public class StockBySellInfiniteTransaction {

  public static void main(String[] args) {
    int[] arr = {30, 40, 43, 50, 45, 20, 26, 40, 80, 50, 30, 15, 10, 25, 40, 45, 71, 50, 55};
    int ln = arr.length;

    int bd = 0;
    int sd = 0;
    int profit = 0;

    for (int i = 1; i < ln; i++) {
      if (arr[i] >= arr[i - 1]) {
        sd++;
      } else {
        profit += arr[sd] - arr[bd];
        bd = sd = i;
      }
    }

    profit += arr[sd] - arr[bd];
    System.out.println(profit);
  }
}
