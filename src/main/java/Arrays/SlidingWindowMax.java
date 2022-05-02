package Arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

public class SlidingWindowMax {

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int k = 3;
    //Time:O(N*K) Space: O(1)
    printKMaxUsingSlidingWindow(arr, arr.length, k);
    //Time :O(N), Space: O(K)
    System.out.println(Arrays.toString(printKMaxUsingSlidingWindowUsingQueue(arr, arr.length, k)));
  }

  private static int[] printKMaxUsingSlidingWindowUsingQueue(int[] arr, int len, int k) {
    if (len == 0 || k == 0) {
      return new int[0];
    }
    int[] resultArr = new int[len - k + 1];
    Deque<Integer> window = new ArrayDeque<>();

    for (int i = 0; i < len; i++) {
      while (!window.isEmpty() && window.peekFirst() <= (i - k)) {
        window.pollFirst();
      }
      while (!window.isEmpty() && arr[window.peekLast()] < arr[i]) {
        window.pollLast();
      }
      window.offerLast(i);
      if (i >= k - 1) {
        resultArr[i - k + 1] = arr[window.peekFirst()];
      }

    }
    return resultArr;
  }

  private static void printKMaxUsingSlidingWindow(int[] arr, int length, int k) {
    int j, max;
    for (int i = 0; i <= length - k; i++) {
      max = arr[i];
      for (j = 1; j < k; j++) {
        if (arr[i + j] > max) {
          max = arr[i + j];
        }
      }
      System.out.print(max + " ");
    }
  }

}
