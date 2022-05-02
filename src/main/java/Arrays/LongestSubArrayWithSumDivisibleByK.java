package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumDivisibleByK {

  public static void main(String[] args) {
    int k = 5;
    int arr[] = {2, 4, 8, 1, 7, 3, 6, 1, 9, 2, 7, 3};
    System.out.println(longSubArraySumDivByK(arr, k));

    int k1 = 7;
    int arr1[] = {-3, -9, -4, 8, 5, 4, 2, 6};
    System.out.println(longSubArraySumDivByK(arr1, k1));
  }

  private static int longSubArraySumDivByK(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0, rem = 0, ans = 0;
    map.put(0, -1);
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      rem = sum % k;
      if (rem < 0) {
        rem += k;
      }
      if (map.containsKey(rem)) {
        int idx = map.get(rem);
        int len = i - idx;
        if (len > ans) {
          ans = len;
        }
      } else {
        map.put(rem, i);
      }
    }
    return ans;
  }
}
