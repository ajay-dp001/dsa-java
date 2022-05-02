package AAPrep_final_OnlyAmazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

//Closest Pair Sum
public class OptimalUtil {

  public static void main(String[] args) {
    int[][][] arrA = {
        {{1, 2}, {2, 4}, {3, 6}},
        {{1, 3}, {2, 5}, {3, 7}, {4, 10}},
        {{1, 8}, {2, 7}, {3, 14}},
        {{1, 8}, {2, 15}, {3, 9}}};

    int[][][] arrB = {
        {{1, 2}, {2, 4}, {3, 6}},
        {{1, 3}, {2, 5}, {3, 7}, {4, 10}},
        {{1, 8}, {2, 7}, {3, 14}},
        {{1, 8}, {2, 15}, {3, 9}}};

    int[] target = {7, 10, 20, 20};
    for (int i = 0; i < 4; i++) {
      System.out.println(compute(arrA[i], arrB[i], target[i]).toString());
    }
  }

  private static List<List<Integer>> compute(int[][] a, int[][] b, int target) {
    List<List<Integer>> res = new ArrayList<>();
    TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {
        int sum = a[i][1] + b[j][1];
        if (sum < target) {
          List<List<Integer>> list = map.computeIfAbsent(sum, (k) -> new ArrayList<>());
          list.add(Arrays.asList(a[i][0], b[j][0]));
        }
      }
    }
    return map.floorEntry(target).getValue();
  }

}
