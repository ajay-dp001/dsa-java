package AAAFinalPrep.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSort {

  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6, 7};
    maxSort(arr);

    int arr1[] = {12, 11, 13, 5, 6, 7};
    minSort(arr1);

    int arr2[] = {12, 11, 13, 5, 6, 7};
    int len2 = arr2.length;
    int kthsmall = kthSmallestElem(arr2, len2, 3);
    System.out.println(kthsmall);

    System.out.println("MAx Sorted Array is.");
    printArray(arr);

    System.out.println();

    System.out.println("Min Sorted Array is.");
    printArray(arr1);
  }

  private static int extractMin(int[] arr, int len) {
    int temp = arr[0];
    arr[0] = arr[len - 1];
    arr[len - 1] = temp;
    return arr[len - 1];
  }

  private static int kthSmallestElem(int[] arr, int len, int k) {
    int kthSmallest = Integer.MAX_VALUE;
    for (int i = 0; i < k; i++) {
      for (int j = (len / 2) - 1; j >= 0; j--) {
        minHeapify(arr, len, j);
      }
      kthSmallest = extractMin(arr, len);
      len--;
    }
    return kthSmallest;
  }

  public static void minSort(int[] arr) {
    int len = arr.length;
    for (int i = (len / 2) - 1; i >= 0; i--) {
      minHeapify(arr, len, i);
    }

    for (int i = len - 1; i > 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      minHeapify(arr, i, 0);
    }
  }


  public static void maxSort(int[] arr) {
    int len = arr.length;
    for (int i = (len / 2) - 1; i >= 0; i--) {
      maxHeapify(arr, len, i);
    }

    for (int i = len - 1; i > 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      maxHeapify(arr, i, 0);
    }
  }

  public static void minHeapify(int[] arr, int len, int idx) {
    int smallest = idx;
    int left = smallest * 2 + 1;
    int right = smallest * 2 + 2;

    if (left < len && arr[left] < arr[smallest]) {
      smallest = left;
    }
    if (right < len && arr[right] < arr[smallest]) {
      smallest = right;
    }
    if (smallest != idx) {
      int temp = arr[idx];
      arr[idx] = arr[smallest];
      arr[smallest] = temp;
      minHeapify(arr, len, smallest);
    }
  }

  private static void maxHeapify(int[] arr, int len, int idx) {
    int largest = idx;
    int left = largest * 2 + 1;
    int right = largest * 2 + 2;

    if (left < len && arr[left] > arr[largest]) {
      largest = left;
    }
    if (right < len && arr[right] > arr[largest]) {
      largest = right;
    }
    if (largest != idx) {
      int temp = arr[idx];
      arr[idx] = arr[largest];
      arr[largest] = temp;
      maxHeapify(arr, len, largest);
    }
  }

  private static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  private static int findKthSmallest(List<Integer> list, int k) {
    if (list == null || list.size() < k) {
      return -1;
    }
    Queue<Integer> pq = new PriorityQueue<>(list);
    while (--k > 0) {
      pq.poll();
    }
    return pq.peek();
  }

  private static int findKthSmallestNew(List<Integer> list, int k) {
    if (list == null || list.size() < k) {
      return -1;
    }
    Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    pq.addAll(list);
    for (int i = k; i < list.size(); i++) {
      if (list.get(i) < pq.peek()) {
        pq.poll();
        pq.add(list.get(i));
      }
    }
    return pq.peek();
  }
}
