package AAAMSPrepare.misc;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static void main(String[] args) {
    int[] arr = {2, 4, 5, 6, 7, 8, 9};
    int target = 13;
    int[] ar = findTwoSum(arr, target);
    for (int i = 0; i < ar.length; i++) {
      System.out.println(ar[i]);
    }
  }

  public static int[] findTwoSum(int[] arr, int sum) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int diff = sum - arr[i];
      if (!map.containsKey(diff)) {
        map.put(arr[i], i);
      } else {
        return new int[]{i, map.get(diff)};
      }
    }
    return new int[]{};
  }

}
