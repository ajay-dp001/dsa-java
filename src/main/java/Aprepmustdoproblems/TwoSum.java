package Aprepmustdoproblems;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

  public static void main(String[] args) {
    int[] arr = {2, 7, 11, 15};
    int target = 9;
    System.out.println(cntSumUniquePair(arr, target));
    int[] ar = findTwoSum(arr, target);

    for (int i = 0; i < ar.length; i++) {
      System.out.print(ar[i] + " ");
    }
  }

  private static int[] findTwoSum(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int diff = target - arr[i];
      if (map.containsKey(diff)) {
        return new int[]{map.get(diff), i};
      } else {
        map.put(arr[i], i);
      }
    }
    return new int[]{};
  }

  private static int cntSumUniquePair(int[] nums, int target) {
    Set<Integer> set = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    for (int num : nums) {
      if (map.containsKey(num)) {
        int key = map.get(num) * 10 + num;
        if (!set.contains(key)) {
          ans++;
          set.add(key);
        }
      } else {
        map.put(target - num, num);
      }
    }
    return ans;
  }
}
