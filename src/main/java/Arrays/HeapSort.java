package Arrays;


import prac.MyUtil;

public class HeapSort {

  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 7, 5, 4};
    int len = arr.length;
    heapSort(arr, len);

    System.out.println("Sorted Array is :");
    MyUtil.printArray(arr);
  }

  private static void heapSort(int[] arr, int len) {
    for (int i = len / 2 - 1; i >= 0; i--) {
      heapify(arr, len, i);
    }

    for (int i = len - 1; i > 0; i--) {
      int tmp = arr[0];
      arr[0] = arr[i];
      arr[i] = tmp;

      heapify(arr, i, 0);
    }
  }

  private static void heapify(int[] arr, int len, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < len && arr[left] > arr[largest]) {
      largest = left;
    }

    if (right < len && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != i) {
      int tmp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = tmp;

      heapify(arr, len, largest);
    }
  }
}
