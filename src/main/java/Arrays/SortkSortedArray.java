package Arrays;

import java.util.PriorityQueue;

public class SortkSortedArray {

  public static void main(String[] args) {
    int k = 3;
    int arr[] = {2, 6, 3, 12, 56, 8};
    int len = arr.length;
    kSort(arr, len, k);
  }

  private static void kSort(int[] arr, int len, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i <= k; i++) {
      pq.add(arr[i]);
    }

    for (int j = k + 1; j < arr.length; j++) {
      System.out.println(pq.remove());
      pq.add(arr[j]);
    }

    while (pq.size() > 0) {
      System.out.println(pq.remove());
    }
  }
}
