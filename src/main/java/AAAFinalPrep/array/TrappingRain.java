package AAAFinalPrep.array;

public class TrappingRain {

  //https://www.youtube.com/watch?v=ZI2z5pq0TqA&ab_channel=NeetCode
  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int[] arr1 = {3,2,3,2};
    int len = arr.length;
    int len1 = arr1.length;
    System.out.print(maxWater(arr, len));
  }

  private static int maxWater(int[] arr, int len) {
    if (len == 0) {
      return 0;
    }
    int res = 0, left = 0, right = len - 1, leftMax = arr[left], rightMax = arr[right];
    while (left < right) {
      if (leftMax < rightMax) {
        left++;
        leftMax = Math.max(leftMax, arr[left]);
        res += leftMax - arr[left];
      } else {
        right--;
        rightMax = Math.max(rightMax, arr[right]);
        res += rightMax - arr[right];
      }
    }
    return res;
  }

}
