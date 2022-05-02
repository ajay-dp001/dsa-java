package stack;

import java.util.Stack;

public class MaxRectangle {

  public static void main(String[] args) {
    int[][] arr = {
        {1, 0, 1, 0, 0},
        {1, 0, 1, 1, 1},
        {1, 1, 1, 1, 1},
        {1, 0, 0, 1, 0}};
    int[][] arr1 = {
        {1, 0}, {1, 0}};

    System.out.println(maxRectangle(arr1));
  }

  private static int maxRectangle(int[][] arr) {
    int[] heightArr = new int[arr[0].length];

    for (int i = 0; i < arr[0].length; i++) {
      heightArr[i] = arr[0][i];
    }
    int area = maxRectangle(heightArr);

    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 1) {
          heightArr[j]++;
        } else {
          heightArr[j] = 0;
        }
      }
      area = Math.max(area, maxRectangle(heightArr));
    }
    return area;
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
}
