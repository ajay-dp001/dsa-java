package AAAFinalPrep.stack;

import java.util.Stack;

public class InfixToPostfixAndPrefix {

  public static void main(String[] args) {
    String str = "a+b*(c^d-e)^(f+g*h)-i";
    System.out.println(infixToPostfix(str));

    System.out.println();

    String str1 = "x+y*z/w+u";
    String inFixToPrefix = infixToPrefix(str1);
    System.out.println(inFixToPrefix);
    String prefixToInFix = prefixToInfix(inFixToPrefix);
    System.out.println(prefixToInFix);

    System.out.println();

    String str2 = "(A+B/C*(D+E)-F)";
    String infixToPostFix = infixToPostfix(str2);
    System.out.println(infixToPostFix);
    System.out.println();
    String postFixToInFix = postFixToInfix(infixToPostFix);
    System.out.println(postFixToInFix);
  }

  private static int getPrecedence(char ch) {
    switch (ch) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
      default:
        return -1;
    }
  }

  private static String infixToPostfix(String str) {
    String result = "";
    int len = str.length();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < len; i++) {
      char ch = str.charAt(i);

      if (Character.isLetterOrDigit(ch)) {
        result += ch;
      } else if (ch == '(') {
        stack.push(ch);
      } else if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          result += stack.pop();
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
          result += stack.pop();
        }
        stack.push(ch);
      }
    }
    while (!stack.isEmpty()) {
      if (stack.peek() == '(') {
        return "Invalid Expression";
      }
      result += stack.pop();
    }
    return result;
  }

  private static String postFixToInfix(String str) {
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (isOperand(ch)) {
        stack.push(ch + "");
      } else {
        if (!stack.isEmpty()) {
          String op1 = stack.pop();
          String op2 = stack.pop();
          stack.push("(" + op2 + ch + op1 + ")");
        }
      }
    }
    return stack.peek();
  }

  private static boolean isOperand(char ch) {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
  }

  private static boolean isOperator(char ch) {
    switch (ch) {
      case '+':
      case '-':
      case '*':
      case '/':
      case '^':
        return true;
    }
    return false;
  }

  private static String prefixToInfix(String str) {
    Stack<String> stack = new Stack<>();
    int len = str.length();

    for (int i = len - 1; i >= 0; i--) {
      char ch = str.charAt(i);
      if (isOperator(ch)) {
        String op1 = stack.pop();
        String op2 = stack.pop();
        stack.push("(" + op1 + ch + op2 + ")");
      } else {
        stack.push(ch + "");
      }
    }
    return stack.pop();
  }

  private static String infixToPrefix(String str) {
    char[] charArr = reverse(str.toCharArray(), 0, str.length() - 1);
    String infixToPostfix = infixToPostfix(String.valueOf(charArr));
    char[] prefix = reverse(infixToPostfix.toCharArray(), 0, str.length() - 1);
    return String.valueOf(prefix);
  }

  private static char[] reverse(char[] chArr, int start, int end) {
    while (start < end) {
      char tempChar = chArr[start];
      chArr[start] = chArr[end];
      chArr[end] = tempChar;
      start++;
      end--;
    }
    return chArr;
  }

}
