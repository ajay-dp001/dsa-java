package dp;

// Stock By and Sell with Cool Down : https://www.youtube.com/watch?v=GY0O57llkKQ
//For K Transaction : https://www.youtube.com/watch?v=3YILP-PdEJA&list=RDCMUC7rNzgC2fEBVpb-q_acpsmw&start_radio=1&rv=3YILP-PdEJA&t=18
//https://www.youtube.com/watch?v=wuzTpONbd-0&t=17s
public class StockBySellTwoTransaction {

  public static void main(String[] args) {
    int[] arr = {30, 40, 43, 50, 45, 20, 26, 40, 80, 50, 30, 15, 10, 25, 40, 45, 71, 50, 55};
    int ln = arr.length;
    maxProfitStockSell(arr, ln);
  }

  private static void maxProfitStockSell(int[] arr, int ln) {
    int mpist = 0;
    int leastSofar = arr[0];
    int[] dpLeft = new int[ln];

    for (int i = 1; i < ln; i++) {
      if (arr[i] < leastSofar) {
        leastSofar = arr[i];
      }
      mpist = arr[i] - leastSofar;
      if (mpist > dpLeft[i - 1]) {
        dpLeft[i] = mpist;
      } else {
        dpLeft[i] = dpLeft[i - 1];
      }
    }

    int mpibt = 0;
    int maxafterToday = arr[ln - 1];
    int[] dpRight = new int[ln];

    for (int i = ln - 2; i >= 0; i--) {
      if (arr[i] > maxafterToday) {
        maxafterToday = arr[i];
      }
      mpibt = maxafterToday - arr[i];
      if (mpibt > dpRight[i + 1]) {
        dpRight[i] = mpibt;
      } else {
        dpRight[i] = dpRight[i + 1];
      }
    }

    int op = 0;
    for (int i = 0; i < ln; i++) {
      if (dpLeft[i] + dpRight[i] > op) {
        op = dpLeft[i] + dpRight[i];
      }
    }
    System.out.println(op);
  }

}
