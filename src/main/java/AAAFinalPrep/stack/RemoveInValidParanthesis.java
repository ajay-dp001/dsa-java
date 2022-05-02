package AAAFinalPrep.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveInValidParanthesis {

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
      int min_rmv_now = getMin(str);
      if (min_rmv_now == 0) {
        if (!result.contains(str)) {
          result.add(str);
          System.out.println(str);
        }
      }
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      String left = str.substring(0, i);
      String right = str.substring(i + 1);
      solution(left + right, min_removal - 1, result);
    }
  }

  private static int getMin(String str) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(') {
        stack.push(ch);
      } else if (ch == ')') {
        if (stack.size() == 0 || stack.peek() == ')') {
          stack.push(ch);
        } else if (stack.peek() == '(') {
          stack.pop();
        }
      }
    }
    return stack.size();
  }



}
