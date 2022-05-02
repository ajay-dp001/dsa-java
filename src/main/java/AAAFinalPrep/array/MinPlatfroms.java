package AAAFinalPrep.array;

import java.util.Arrays;

public class MinPlatfroms {

  public static void main(String[] args) {
    int len = 6;
    int[] arrTime = {900, 940, 950, 1100, 1500, 1800};
    int[] depTime = {910, 1200, 1120, 1130, 1900, 2000};

    System.out.println(calculateMinPlatformOn2(arrTime, depTime, len));
    System.out.println(calculateMinPlatformnlogn(arrTime, depTime, len));
    System.out.println(calPlat(arrTime, depTime, len));
  }

  private static int calculateMinPlatformOn2(int[] arvTime, int[] depTime, int len) {
    int platform_req, result = 0;
    for (int i = 0; i < len; i++) {
      platform_req = 1;
      for (int j = i + 1; j < len; j++) {
        if (arvTime[i] >= arvTime[j] && arvTime[i] <= depTime[j]
            || arvTime[j] >= arvTime[i] && arvTime[j] <= depTime[i]) {
          platform_req++;
        }
      }
      result = Math.max(result, platform_req);
    }
    return result;
  }

  private static int calculateMinPlatformnlogn(int[] arvTime, int[] depTime, int len) {
    Arrays.sort(arvTime);
    Arrays.sort(depTime);
    int platform_req = 1, result = 1;
    int i = 1, j = 0;
    while (i < len && j < len) {
      if (arvTime[i] <= depTime[j]) {
        platform_req++;
        i++;
      } else if (arvTime[i] > depTime[j]) {
        platform_req--;
        j++;
      }
      result = Math.max(result, platform_req);
    }
    return result;
  }

  //nlogn
  private static int calPlat(int[] arvTime, int[] depTime, int len) {
    Arrays.sort(arvTime);
    Arrays.sort(depTime);
    int i = 1, j = 0, plat_no = 1;
    while (i < len) {
      if (arvTime[i++] < depTime[j]) {
        plat_no++;
      } else {
        j++;
      }
    }
    return plat_no;
  }
}
