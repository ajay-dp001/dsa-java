package AAAFinalPrep.array;

public class MaxSumSubArray {

  public static void main(String[] args) {
    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
    int n = a.length;
    System.out.println("Max Sum is :" + maxSubArraySum(a, n));
    //System.out.println("Max Sum is :" + maxSubArray(a));
  }

  private static int maxSubArraySum(int[] arr, int len) {
    int maxSum = arr[0], sum = 0;
    for (int i = 0; i < len; i++) {
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

  private static int maxSumSubArray(int[] arr) {
    int maxSum = 0, sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (maxSum < sum) {
        maxSum = sum;
      }
      if (sum < 0) {
        sum = 0;
      }
    }
    return maxSum;
  }

}
