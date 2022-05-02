package Arrays;

import prac.MyUtil;

public class Segerate0And1 {

  public static void main(String[] args) {
    int arr[] = {0, 0, 1, 1, 0};
    int len = arr.length;
    segregate0and1(arr, len);
    MyUtil.printArray(arr);
  }

  static void segregate0and1(int[] arr, int len) {
    int left = 0, right = len - 1;
    while (left < right) {
      while (arr[left] == 0 && left < right) {
        left++;
      }
      while (arr[right] == 1 && left < right) {
        right--;
      }
      if (left < right) {
        swap(arr, left, right);
      }
    }
  }

  private static void swap(int[] arr, int start, int end) {
    int tmp = arr[start];
    arr[start] = arr[end];
    arr[end] = tmp;
  }
}
