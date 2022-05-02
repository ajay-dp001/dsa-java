package prac;

public class RainWaterTrapping {

  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int len = arr.length;
    System.out.print(maxWater(arr, len));
    System.out.println();
    System.out.print(maxWaterOptimal(arr, len));
  }

  //Time :O(n^2), Space O(1)
  private static int maxWater(int[] arr, int len) {
    int result = 0;
    for (int i = 1; i < len - 1; i++) {
      int left = arr[i];
      for (int j = 0; j < i; j++) {
        left = Math.max(left, arr[j]);
      }
      int right = arr[i];
      for (int j = i + 1; j < len; j++) {
        right = Math.max(right, arr[j]);
      }
      result += Math.min(left, right) - arr[i];
    }
    return result;
  }

  //Time :O(n), Space O(1)
  private static int maxWaterOptimal(int[] arr, int len) {
    int result = 0, low = 0, high = len - 1, left_max = 0, right_max = 0;
    while (low < high) {
      if (arr[low] < arr[high]) {
        if (arr[low] > left_max) {
          left_max = arr[low];
        } else {
          result += left_max - arr[low];
        }
        low++;
      } else {
        if (arr[high] > right_max) {
          right_max = arr[high];
        } else {
          result += right_max - arr[high];
        }
        high--;
      }
    }
    return result;
  }

}
