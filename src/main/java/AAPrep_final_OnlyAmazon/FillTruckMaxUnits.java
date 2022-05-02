package AAPrep_final_OnlyAmazon;

import java.util.Arrays;

//https://www.youtube.com/watch?v=qZUokf5dwYw
public class FillTruckMaxUnits {

  public static void main(String[] args) {
    int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
    int target = 4;
    System.out.println("Max Units " + maximumUnits(boxTypes, target));


    int[][] boxTypes2 = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
    int target2 = 10;
    System.out.println("Max Units " + maximumUnits(boxTypes2, target2));
  }

  public static int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (a, b) -> -Integer.compare(a[1], b[1]));
    int max_unit = 0;
    for (int[] box : boxTypes) {
      if (truckSize < box[0]) {
        return max_unit + truckSize * box[1];
      }
      max_unit += box[0] * box[1];
      truckSize -= box[0];
    }
    return max_unit;
  }

}
