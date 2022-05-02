package stack;
//https://www.youtube.com/watch?v=lGWLBgwd-cw

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

  private static class Pair {

    int idx;
    int val;

    public Pair(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }
  }

  public static void main(String[] args) {
    int price[] = {10, 4, 5, 90, 120, 80};
    int price1[] = {10, 20, 15, 10, 18, 22};
    int[] result = calculateSpan(price1);
    System.out.println(Arrays.toString(result));
  }

  private static int[] calculateSpan(int[] arr) {
    int[] span = new int[arr.length];
    Stack<Integer> stk = new Stack<>();
    stk.push(0);
    span[0] = 1;

    for (int i = 1; i < arr.length; i++) {
      while (!stk.isEmpty() && arr[i] >= arr[stk.peek()]) {
        stk.pop();
      }
      span[i] = stk.isEmpty() ? (i + 1) : (i - stk.peek());
      stk.push(i);
    }
    return span;
  }


  private static int[] calculateSpan2(int[] arr) {
    int[] span = new int[arr.length];
    span[0] = 1;

    for (int i = 1; i < arr.length; i++) {
      int cnt = 1;
      while ((i - cnt) >= 0 && arr[i] > arr[i - cnt]) {
        cnt += span[i - cnt];
      }
      span[i] = cnt;
    }
    return span;
  }
}
