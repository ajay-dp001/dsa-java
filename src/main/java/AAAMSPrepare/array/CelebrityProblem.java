package AAAMSPrepare.array;

import java.util.Stack;

public class CelebrityProblem {

  public static void main(String[] args) {
    int arr[][] = {{0, 0, 1, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 0},
        {0, 0, 1, 0}};
    System.out.println(findCelebrity(arr));
  }

  private static int findCelebrity(int[][] arr) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      stack.push(i);
    }

    while (stack.size() >= 2) {
      int i = stack.pop();
      int j = stack.pop();

      if (arr[i][j] == 1) {
        stack.push(j);
      } else {
        stack.push(i);
      }
    }

    int cleb = stack.pop();
    for (int i = 0; i < arr.length; i++) {
      if (i != cleb) {
        if (arr[i][cleb] == 0 || arr[cleb][i] == 1) {
          return -1;
        }
      }
    }
    return cleb;

  }

}
