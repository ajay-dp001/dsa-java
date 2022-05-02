package Arrays;

public class SumPairClosestToK {

  public static void main(String[] args) {

    int[] arr = {10, 22, 28, 29, 30, 40};
    int x = 54;
    printClosest(arr, x);
  }

  private static void printClosest(int[] arr, int x) {
    int left_idx = 0, right_idx = 0, left = 0, right = arr.length - 1, diff = Integer.MAX_VALUE;
    while (left < right) {
      if (Math.abs(arr[left] + arr[right] - x) < diff) {
        left_idx = left;
        right_idx = right;
        diff = Math.abs(arr[left] + arr[right] - x);
      }
      if (arr[left] + arr[right] > x) {
        right--;
      } else {
        left++;
      }
    }
    System.out.println("Closet Pair is :" + arr[left_idx] + " and " + arr[right_idx]);}

}
