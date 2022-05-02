package Arrays;

public class MinElemToBeRemovedToEqualSumK {

  public static void main(String[] args) {
    int arr[] = {1, 3, 2, 5, 6};
    int n = arr.length;
    int k = 5;

    System.out.println(findMinNumber(arr, n, k));
  }

  private static int findMinNumber(int[] arr, int len, int k) {
    int i = 0, j = 0, sum = 0;
    int min_num = Integer.MAX_VALUE;
    boolean found = false;

    while (i < len) {
      sum += arr[i];
      if (sum == k) {
        min_num = Math.min(min_num, ((len - (i + 1)) + j));
      } else if (sum > k) {
        while (sum > k) {
          sum -= arr[j++];
        }
        if (sum == k) {
          found = true;
          min_num = Math.min(min_num, ((len - (i + 1)) + j));
        }
      }
      i++;
    }

    if (found) {
      return min_num;
    }
    return -1;
  }

}
