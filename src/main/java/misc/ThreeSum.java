package misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

  public static List<Integer[]> findThreeSum_BruteForce(int[] arr, int target) {
    List<Integer[]> result = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (arr[i] + arr[j] + arr[k] == target) {
            result.add(new Integer[]{arr[i], arr[j], arr[k]});
          }
        }
      }
    }
    return result;
  }

  //O(n^2)
  public static List<Integer[]> findThreeSum(int[] arr, int target) {
    List<Integer[]> list = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      int diff = target - arr[i];
      Set<Integer> set = new HashSet<>();
      for (int j = i + 1; j < arr.length; j++) {
        if (set.contains(diff - arr[j])) {
          list.add(new Integer[] {arr[i], arr[j], diff - arr[j]});
        }else {
          set.add(arr[j]);
        }
      }
    }
    return list;
  }


  public static void main(String[] args) {
    int[] arr = {7, 12, 3, 1, 2, -6, 5, -8, 6};
    int target_sum = 0;
    List<Integer[]> res = findThreeSum(arr, target_sum);
    for (Integer[] in : res) {
      for (int num : in) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }

}
