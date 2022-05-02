package AAAMSPrepare.arrayInterviewBit;

public class ImplementStrStr {

  public static void main(String[] args) {
    String haystack = "Hello";
    String needle = "ll";

    String haystack1 = "aaaaa";
    String needle1 = "bba";

    String haystack2 = "";
    String needle2 = "";

    String haystack3 = "abc";
    String needle3 = "bc";

    int indx = strStr(haystack3, needle3);
    int indx1 = strStrEff(haystack3, needle3);
    int indx2 = strStrNew(haystack3, needle3);
    System.out.println("Index " + indx);
    System.out.println("Index " + indx1);
    System.out.println("Index " + indx2);
  }

  private static int strStr(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return -1;
    }
    if (s1.equals(s2)) {
      return 0;
    }
    for (int i = 0; i < s1.length() - s2.length() + 1; i++) {
      if (s1.substring(i, i + s2.length()).equals(s2)) {
        return i;
      }
    }
    return -1;
  }

  private static int strStrEff(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    if (n == 0) {
      return 0;
    }
    if (m == 0 || m < n) {
      return -1;
    }
    return s1.indexOf(s2);
  }

  private static int strStrNew(String s1, String s2) {
    if (s2.isEmpty()) {
      return 0;
    }
    for (int i = 0; i <= s1.length() - s2.length(); i++) {
      if (s1.charAt(i) != s2.charAt(0)) {
        continue;
      }
      if (s1.substring(i, i + s2.length()).equals(s2)) {
        return i;
      }
    }
    return -1;
  }

}
