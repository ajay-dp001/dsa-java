package misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidBracket {

  public static void main(String[] args) {
    String exp = "()())()";
    removeInvalidParenthesis(exp);
  }

  private static void removeInvalidParenthesis(String str) {
    if (str.isEmpty()) {
      return;
    }
    String tmp;
    boolean level = false;
    Set<String> set = new HashSet<>();
    set.add(str);

    Queue<String> queue = new LinkedList<>();
    queue.add(str);

    while (!queue.isEmpty()) {
      str = queue.remove();
      if (isValidStr(str)) {
        level = true;
        System.out.println(str);
      }

      if (level) {
        continue;
      }
      for (int i = 0; i < str.length(); i++) {
        if (!isParenthesis(str.charAt(i))) {
          continue;
        }
        tmp = str.substring(0, i) + str.substring(i + 1);
        if (!set.contains(tmp)) {
          queue.add(tmp);
          set.add(tmp);
        }
      }
    }
  }

  private static boolean isParenthesis(char ch) {
    return ((ch == '(') || (ch == ')'));
  }

  private static boolean isValidStr(String str) {
    int cnt = 0;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(') {
        cnt++;
      } else if (ch == ')') {
        cnt--;
      }
      if (cnt < 0) {
        return false;
      }
    }
    return (cnt == 0);
  }

}
