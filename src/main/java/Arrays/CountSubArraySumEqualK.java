package Arrays;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=20v8zSo2v18
public class CountSubArraySumEqualK {

  public static void main(String[] args) {
    int[] arr = {3, 9, -2, 4, 1, -7, 2, 6, -5, 8, -3, -7, 6, 2, 1};
    int sum = 5;
    System.out.println(countSubArraySumEqualK(arr, sum));
  }

  private static int countSubArraySumEqualK(int[] arr, int trgt) {
    int sum = 0, ans = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (map.containsKey(sum - trgt)) {
        ans += map.get(sum - trgt);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return ans;
  }
}
