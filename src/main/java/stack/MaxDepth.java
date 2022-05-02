package stack;

public class MaxDepth {

  private static int maxDepth(String str) {
    int max = 0, curr_max = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        curr_max++;
        if (curr_max > max) {
          max = curr_max;
        }
      } else if (str.charAt(i) == ')') {
        if (curr_max > 0) {
          curr_max--;
        } else {
          return -1;
        }
      }
    }
    if (curr_max != 0) {
      return -1;
    }
    return max;
  }

  public static void main(String[] args) {
    String s = "( ((X)) (((Y))) )";
    System.out.println(maxDepth(s));
  }

}
