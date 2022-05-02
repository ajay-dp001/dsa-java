package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParanthesis {

  public static void main(String[] args) {
    Set<String> result = new HashSet<>();
    String str1 = "()())()";
    int min_removal = getMin(str1);
    solution(str1, min_removal, result);
    result.clear();

    String str2 = "(a)())()";
    int min_removal_2 = getMin(str2);
    solution(str2, min_removal_2, result);
    result.clear();

    String str3 = ")(";
    int min_removal_3 = getMin(str3);
    solution(str3, min_removal_3, result);
  }

  private static void solution(String str, int min_removal, Set<String> result) {
    if (min_removal == 0) {
      int min_rem_now = getMin(str);
      if (min_rem_now == 0) {
        if (!result.contains(str)) {
          result.add(str);
          System.out.println(str);
        }
      }
      return;
    }
    for (int i = 0; i < str.length(); i++) {
      String str_left = str.substring(0, i);
      String str_right = str.substring(i + 1);
      solution(str_left + str_right, min_removal - 1, result);
    }
  }

  public static int getMin(String str) {
    Stack<Character> stk = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(') {
        stk.push(ch);
      } else if (ch == ')') {
        if (stk.size() == 0) {
          stk.push(ch);
        } else if (stk.peek() == ')') {
          stk.push(ch);
        } else if (stk.peek() == '(') {
          stk.pop();
        }
      }
    }
    return stk.size();
  }

  private int getMinRemovalFast(String str) {
    int open_bracket = 0, close_bracket = 0;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(') {
        open_bracket++;
      } else if (ch == ')') {
        if (open_bracket > 0) {
          open_bracket--;
        } else {
          close_bracket++;
        }
      }
    }
    return (open_bracket + close_bracket);
  }
}
