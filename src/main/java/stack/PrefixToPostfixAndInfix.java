package stack;

import java.util.Stack;

public class PrefixToPostfixAndInfix {

  private static boolean isOperator(char ch) {
    if (!Character.isLetterOrDigit(ch)) {
      return true;
    }
    return false;
  }

  private static String prefixToPostfix(String pre_exp) {
    Stack<String> stack = new Stack<>();
    for (int i = pre_exp.length() - 1; i >= 0; i--) {
      char ch = pre_exp.charAt(i);
      if (isOperator(ch)) {
        String opr1 = stack.pop();
        String opr2 = stack.pop();
        String tmp = opr1 + opr2 + ch;
        stack.push(tmp);
      } else {
        stack.push(ch + "");
      }
    }
    return stack.peek();
  }

  private static String prefixToInfix(String pre_exp) {
    Stack<String> stack = new Stack<>();
    for (int i = pre_exp.length() - 1; i >= 0; i--) {
      char ch = pre_exp.charAt(i);
      if (isOperator(ch)) {
        String opr1 = stack.pop();
        String opr2 = stack.pop();
        String tmp = opr1 + ch + opr2;
        stack.push(tmp);
      } else {
        stack.push(ch + "");
      }
    }
    return stack.peek();
  }

  public static void main(String[] args) {
    String pre_exp = "*-A/BC-/AKL";
    System.out.println("Postfix is :" + prefixToPostfix(pre_exp));
    System.out.println("Postfix is :" + prefixToInfix(pre_exp));
  }
}
