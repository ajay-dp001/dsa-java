package Arrays;

public class SlidingWindow {

  public static void main(String[] args) {
    int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
    int k = 4;
    int n = arr.length;
    System.out.println(maxSum(arr, n, k));
    System.out.println(slidingWindow(arr, n, k));
  }

  private static int maxSum(int[] arr, int ln, int k) {
    int max_sum = Integer.MIN_VALUE;
    for (int i = 0; i < ln - k + 1; i++) {
      int curr_sum = 0;
      for (int j = 0; j < k; j++) {
        curr_sum += arr[i + j];
      }
      max_sum = Math.max(max_sum, curr_sum);
    }
    return max_sum;
  }

  private static int slidingWindow(int[] arr, int ln, int k) {
    int max_sum = 0, window_sum = 0;
    for (int i = 0; i < k; i++) {
      max_sum += arr[i];
    }
    window_sum = max_sum;
    for (int i = k; i < ln; i++) {
      window_sum += arr[i] - arr[i - k];
      max_sum = Math.max(max_sum, window_sum);
    }
    return max_sum;
  }
}
