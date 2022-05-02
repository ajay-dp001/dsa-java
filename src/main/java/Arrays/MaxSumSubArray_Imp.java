package Arrays;

public class MaxSumSubArray_Imp {

  public static void main(String[] args) {
    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
    int n = a.length;
    System.out.println("Max Sum is :" + maxSubArraySum(a));
    System.out.println("Max Sum is :" + maxSubArray(a));
  }

  private static int maxSubArraySum(int[] arr) {
    int cur_sum = arr[0];
    int overall_sum = arr[0];

    for (int i = 0; i < arr.length; i++) {
      if (cur_sum >= 0) {
        cur_sum += arr[i];
      } else {
        cur_sum = arr[i];
      }
      if (cur_sum > overall_sum) {
        overall_sum = cur_sum;
      }
    }
    return overall_sum;
  }

  private static int maxSubArray(int[] arr) {
    int sum = 0, maxSum = arr[0];
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (sum > maxSum) {
        maxSum = sum;
      }
      if (sum < 0) {
        sum = 0;
      }
    }
    return maxSum;
  }
}
