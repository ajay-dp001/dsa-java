package AAAMSPrepare.array;

import java.util.HashSet;
import java.util.Set;

public class LargestKAndMinusK {

  public static void main(String[] args) {
    int[] arr = {-41, 3, 2, 5, 41};
    System.out.println(largestNumWithNegPair(arr));
  }

  private static int largestNumWithNegPair(int[] arr) {
    Set<Integer> set = new HashSet<>();
    int curMax = 0;
    for (int num : arr) {
      if (set.contains(num * -1)) {
        curMax = Math.max(curMax, Math.abs(num));
      } else {
        set.add(num);
      }
    }
    return curMax;
  }

}
