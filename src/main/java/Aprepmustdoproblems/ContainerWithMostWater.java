package Aprepmustdoproblems;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(getMaxArea(height));
  }

  private static int getMaxArea(int[] height) {
    int max_area = 0;
    int start = 0, end = height.length - 1;
    while (start < end) {
      max_area = Math.max(max_area, Math.min(height[start], height[end]) * (end - start));

      if (height[start] < height[end]) {
        start++;
      } else {
        end--;
      }
    }
  return max_area;
  }

}
