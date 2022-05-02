package AAAMSPrepare.array;

public class PrefixSuffixSum {

  public static void main(String[] args) {
    int[] arr1 = {5, 10, 4, 0, 2, 4, 6, 31, 6, 6, 8, 5, 1, 2, 3};
    int[] arr = {2, 3, 4, 1, 4, 5};
    int len = arr.length;
    System.out.println(findElementEff(arr, len));
  }

  private static int findElement(int[] arr, int len) {
    int[] prefixSum = new int[len];
    prefixSum[0] = arr[0];

    for (int i = 1; i < len; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }

    int[] suffixSum = new int[len];
    suffixSum[len - 1] = arr[len - 1];

    for (int i = len - 2; i >= 0; i--) {
      suffixSum[i] = suffixSum[i + 1] + arr[i];
    }

    for (int i = 1; i < len - 1; i++) {
      if (prefixSum[i] == suffixSum[i]) {
        return arr[i];
      }
    }
    return -1;
  }

  private static int findElementEff(int[] arr, int len) {
    int right_sum = 0, left_sum = 0;

    //Computing right sum
    for (int i = 1; i < len; i++) {
      right_sum += arr[i];
    }

    //Checking point of partition that is left_sum == right_sum
    for (int i = 0, j = 1; j < len; i++, j++) {
      right_sum -= arr[j];
      left_sum += arr[i];
      if (left_sum == right_sum) {
        return arr[i + 1];
      }
    }
    return -1;
  }
}
