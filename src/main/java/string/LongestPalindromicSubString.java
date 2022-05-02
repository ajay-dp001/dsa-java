package string;

public class LongestPalindromicSubString {

  public static void main(String[] args) {
    String str1 = "babad";
    String str2 = "cbbd";

    System.out.println(longestPalindromiString(str1));
    System.out.println(longestPalindromiString(str2));

  }

  private static String longestPalindromiString(String str) {
    if (str == null || str.length() < 1) {
      return "";
    }
    int start = 0;
    int end = 0;

    for (int i = 0; i < str.length(); i++) {
      int len1 = expandFromMiddle(str, i, i);
      int len2 = expandFromMiddle(str, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - ((len - 1) / 2);
        end = i + (len / 2);
      }
    }
    return str.substring(start, end + 1);
  }

  private static int expandFromMiddle(String str, int left, int right) {
    if (str == null || left > right) {
      return 0;
    }
    while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}
