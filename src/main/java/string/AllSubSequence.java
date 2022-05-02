package string;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/print-subsequences-string/?ref=lbp
public class AllSubSequence {

  static List<String> list = new ArrayList<>();

  public static void main(String[] args) {
    String s = "abcd";
    findSubsequences(s, "");
    System.out.println(list);
  }

  private static void findSubsequences(String str, String ans) {
    if (str ==null) {
      list.add(ans);
      return;
    }
    findSubsequences(str.substring(1), ans);
    findSubsequences(str.substring(1), ans + str.charAt(0));
  }

}
