package backtracking;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintPermutation {

  public static void main(String[] args) {
    String str = "abc";
    printPermutation(str, "");

    System.out.println("*************************");

    String str1 = "ABCA";
    char[] chArr = str1.toCharArray();
    Arrays.sort(chArr);
    printPermutationNoDuplicate(String.valueOf(chArr), "");
  }

  // Time Complexity (n*n!)
  public static void printPermutation(String str, String asf) {
    if (str.length() == 0) {
      System.out.print(asf + " ");
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      String leftStr = str.substring(0, i);
      String rightStr = str.substring(i + 1);

      printPermutation(leftStr + rightStr, asf + ch);
    }
  }


  // Time Complexity (n*n!)
  public static void printPermutationNoDuplicate(String str, String asf) {
    if (str.length() == 0) {
      System.out.print(asf + " ");
      return;
    }
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (set.contains(ch)) {
        continue;
      } else {
        set.add(ch);
      }
      String leftStr = str.substring(0, i);
      String rightStr = str.substring(i + 1);

      printPermutationNoDuplicate(leftStr + rightStr, asf + ch);
    }
  }

}
