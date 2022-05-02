package Arrays;

import prac.MyUtil;

public class BuildMaxHeap {

  public static void main(String[] args) {
    int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
    int len = arr.length;
    buildHeap(arr, len);
    MyUtil.printArray(arr);
  }

  private static void buildHeap(int[] arr, int len) {
    //Index of last Non Leaf node
    int index = (len / 2) - 1;
    for (int i = index; i >= 0; i--) {
      heapify(arr, len, i);
    }
  }

  private static void heapify(int[] arr, int len, int index) {
    int largest = index;
    int left = 2 * index + 1;
    int right = 2 * index + 2;

    if (left < len && arr[left] > arr[largest]) {
      largest = left;
    }
    if (right < len && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != index) {
      MyUtil.swap(arr, index, largest);
      heapify(arr, len, largest);
    }
  }
}
