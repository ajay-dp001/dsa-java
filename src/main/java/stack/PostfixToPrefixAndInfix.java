package stack;

import java.util.Stack;

public class PostfixToPrefixAndInfix {

  private static boolean isOperator(char ch) {
    if (!Character.isLetterOrDigit(ch)) {
      return true;
    }
    return false;
  }

  private static String postToPre(String pre_exp) {
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < pre_exp.length(); i++) {
      char ch = pre_exp.charAt(i);
      if (isOperator(ch)) {
        String opr1 = stack.pop();
        String opr2 = stack.pop();
        String tmp = ch + opr2 + opr1;
        stack.push(tmp);
      } else {
        stack.push(ch + "");
      }
    }
    return stack.peek();
  }

  private static String postTInfix(String pre_exp) {
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < pre_exp.length(); i++) {
      char ch = pre_exp.charAt(i);
      if (isOperator(ch)) {
        String opr1 = stack.pop();
        String opr2 = stack.pop();
        String tmp = opr2 + ch + opr1;
        stack.push(tmp);
      } else {
        stack.push(ch + "");
      }
    }
    return stack.peek();
  }


  public static void main(String[] args) {
    String post_exp = "ABC/-AK/L-*";
    System.out.println("Prefix exp is :" + postToPre(post_exp));
    String str1= "ab*c+";
    System.out.println("Prefix exp is :" + postTInfix(str1));
  }

}
