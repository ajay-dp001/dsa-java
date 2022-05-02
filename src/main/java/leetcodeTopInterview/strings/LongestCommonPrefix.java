package leetcodeTopInterview.strings;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs1 = {"flower", "flow", "flight"};
    String[] strs2 = {"dog", "racecar", "car"};
    System.out.println(longestPrefix(strs1));
    System.out.println(longestPrefix(strs2));
  }

  private static String longestPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    int i = 0;
    String pre = strs[0];
    while (i < strs.length) {
      while (strs[i].indexOf(pre) != 0) {
        pre = pre.substring(0, pre.length() - 1);
      }
      i++;
    }
    return pre;
  }

}
