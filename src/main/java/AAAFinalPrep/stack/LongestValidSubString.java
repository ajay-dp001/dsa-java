package AAAFinalPrep.stack;

import java.util.Stack;

public class LongestValidSubString {

  public static void main(String[] args) {
    String str = "((()()";
    System.out.println(findMaxLen2(str));

    String str4 = "((()()()()";
    System.out.println(findMaxLen2(str4));

    String str1 = "()()(()))))";
    System.out.println(findMaxLen2(str1));

    String str2 = "((()()()()()()(((())";
    System.out.println(findMaxLen2(str2));

    String str3 = "((((())))))()()";
    System.out.println(findMaxLen2(str3));

    String str5 = "((((())))))()()";
    System.out.println(findMaxLen2(str5));
  }

  private static int findMaxLen2(String str) {
    int result = 0;
    int len = str.length();
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    for (int i = 0; i < len; i++) {
      char ch = str.charAt(i);
      if (ch == '(') {
        stack.push(i);
      } else {
        if (!stack.isEmpty()) {
          stack.pop();
        }
        if (!stack.isEmpty()) {
          result = Math.max(result, i - stack.peek());
        } else {
          stack.push(i);
        }
      }
    }
    return result;
  }

}
