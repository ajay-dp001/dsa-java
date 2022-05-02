package Arrays;

public class MaximumSumSubArrayWithAtLeastSizeK {

  public static void main(String[] args) {
    int k = 3;
    int[] arr = {2, 1, -5, 1, 3, 2};
    int ln = arr.length;
    int res = getSum(arr, ln, k);
    System.out.println(res);
  }

  private static int getSum(int[] arr, int ln, int k) {
    int start = 0, sum = 0, max_sum = 0;
    for (int end = 0; end < ln; end++) {
      sum += arr[end];
      if (end >= k - 1) {
        max_sum = Math.max(sum, max_sum);
        sum = sum - arr[start];
        start++;
      }
    }
    return max_sum;
  }

}
