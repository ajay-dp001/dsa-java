package string;

//https://www.youtube.com/watch?v=sSno9rV8Rhg
//https://www.youtube.com/watch?v=0Ql40Llp09E&ab_channel=Pepcoding
// TODO https://www.geeksforgeeks.org/print-longest-common-sub-sequences-lexicographical-order/
public class LongestCommonSubsequence {

  static int MAX = 100;
  static int lcsLength = 0;
  static int[][] dp = new int[MAX][MAX];

  public static void main(String[] args) {
    String s1 = "abcd";
    String s2 = "aebd";

    longestCommonSubsequence(s1, s2);
    lcs(s1, s2, s1.length(), s2.length());

    String S1 = "ACADB", S2 = "CBDA";
    int m = S1.length(), n = S2.length();
    lcs(S1, S2, m, n);

    String S11 = "BCDAACD", S22 = "ACDBAC";
    int m1 = S11.length(), n1 = S22.length();
    lcs(S11, S22, m1, n1);
  }

  private static int longestCommonSubsequence(String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];

    for (int i = dp.length - 2; i >= 0; i--) {
      for (int j = dp[0].length - 2; j >= 0; j--) {
        if (s1.charAt(i) == s2.charAt(j)) {
          dp[i][j] = 1 + dp[i + 1][j + 1];
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        }
      }
    }
    System.out.println(dp[0][0]);
    return dp[0][0];
  }


  private static void lcs(String s1, String s2, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    int idx = dp[m][n];
    int temp = idx;

    char[] lcs = new char[idx + 1];

    int i = m, j = n;
    while (i > 0 && j > 0) {
      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        lcs[idx - 1] = s1.charAt(i - 1);
        i--;
        j--;
        idx--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

    //Print Subsequence
    System.out.print("S1 : " + s1 + "\nS2 : " + s2 + "\n LCS: ");
    for (int k = 0; k <= temp; k++) {
      System.out.print(lcs[k]);
    }
  }
}
