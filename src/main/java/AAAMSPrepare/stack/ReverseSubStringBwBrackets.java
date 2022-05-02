package AAAMSPrepare.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseSubStringBwBrackets {

  public static void main(String[] args) {
    String str = "(ni(pc(do))ep)g";
    String str_new = revSubStringBwBrackets(str);
    System.out.println(str_new);
  }

  private static String revSubStringBwBrackets(String str) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ')') {
        Queue<Character> queue = new LinkedList<>();
        while (stack.peek() != '(') {
          queue.add(stack.pop());
        }
        stack.pop();
        while (!queue.isEmpty()) {
          stack.push(queue.remove());
        }
      } else {
        stack.push(str.charAt(i));
      }
    }

    char[] ans = new char[stack.size()];
    int i = ans.length - 1;
    while (i >= 0) {
      ans[i] = stack.pop();
      i--;
    }
    return new String(ans);
  }

}
