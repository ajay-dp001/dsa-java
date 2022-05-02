package string;

//https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
//https://www.youtube.com/watch?v=RiNzHfoA2Lo
public class LongestPalindromicSubSequence {

  public static void main(String[] args) {
    String str = "abkccbc";
    String str1 = "bbbab";
    int ln = str.length();
    int ln1 = str1.length();
    longPalindromicSubSequence(str1, ln1);
  }

  private static void longPalindromicSubSequence(String str, int ln) {
    int[][] dp = new int[ln][ln];

    for (int g = 0; g < ln; g++) {
      for (int i = 0, j = g; j < dp.length; i++, j++) {
        if (g == 0) {
          dp[i][j] = 1;
        } else if (g == 1) {
          dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
        } else {
          if (str.charAt(i) == str.charAt(j)) {
            dp[i][j] = 2 + dp[i + 1][j - 1];
          } else {
            dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
          }
        }
      }
    }
    System.out.println("Ans :" + dp[0][ln - 1]);
  }
}
