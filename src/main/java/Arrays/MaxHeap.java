package Arrays;

import prac.MyUtil;

public class MaxHeap {

  static int len;

  public static void main(String[] args) {
    int arr[] = {3, 2, 1, 5, 6, 4, 23, 11, 0, 7};
    len = arr.length;
    int k = 2;
    kthLargest(arr, len, k);
    kthSmallest(arr, len, k);
  }

  private static void kthLargest(int[] arr, int len, int k) {
    int max_elem = Integer.MAX_VALUE;
    for (int i = 0; i < k; i++) {
      for (int j = (len / 2) - 1; j >= 0; j--) {
        heapifyMaxHeap(arr, len, j);
      }
      max_elem = extractMax(arr, len);
      len--;
    }
    System.out.println("Max Element is :" + max_elem);
  }

  private static void kthSmallest(int[] arr, int len, int k) {
    int max_elem = Integer.MIN_VALUE;
    for (int i = 0; i < k; i++) {
      for (int j = (len / 2) - 1; j >= 0; j--) {
        heapifyMinHeap(arr, len, j);
      }
      max_elem = extractMax(arr, len);
      len--;
    }
    System.out.println("Min Element is :" + max_elem);
  }

  private static int extractMax(int[] arr, int length) {
    MyUtil.swap(arr, 0, length - 1);
    return arr[length - 1];
  }


  private static void heapifyMaxHeap(int[] arr, int len, int i) {
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

      heapifyMaxHeap(arr, len, largest);
    }
  }

  private static void heapifyMinHeap(int[] arr, int len, int i) {
    int smallest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < len && arr[left] < arr[smallest]) {
      smallest = left;
    }

    if (right < len && arr[right] < arr[smallest]) {
      smallest = right;
    }

    if (smallest != i) {
      int tmp = arr[i];
      arr[i] = arr[smallest];
      arr[smallest] = tmp;

      heapifyMinHeap(arr, len, smallest);
    }
  }
}
