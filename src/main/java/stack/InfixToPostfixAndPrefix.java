package stack;

import java.util.Stack;

public class InfixToPostfixAndPrefix {

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
    }
    return -1;
  }

  private static String infixToPostfix(String str) {
    String result = "";
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
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

  private static String infixToPrefix(String str) {
    char[] chArray = reverse(str.toCharArray(), 0, str.length() - 1);
    String toRevStr = infixToPostfix(String.valueOf(chArray));
    char[] chArray1 = reverse(toRevStr.toCharArray(), 0, str.length() - 1);
    return String.valueOf(chArray1);
  }

  private static char[] reverse(char[] chArray, int start, int end) {
    while (start < end) {
      char tmp = chArray[start];
      chArray[start] = chArray[end];
      chArray[end] = tmp;
      start++;
      end--;
    }
    return chArray;
  }

  public static void main(String[] args) {
    String str = "a+b*(c^d-e)^(f+g*h)-i";
    System.out.println(infixToPostfix(str));
    String str1 = "x+y*z/w+u";
    System.out.print(infixToPrefix(str1));
  }
}
