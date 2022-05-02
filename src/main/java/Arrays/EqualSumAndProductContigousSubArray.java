package Arrays;

public class EqualSumAndProductContigousSubArray {

  public static void main(String[] args) {
    int arr[] = {1, 3, 2};
    int len = arr.length;
    System.out.println(numOfSubArrayEqualSumAndProduct(arr, len));
  }

  private static int numOfSubArrayEqualSumAndProduct(int[] arr, int len) {
    int count = 0;
    for (int i = 0; i < len; i++) {
      int prod = arr[i];
      int sum = arr[i];
      for (int j = i + 1; j < len; j++) {
        if (prod == sum) {
          count++;
        }
        prod *= arr[j];
        sum += arr[j];
      }

      if (prod == sum) {
        count++;
      }
    }
    return count;
  }
}
