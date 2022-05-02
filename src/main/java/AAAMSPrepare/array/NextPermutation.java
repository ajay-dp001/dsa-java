package AAAMSPrepare.array;

import java.util.Arrays;

public class NextPermutation {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 6, 5, 2};
    int[] arr1 = {5, 1, 1};
    int len = arr.length;
    int len1 = arr1.length;
    nextPermute(arr, len);
    System.out.println(Arrays.toString(arr));
    nextPermute(arr1, len1);
    System.out.println(Arrays.toString(arr1));
  }

  private static void nextPermute(int[] arr, int len) {
    int i = arr.length - 2;
    while (i >= 0 && arr[i] >= arr[i + 1]) {
      i--;
    }
    if (i >= 0) {
      int j = len - 1;
      while (i != j && arr[i] >= arr[j]) {
        j--;
      }
      swap(arr, i, j);
    }
    reverse(arr, i + 1, len - 1);
  }

  private static void reverse(int[] arr, int i, int j) {
    while (i < j) {
      swap(arr, i++, j--);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
