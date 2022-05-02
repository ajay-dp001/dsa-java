package misc;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static int[] findTwoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (map.containsKey(diff)) {
        return new int[]{i, map.get(diff)};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[]{};
  }

  public static void main(String[] args) {
    int[] arr = {2,4,5,6,7,8,9};
    int target = 13;
    int[] ar= findTwoSum(arr, target);
    for (int i =0; i< ar.length;i++){
      System.out.println(ar[i]);
    }
  }

}
