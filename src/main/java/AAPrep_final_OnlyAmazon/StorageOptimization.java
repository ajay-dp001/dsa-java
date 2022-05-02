package AAPrep_final_OnlyAmazon;

import java.util.Arrays;

public class StorageOptimization {

  public static void main(String[] args) {
    int height = 5, width = 4;
    int[] horizontalCut = {1, 2, 4};
    int[] verticalCut = {1, 3};
    System.out.println("Max Area:" + maxArea(height, width, horizontalCut, verticalCut));

    int height1 = 5, width1 = 4;
    int[] horizontalCut1 = {3, 1};
    int[] verticalCut1 = {1};
    System.out.println("Max Area:" + maxAreaNew(height1, width1, horizontalCut1, verticalCut1));
  }

  private static int maxArea(int height, int width, int[] horizontalCut, int[] verticalCut) {
    Arrays.sort(horizontalCut);
    Arrays.sort(verticalCut);

    long max_horizontal_gap = horizontalCut[0];
    int idx = 0;
    for (idx = 1; idx < horizontalCut.length; idx++) {
      max_horizontal_gap = Math.max(max_horizontal_gap, horizontalCut[idx] - horizontalCut[idx - 1]);
    }
    max_horizontal_gap = Math.max(max_horizontal_gap, height - horizontalCut[idx - 1]);

    long max_vertical_gap = verticalCut[0];
    for (idx = 1; idx < verticalCut.length; idx++) {
      max_vertical_gap = Math.max(max_vertical_gap, verticalCut[idx] - verticalCut[idx - 1]);
    }
    max_vertical_gap = Math.max(max_vertical_gap, width - verticalCut[idx - 1]);
    return (int) (max_horizontal_gap * max_vertical_gap) % 1000000007;
  }

  public static int maxAreaNew(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);

    long max_height = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
    for (int i = 1; i < horizontalCuts.length; i++) {
      max_height = Math.max(max_height, horizontalCuts[i] - horizontalCuts[i - 1]);
    }

    long max_width = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
    for (int j = 1; j < verticalCuts.length; j++) {
      max_width = Math.max(max_width, verticalCuts[j] - verticalCuts[j - 1]);
    }

    return (int) (max_height * max_width) % 1000000007;
  }

}
