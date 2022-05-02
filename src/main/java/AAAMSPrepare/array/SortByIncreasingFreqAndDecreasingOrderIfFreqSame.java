package AAAMSPrepare.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByIncreasingFreqAndDecreasingOrderIfFreqSame {

  public static void main(String[] args) {
    int[] arr = {1, 1, 2, 2, 2, 3};
    int[] arr1 = {2, 3, 1, 3, 2};
    for (int num : freq(arr)) {
      System.out.print(num + " ");
    }
    System.out.println();
    for (int num : freq(arr1)) {
      System.out.print(num + " ");
    }
  }

  private static int[] freq(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      list.add(nums[i]);
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    list.sort((n1, n2) -> {
      int freq1 = map.get(n1);
      int freq2 = map.get(n2);

      if (freq1 != freq2) {
        return freq1 - freq2;
      }
      return n2 - n1;
    });

    for (int i = 0; i < nums.length; i++) {
      nums[i] = list.get(i);
    }
    return nums;
  }

}
