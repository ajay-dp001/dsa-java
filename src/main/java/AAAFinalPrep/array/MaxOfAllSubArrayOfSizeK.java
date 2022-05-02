package AAAFinalPrep.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxOfAllSubArrayOfSizeK {

  public static void main(String[] args) {
    int k = 3;
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int len = arr.length;
    //printKMax(arr, len, k);
    printKMaxEfficient(arr, len, k);

  }

  public static void printKMax(int[] arr, int len, int k) {
    for (int i = 0; i <= len - k; i++) {
      int max_num = arr[i];
      for (int j = 0; j < k; j++) {
        if (arr[j + i] > max_num) {
          max_num = arr[j + i];
        }
      }
      System.out.print(max_num + " ");
    }
  }

  private static int[] printKMaxEfficient(int[] arr, int len, int k) {
    int[] result = new int[len - k + 1];
    Deque<Integer> dq = new ArrayDeque<>();

    int windowStart = 0;
    for (int i = 0; i < len; i++) {
      while (!dq.isEmpty() && arr[dq.getLast()] <= arr[i]) {
        dq.removeLast();
      }
      dq.addLast(i);

      if (i - windowStart + 1 == k) {
        result[windowStart] = arr[dq.peekFirst()];
        windowStart++;
        if (dq.peekFirst() < windowStart) {
          dq.removeFirst();
        }
      }
    }
    return result;
  }

  private static int[] printKMaxEfficientSol(int[] arr, int len, int k) {
    int[] result = new int[len - k + 1];
    Deque<Integer> dq = new ArrayDeque<>();
    int left = 0, right = 0;

    while (right < len) {
      while (!dq.isEmpty() && arr[dq.getLast()] <= arr[right]) {
        dq.removeLast();
      }
      dq.addLast(right);
      //OutOfBound
      if (left > dq.peekFirst()) {
        dq.removeFirst();
      }
      if (right + 1 >= k) {
        result[left] = arr[dq.removeFirst()];
        System.out.print(result[left] + " ");
        left++;
      }
      right++;
    }
    return result;
  }

}
