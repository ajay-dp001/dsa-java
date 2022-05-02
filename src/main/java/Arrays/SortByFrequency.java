package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFrequency {

  public static int[] frequencySort(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      list.add(nums[i]);
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    Collections.sort(list, (n1, n2) -> {
      int freq1 = map.get(n1);
      int freq2 = map.get(n2);

      if (freq1 != freq2) {
        return freq2 - freq1;
      }
      return n1 - n2;
    });
    Collections.reverse(list);
    for (int i = 0; i < nums.length; i++) {
      nums[i] = list.get(i);
    }
    return nums;
  }

  public static void main(String[] args) {
    int[] arr = {4, 5, 3, 6, 1, 2, 4, 6, 7, 4, 3, 8, 3, 4};
    frequencySort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

}
