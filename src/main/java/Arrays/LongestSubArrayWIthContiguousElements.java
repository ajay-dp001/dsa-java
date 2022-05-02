package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubArrayWIthContiguousElements {

  public static void main(String[] args) {
    int[] arr = {9, 2, 7, 5, 6, 23, 24, 22, 23, 19, 17, 16, 18, 39, 0};
    int ln = arr.length;
    System.out.println(getLongestArrayContiguous(arr, ln));
  }

  private static int getLongestArrayContiguous(int[] arr, int ln) {
    int ans = 0;
    for (int i = 0; i < ln; i++) {
      int min = arr[i];
      int max = arr[i];
      Set<Integer> set = new HashSet<>();
      set.add(arr[i]);
      for (int j = i + 1; j < ln; j++) {
        if (set.contains(arr[j])) {
          break;
        }
        set.add(arr[j]);

        min = Math.min(min, arr[j]);
        max = Math.max(max, arr[j]);

        if (max - min == j - i) {
          int len = j - i + 1;
          if (len > ans) {
            ans = len;
          }
        }
      }
    }
    return ans;
  }
}
