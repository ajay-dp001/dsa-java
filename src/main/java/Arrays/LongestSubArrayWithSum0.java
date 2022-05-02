package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSum0 {

  public static void main(String[] args) {
    int[] arr = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1,};
    System.out.println(longSubArraySumZero(arr));
  }

  private static int longSubArraySumZero(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    int i = -1;
    int sum = 0, max_len = 0;
    map.put(sum, i);
    while (i < arr.length - 1) {
      i++;
      sum += arr[i];
      if (!map.containsKey(sum)) {
        map.put(sum, i);
      } else {
        int len = i - map.get(sum);
        if (len > max_len) {
          max_len = len;
        }
      }
    }
    return max_len;
  }
}
