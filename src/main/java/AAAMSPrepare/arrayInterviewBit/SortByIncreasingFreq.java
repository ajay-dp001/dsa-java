package AAAMSPrepare.arrayInterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.units.qual.A;

public class SortByIncreasingFreq {

  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 2, 2, 3};
    int[] res = sortFreq(nums);
  }

  private static int[] sortFreq(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < a.length; i++) {
      list.add(a[i]);
      map.put(a[i], map.getOrDefault(a[i], 0) + 1);
    }

    Collections.sort(list, (n1, n2) -> {
      int fq1 = map.get(n1);
      int fq2 = map.get(n2);
      if (fq1 != fq2) {
        return fq1 - fq2;
      }
      return n1 - n2;
    });
    return a;
  }
}
