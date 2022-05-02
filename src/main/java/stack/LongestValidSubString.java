package stack;

import java.util.Stack;

public class LongestValidSubString {

  private static int longestValidParentheses(String str) {
    int left = 0, right = 0, maxlength = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (left == right) {
        maxlength = Math.max(maxlength, 2 * right);
      } else if (right >= left) {
        left = right = 0;
      }
    }

    left = right = 0;
    for (int i = str.length() - 1; i >= 0; i--) {
      if (str.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (left == right) {
        maxlength = Math.max(maxlength, 2 * left);
      } else if (left >= right) {
        left = right = 0;
      }
    }
    return maxlength;
  }

  private static int findMaxLen2(String str) {
    int result = 0;
    Stack<Integer> stk = new Stack<>();
    stk.push(-1);
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        stk.push(i);
      } else {
        if (!stk.empty()) {
          stk.pop();
        }
        if (!stk.empty()) {
          result = Math.max(result, i - stk.peek());
        } else {
          stk.push(i);
        }
      }
    }
    return result;
  }

  private static int maxLength(String str, int n) {
    int dp[][] = new int[n][n];
    for (int l = 0; l < n; l++) {
      if (str.charAt(l) == '(' && str.charAt(l + 1) == ')') {
        dp[l][l + 1] = 2;
      }

      for (int k = 1; k < n; k++) {
        for (int i = 0, j = k; j < n; i++, j++) {
          if (str.charAt(i) == '(' && str.charAt(j) == ')') {
            dp[i][j] = 2 + dp[i + 1][j - 1];
            for (int m = i; m < j; m++) {
              dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j]);
            }
          }
        }
      }
    }
    return dp[0][n - 1];
  }

  //Not Fully working
  private static int maxLengthNew(String s, int n) {
    int invalidOpenBraces = 0;
    int invalidCloseBraces = 0;

    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        invalidOpenBraces++;
      } else {
        if (invalidOpenBraces == 0) {
          invalidCloseBraces++;
        } else {
          invalidOpenBraces--;
        }
      }
    }
    return (n - (invalidOpenBraces + invalidCloseBraces));
  }

  public static void main(String[] args) {
    String str = "((()()";
    System.out.println(findMaxLen2(str));
    System.out.println(maxLengthNew(str, str.length()));
    System.out.println(longestValidParentheses(str));

    String str4 = "((()()()()";
    System.out.println(findMaxLen2(str4));
    System.out.println(maxLengthNew(str4, str4.length()));
    System.out.println(longestValidParentheses(str4));

    String str1 = "()()(()))))";
    System.out.println(findMaxLen2(str1));
    System.out.println(maxLengthNew(str1, str1.length()));
    System.out.println(longestValidParentheses(str1));

    String str2 = "((()()()()()()(((())";
    System.out.println(findMaxLen2(str2));
    System.out.println(maxLengthNew(str2, str2.length()));
    System.out.println(longestValidParentheses(str2));

    String str3 = "((((())))))()()";
    System.out.println(findMaxLen2(str3));
    System.out.println(maxLengthNew(str3, str3.length()));
    System.out.println(longestValidParentheses(str3));

    String str5 = "((((())))))()()";
    System.out.println(findMaxLen2(str4));
    System.out.println(maxLengthNew(str4, str4.length()));
    System.out.println(longestValidParentheses(str4));
  }
}
