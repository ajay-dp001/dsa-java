package stack;

import java.util.ArrayList;
import java.util.List;

class RemoveInvalidParanthesisFastAccepted {

  public static void main(String[] args) {
    RemoveInvalidParanthesisFastAccepted solutionQ = new RemoveInvalidParanthesisFastAccepted();
    for (String str : solutionQ.removeInvalidParentheses("((()((s((((()")) {
      System.out.println(str);
    }
  }

  private List<String> removeInvalidParentheses(String str) {
    List<String> list = new ArrayList<>();

    remove(str, list, 0, 0, new char[]{'(', ')'});

    return list;
  }

  private void remove(String str, List<String> list, int last_i, int last_j, char[] charArray) {
    for (int k = 0, i = last_i; i < str.length(); i++) {
      if (str.charAt(i) == charArray[0]) {
        k++;
      }
      if (str.charAt(i) == charArray[1]) {
        k--;
      }
      if (k >= 0) {
        continue;
      }

      for (int j = last_j; j <= i; j++) {
        if (str.charAt(j) == charArray[1] && (j == last_j || str.charAt(j - 1) != charArray[1])) {
          remove(str.substring(0, j) + str.substring(j + 1), list, i, j, charArray);
        }
      }
      return;
    }

    String rst = new StringBuilder(str).reverse().toString();
    if (charArray[0] == '(') {
      remove(rst, list, 0, 0, new char[]{')', '('});
    } else {
      list.add(rst);
    }
  }
}
