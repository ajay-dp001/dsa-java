package AAAMSPrepare.array;

import java.util.Arrays;
import org.checkerframework.checker.units.qual.A;

public class MinSetpsMakingSameHight {

  public static void main(String[] args) {
    int[] arr = {5, 2, 1};
    int len = arr.length;
    System.out.println("Min Steps :" + minSteps(arr, len));
  }

  public static int minSteps(int[] arr, int len) {
    if (len < 1) {
      return 0;
    }
    Arrays.sort(arr);
    int res = 0, distanceNums = 0;
    for (int i = 1; i < len; i++) {
      if (arr[i] == arr[i - 1]) {
        res += distanceNums;
      } else {
        distanceNums++;
        res += distanceNums;
      }
    }
    return res;
  }

}
