package Arrays;

import java.util.HashMap;
import java.util.Map;

public class AllSubArray {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3};
    int len = arr.length;
    printSubArray(arr, len);

    int[] arr1 = {1, 0, 0, 1, 0, 1, 1};
    int len1 = arr1.length;
    System.out.println("Count is  :" + subArrayWithEqual0And1(arr1, len1));
  }

  private static int subArrayWithEqual0And1(int[] arr, int len) {
    int sum = 0, count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      if (arr[i] == 0) {
        arr[i] = -1;
      }
      sum += arr[i];

      if (sum == 0) {
        count++;
      }
      if (map.containsKey(sum)) {
        count += map.get(sum);
      }
      if (!map.containsKey(sum)) {
        map.put(sum, 1);
      } else {
        map.put(sum, map.get(sum) + 1);
      }
    }
    return count;
  }

  private static void printSubArray(int[] arr, int end) {
    for (int sp = 0; sp < end; sp++) {
      for (int ep = sp; ep < end; ep++) {
        for (int k = sp; k <= ep; k++) {
          System.out.print(arr[k] + " ");
        }
        System.out.println();
      }
    }
  }
}
