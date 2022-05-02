package sort;

import java.util.Arrays;

public class HeapSort {

  private void heapify(int arr[], int len, int i) {
    int largest = i;
    int left = largest * 2 + 1;
    int right = largest * 2 + 2;

    if (left < len && arr[left] > arr[largest]) {
      largest = left;
    }

    if (right < len && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;
      heapify(arr, len, largest);
    }
  }

  private void sort(int arr[]) {
    int n = arr.length;

    for (int i = n / 2 - 1; i>=0; i--) {
      heapify(arr, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr, i, 0);
    }
  }

  public static void printArray(int arr[]) {
    for (int num : arr) {
      System.out.print(num+" ");
    }
  }

  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6, 7};
    HeapSort ob = new HeapSort();
    ob.sort(arr);

    System.out.println("Sorted Array is.");
    printArray(arr);
  }
}
