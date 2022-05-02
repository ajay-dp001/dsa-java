package stringMS;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LexicographicOrderSubSequence {

  public static void main(String[] args) {
    String str = "abc";
    Set<String> set = new TreeSet<>();
    generate(str, set);
    for (String s : set) {
      System.out.print(s + " ");
    }
    System.out.println();
    Set<String> set1 = new TreeSet<>();
    subSequence(str, " ", set1);
    for (String s1 : set1) {
      System.out.print(s1 + " ");
    }
  }

  private static void generate(String str, Set<String> set) {
    if (str.length() == 0) {
      return;
    }
    if (!set.contains(str)) {
      set.add(str);
      for (int i = 0; i < str.length(); i++) {
        String tempStr = str.substring(0, i) + str.substring(i + 1);
        generate(tempStr, set);
      }
    }
  }

  private static void subSequence(String str, String ans, Set<String> set) {
    if (str.length() == 0) {
      set.add(ans);
      return;
    }
    char ch = str.charAt(0);
    String restOfString = str.substring(1);

    subSequence(restOfString, ans, set);
    subSequence(restOfString, ans + ch, set);
  }


}
