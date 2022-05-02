package Arrays;

import java.util.Arrays;

public class MinNoOfPlatForm {

  public static void main(String[] args) {
    int len = 6;
    int[] arr = {900, 940, 950, 1100, 1500, 1800};
    int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
    System.out.println(calculateMinPlatform(arr, dep, len));
  }

  private static int calculateMinPlatform(int[] arv, int[] dep, int len) {
    Arrays.sort(arv);
    Arrays.sort(dep);

    int plat_needed = 1, result = 1;
    int i = 1, j = 0;
    while (i < len && j < len) {
      if (arv[i] <= dep[j]) {
        plat_needed++;
        i++;
      } else if (arv[i] > dep[j]) {
        plat_needed--;
        j++;
      }

      if (plat_needed > result) {
        result = plat_needed;
      }
    }
    return result;
  }

}
