package AAAFinalPrep.array;

import java.util.Stack;

public class NextGreater {

  public static void main(String[] args) {
    int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
    int ln = arr.length;
    int[] nge = nextGonRight(arr, ln);
    for (int i = 0; i < ln; i++) {
      System.out.print(nge[i] + " ");
    }
  }

  private static int[] nextGonRight(int[] arr, int len) {
    int[] result = new int[len];
    result[len - 1] = -1;
    Stack<Integer> stack = new Stack<>();

    for (int i = len - 2; i >= 0; i--) {
      while (!stack.isEmpty() && arr[i] >= stack.peek()) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[i] = -1;
      } else {
        result[i] = stack.peek();
      }
      stack.push(arr[i]);
    }
    return result;
  }

}
