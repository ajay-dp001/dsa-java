package Arrays;

public class MaxSumSubArrayCircularArray {

  public static void main(String[] args) {
    int[] arr1 = {11, 10, -20, 5, -3, -5, 8, -13, 10};
    int[] arr = {1, -2, 3, -2};
    int len = arr.length;
    System.out.println(maxSumSubArrayCircular(arr, len));
  }

  private static int maxSumSubArrayCircular(int[] arr, int len) {
    if (len == 1) {
      return arr[0];
    }
    int sa_sum = 0;
    for (int i = 0; i < len; i++) {
      sa_sum += arr[i];
    }

    int curr_max = arr[0], max_so_far = arr[0], curr_min = arr[0], min_so_far = arr[0];

    for (int i = 1; i < len; i++) {
      curr_max = Math.max((curr_max + arr[i]), arr[i]);
      max_so_far = Math.max(max_so_far, curr_max);

      curr_min = Math.min(curr_min + arr[i], arr[i]);
      min_so_far = Math.min(min_so_far, curr_min);
    }

    if (min_so_far == sa_sum) {
      return max_so_far;
    }
    return Math.max(max_so_far, sa_sum - min_so_far);
  }
}
