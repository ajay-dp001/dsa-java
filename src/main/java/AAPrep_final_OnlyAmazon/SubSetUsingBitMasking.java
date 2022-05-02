package AAPrep_final_OnlyAmazon;

import java.util.ArrayList;
import java.util.List;

public class SubSetUsingBitMasking {

  //https://leetcode.com/problems/subsets/submissions/
  private static List<List<Integer>> getSubSet(List<Integer> nums) {
    int size = nums.size(); //size = 3, nums = {1,2,3)
    int subset_num = (1 << size); //subset_num = 8

    List<List<Integer>> all_subset = new ArrayList<>();
    for (int subSetMask = 0; subSetMask < subset_num; subSetMask++) {
      List<Integer> subset = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        if ((subSetMask & (1 << i)) != 0) {
          subset.add(nums.get(i));
        }
      }
      all_subset.add(subset);
    }
    return all_subset;
  }

  public static void main(String[] args) {

  }
}
