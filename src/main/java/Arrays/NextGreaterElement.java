package Arrays;

import java.util.Stack;

public class NextGreaterElement {

  public static void main(String[] args) {
    int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
    int ln = arr.length;
    int[] nge = nextGonRight(arr, ln);
    for (int i = 0; i < ln; i++) {
      System.out.print(nge[i] + " ");
    }
  }

  private static int[] nextGonRight(int[] arr, int ln) {
    int[] nge = new int[ln];
    Stack<Integer> stack = new Stack<>();
    stack.push(arr[ln - 1]);
    nge[ln - 1] = -1;

    for (int i = ln - 2; i >= 0; i--) {
      while (!stack.isEmpty() && arr[i] >= stack.peek()) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        nge[i] = -1;
      } else {
        nge[i] = stack.peek();
      }
      stack.push(arr[i]);
    }
    return nge;
  }
}
