package AAAFinalPrep.sort;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6};
    bubbleSort(arr);
    System.out.println("Sorted Array is :" + Arrays.toString(arr));

  }

  private static void bubbleSort(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

}
