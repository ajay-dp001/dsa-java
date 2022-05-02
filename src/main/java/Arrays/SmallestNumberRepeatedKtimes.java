package Arrays;

import java.util.Arrays;

public class SmallestNumberRepeatedKtimes {

  public static void main(String[] args) {
    int arr[] = {2, 2, 11, 3, 1};
    int k = 2;
    int n = arr.length;
    System.out.println(findDuplicate(arr, n, k));
  }

  private static int findDuplicate(int[] arr, int len, int k) {
    Arrays.sort(arr);

    int i = 0;
    while (i < len) {
      int j, cnt = 1;
      for (j = i + 1; j < len && arr[j] == arr[i]; j++) {
        cnt++;
      }
      if (cnt == k) {
        return arr[i];
      }
      i = j;
    }
    return -1;
  }

}
