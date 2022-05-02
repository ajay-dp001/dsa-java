package Aprepmustdoproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given an integer array nums,
// return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
public class ThreeSum {

  public static void main(String[] args) {
    int target = 0;
    int[] arr = {7, 12, 3, 1, 2, -6, 5, -8, 6};
    List<Integer[]> res1 = findThreeSum(arr, target);

    int[] arr1 = {-1, 0, 1, 2, -1, -4};
    //System.out.println(findThreeSumLeetCode(arr1, target));
    System.out.println(findThreeSumLeetCode20ms(arr1, target));
  }

  private static List<Integer[]> findThreeSum(int[] arr, int target) {
    List<Integer[]> list = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      int diff = target - arr[i];
      Set<Integer> set = new HashSet<>();
      for (int j = i + 1; j < arr.length; j++) {
        if (set.contains(diff - arr[j])) {
          list.add(new Integer[]{arr[i], arr[j], diff - arr[j]});
        } else {
          set.add(arr[j]);
        }
      }
    }
    return list;
  }

  //Stop Duplicate Using Set
  private static List<List<Integer>> findThreeSumUsingHashSet(int[] arr, int target) {
    Arrays.sort(arr);
    Set<List<Integer>> set = new HashSet<>();

    for (int i = 0; i < arr.length - 2; i++) {
      int j = i + 1, k = arr.length - 1;
      while (j < k) {
        int sum = arr[i] + arr[j] + arr[k];
        if (sum == 0) {
          set.add(Arrays.asList(arr[i], arr[j++], arr[k--]));
        } else if (sum < 0) {
          j++;
        } else {
          k--;
        }
      }
    }
    return new ArrayList<>(set);
  }

  //Stop Duplicate
  private static List<List<Integer>> findThreeSumLeetCode(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && (nums[i] == nums[i - 1])) {
        continue; // avoid duplicates
      }
      for (int j = i + 1, k = nums.length - 1; j < k; ) {
        if (nums[i] + nums[j] + nums[k] == 0) {
          list.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;
          while ((j < k) && (nums[j] == nums[j - 1])) {
            j++;// avoid duplicates
          }
          while ((j < k) && (nums[k] == nums[k + 1])) {
            k--;// avoid duplicates
          }
        } else if (nums[i] + nums[j] + nums[k] > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
    return list;
  }

  //Stop Duplicate
  private static List<List<Integer>> findThreeSumLeetCode20ms(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = nums.length - 1;

      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          while (j < k && nums[j] == nums[j - 1]) {
            j++;
          }
        } else if (sum > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
    return result;
  }
}