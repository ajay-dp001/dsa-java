package AAAMSPrepare.array;

public class MaxLenPositiveProductSubArray {

  public static void main(String[] args) {
    int[] arr = {0, 1, -2, -3, -4};
    int len = arr.length;
    System.out.println(maxLenPositiveProduct(arr, len));
  }

  private static int maxLenPositiveProduct(int[] arr, int len) {
    int neg = 0, res = 0;
    int firstNegPos = -1, latestZeroPos = -1;

    for (int i = 0; i < len; i++) {
      if (arr[i] < 0) {
        if (firstNegPos < 0) {
          firstNegPos = i;
        }
        neg++;
      }
      if (arr[i] == 0) {
        neg = 0;
        firstNegPos = -1;
        latestZeroPos = i;
      } else {
        if (neg % 2 == 0) {
          res = Math.max(res, i - latestZeroPos);
        } else {
          res = Math.max(res, i - firstNegPos);
        }
      }
    }
    return res;
  }

}
