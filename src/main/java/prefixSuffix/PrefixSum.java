package prefixSuffix;

public class PrefixSum {

  public static void main(String[] args) {
    int[] arr = {10, 4, 16, 20};
    int len = arr.length;

    int[] prefixSum = new int[len];
    fillPrefixSum(arr, len, prefixSum);
  }

  public static void fillPrefixSum(int[] arr, int len, int[] prefixSum) {
    prefixSum[0] = arr[0];
    for (int i = 1; i < len; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }
  }

}
