package AAAFinalPrep.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParanthesis {

  public static void main(String[] args) {
    int n = 3;
    List<String> lis = generate(n);
    for (String str : lis) {
      System.out.print(str + "");
      System.out.println();
    }
  }

  private static List<String> generate(int n) {
    List<String> result = new ArrayList<>();
    generateParenthesis("(", 1, 0, result, n);
    return result;
  }

  private static void generateParenthesis(String str, int openCnt, int closeCnt, List<String> result, int n) {
    if (str.length() == 2 * n) {
      result.add(str);
      return;
    }
    if (openCnt < n) {
      generateParenthesis(str + "(", openCnt + 1, closeCnt, result, n);
    }
    if (closeCnt < openCnt) {
      generateParenthesis(str + ")", openCnt, closeCnt + 1, result, n);
    }
  }

}
