package AAPrep_final_OnlyAmazon;

//https://www.youtube.com/watch?v=8ViERnSgPKs

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class  FourSum {

  public static void main(String[] args) {
    int[] nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    int[] nums1 = {2, 2, 2, 2, 2};
    int target1 = 8;
    List<List<Integer>> list = fourSum(nums, target);
  }

  private static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    int len = nums.length;
    Set<List<Integer>> res = new HashSet<>();
    for (int i = 0; i < len - 3; i++) {
      for (int j = i + 1; j < len - 2; j++) {
        int k = j + 1;
        int l = len - 1;
        while (k < l) {
          int sum = nums[i] + nums[j] + nums[k] + nums[l];
          if (sum == target) {
            res.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[l--]));
          } else if (sum > target) {
            l--;
          } else {
            k++;
          }
        }
      }
    }
    return new ArrayList<>(res);
  }
}
