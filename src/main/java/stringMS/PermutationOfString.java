package stringMS;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {

  static int total = 0;

  public static void main(String[] args) {
    String str = "ABA";
    int len = str.length();
    printPermutation(str, "");
    System.out.println();
    printPermutationNoDuplicates(str, "");
  }

  private static void printPermutation(String str, String asf) {
    if (str.length() == 0) {
      System.out.println(asf + " ");
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      String left = str.substring(0, i);
      String right = str.substring(i + 1);

      printPermutation(left + right, asf + ch);
    }
  }


  private static void printPermutationNoDuplicates(String str, String asf) {
    if (str.length() == 0) {
      System.out.println(asf + " ");
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
      String left = str.substring(0, i);
      String right = str.substring(i + 1);

      printPermutationNoDuplicates(left + right, asf + ch);
    }
  }

}
