package backtracking;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import org.checkerframework.checker.units.qual.A;

public class MinJump {

  private static class Pair {

    int i, s, j;
    String pathSoFar;

    Pair(int i, int s, int j, String pathSoFar) {
      this.i = i;
      this.s = s;
      this.j = j;
      this.pathSoFar = pathSoFar;
    }
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 1, 4};
    System.out.println("Can Jump :" + canJump(arr));

    int[] arr12 = {2, 3, 1, 1, 4};
    System.out.println("Can Jump :" + jumps(arr12));

    int arr1[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
    int len1 = arr1.length;
    System.out.print("Minimum number of jumps to reach end is " + minJumps(arr1, 0, len1 - 1));

    System.out.println();
    printJumps(arr);
  }

  // O(n)
  private static boolean canJump(int[] arr) {
    int lastGoodIndexPos = arr.length - 1;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (i + arr[i] >= lastGoodIndexPos) {
        lastGoodIndexPos = i;
      }
    }
    return lastGoodIndexPos == 0;
  }

  //O(n^2)
  //https://www.youtube.com/watch?v=BRnRPLNGWIo
  private static int jumps(int[] arr) {
    int len = arr.length;
    int[] dp = new int[len];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[len - 1] = 0;

    for (int i = len - 2; i >= 0; i--) {
      int min = Integer.MAX_VALUE;
      for (int j = i + 1; j <= Math.min(len - 1, i + arr[i]); j++) {
        min = Math.min(min, dp[j]);
      }
      if (min != Integer.MAX_VALUE) {
        dp[i] = min + 1;
      }
    }
    return dp[0];
  }

  private static int jumpOn(int[] arr) {
    int end = 0, farthest = 0, jump = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      farthest = Math.max(farthest, i + arr[i]);
      if (i == end) {
        jump++;
        end = farthest;
      }
    }
    return jump;
  }

  private static int minJumps(int[] arr, int start, int end) {
    if (start == end) {
      return 0;
    }
    if (arr[start] == 0) {
      return Integer.MAX_VALUE;
    }

    int min = Integer.MAX_VALUE;
    for (int i = start + 1; i <= end && i <= start + arr[start]; i++) {
      int jumps = minJumps(arr, i, end);
      if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
        min = jumps + 1;
      }
    }
    return min;
  }

  //https://www.youtube.com/watch?v=phgjL7SbsWs&list=RDCMUC7rNzgC2fEBVpb-q_acpsmw&start_radio=1&t=33s
  private static void printJumps(int[] arr) {
    Integer[] dp = new Integer[arr.length];
    dp[arr.length - 1] = 0;

    for (int i = arr.length - 2; i >= 0; i--) {
      int steps = arr[i];

      int min = Integer.MAX_VALUE;
      for (int j = 1; j <= steps && i + j < arr.length; j++) {
        if (dp[i + j] != null && dp[i + j] < min) {
          min = dp[i + j];
        }
      }
      if (min != Integer.MAX_VALUE) {
        dp[i] = min + 1;
      }
    }
    System.out.println(dp[0]);

    Deque<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(0, arr[0], dp[0], 0 + ""));

    while (queue.isEmpty()) {
      Pair temp = queue.removeFirst();
      if (temp.i == 0) {
        System.out.println(temp.pathSoFar + " .");
      }
      for (int i = 1; i <= temp.s && temp.i + i < arr.length; i++) {
        int curIndex = temp.i + i;
        if (dp[curIndex] != null && dp[curIndex] == temp.i - 1) {
          queue.add(new Pair(curIndex, arr[curIndex], dp[curIndex], temp.pathSoFar + "->" + curIndex));
        }
      }
    }
  }
}
