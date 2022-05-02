package stack;

import java.util.Stack;

//https://www.youtube.com/watch?list=TLGG4T3biVqhlAgyNDAxMjAyMg&time_continue=1450&v=41VuLYR0btE&feature=emb_logo
public class MaxHistogram {

  public static void main(String[] args) {
    int[] arr1 = {2, 1, 5, 6, 2, 3};
    int[] arr2 = {3, 2, 3, 2};
    int maxArea1 = maxRectangle(arr2);
    System.out.println("Max :" + maxArea1);
    int maxArea2 = maxAreaHistogram(arr2);
    System.out.println("Max :" + maxArea2);
  }

  //Efficient
  private static int maxRectangle(int[] arr) {
    int maxArea = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);

    for (int i = 0; i <= arr.length; i++) {
      int val = (i == arr.length) ? 0 : arr[i];

      while (stack.peek() != -1 && arr[stack.peek()] >= val) {
        int rightMin = i;
        int height = arr[stack.pop()];
        int leftMin = stack.peek();
        maxArea = Math.max(maxArea, height * (rightMin - leftMin - 1));
      }
      stack.push(i);
    }
    return maxArea;
  }

  private static int maxAreaHistogram(int[] arr) {
    int[] left_boundary = new int[arr.length];
    Stack<Integer> stack_left = new Stack<>();
    stack_left.push(0);

    left_boundary[0] = -1;
    for (int i = 1; i < arr.length; i++) {
      while (!stack_left.isEmpty() && arr[i] <= arr[stack_left.peek()]) {
        stack_left.pop();
      }
      if (stack_left.isEmpty()) {
        left_boundary[i] = -1;
      } else {
        left_boundary[i] = stack_left.peek();
      }
      stack_left.push(i);
    }

    int[] right_boundary = new int[arr.length];
    Stack<Integer> stack = new Stack<>();
    stack.push(arr.length - 1);

    right_boundary[arr.length - 1] = arr.length;
    for (int i = arr.length - 2; i >= 0; i--) {
      while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        right_boundary[i] = arr.length;
      } else {
        right_boundary[i] = stack.peek();
      }
      stack.push(i);
    }

    int maxArea = 0;
    for (int i = 0; i < arr.length; i++) {
      int width = right_boundary[i] - left_boundary[i] - 1;
      int area = arr[i] * width;
      if (area > maxArea) {
        maxArea = area;
      }
    }
    return maxArea;
  }

  public static int[] nextGreaterOnLeft(int[] arr) {
    int len = arr.length;
    int[] res = new int[len];

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < len; i++) {
      while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
      }

      if (!stack.isEmpty()) {
        res[i] = stack.peek();
      } else {
        res[i] = -1;
      }
      stack.push(arr[i]);
    }
    return res;
  }
}
