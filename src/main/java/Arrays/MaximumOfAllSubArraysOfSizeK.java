package Arrays;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubArraysOfSizeK {

  public static void main(String[] args) {
    int k = 3;
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int len = arr.length;
    printKMax(arr, len, k);
    printKMaxEfficient(arr, len, k);
  }

  //O(N * K)
  private static void printKMax(int[] arr, int len, int k) {
    int max;
    for (int i = 0; i < len - k; i++) {
      max = arr[i];
      for (int j = 0; j <= k; j++) {
        if (arr[j + i] > max) {
          max = arr[j + i];
        }
      }
      System.out.println("Max is " + max);
    }
  }

  private static int[] printKMaxEfficient(int[] arr, int len, int k) {
    int[] res = new int[len - k + 1];
    Deque<Integer> deque = new LinkedList<>();
    int windowStart = 0;

    for (int i = 0; i < len; i++) {
      while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]) {
        deque.removeLast();
      }
      deque.addLast(i);
      if (i - windowStart + 1 == k) {
        res[windowStart] = arr[deque.peekFirst()];
        windowStart++;
        if (deque.peekFirst() < windowStart) {
          deque.removeFirst();
        }
      }
    }
    return res;
  }
}
