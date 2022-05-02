package string;

//https://www.youtube.com/watch?v=oL7GCrcdaJI
//https://www.geeksforgeeks.org/longest-repeated-subsequence/
public class LongestRepeatingSubsequenceWithIndexNotRepeating {

  public static void main(String[] args) {
    String str = "abacbc";
    System.out.println(longestRepeatingSubsequence(str));
  }

  private static int longestRepeatingSubsequence(String str) {
    int[][] dp = new int[str.length() + 1][str.length() + 1];

    for (int i = dp.length - 1; i >= 0; i--) {
      for (int j = dp[0].length - 1; j >= 0; j--) {
        if (i == dp.length - 1 && j == dp[0].length - 1) {
          dp[i][j] = 0;
        } else if (i == dp.length - 1) {
          dp[i][j] = 0;
        } else if (j == dp[0].length - 1) {
          dp[i][j] = 0;
        } else {
          if (str.charAt(i) == str.charAt(j) && i != j) {
            dp[i][j] = dp[i + 1][j + 1] + 1;
          } else {
            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
          }
        }
      }
    }
    return dp[0][0];
  }

  static String longestRepeatedSubSeq(String str) {
    int n = str.length();
    int[][] dp = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }

    String res = "";

    // Traverse dp[][] from bottom right
    int i = n, j = n;
    while (i > 0 && j > 0) {
      // If this cell is same as diagonally
      // adjacent cell just above it, then
      // same characters are present at
      // str[i-1] and str[j-1]. Append any
      // of them to result.
      if (dp[i][j] == dp[i - 1][j - 1] + 1) {
        res = res + str.charAt(i - 1);
        i--;
        j--;
      }

      // Otherwise we move to the side
      // that that gave us maximum result
      else if (dp[i][j] == dp[i - 1][j]) {
        i--;
      } else {
        j--;
      }
    }

    // Since we traverse dp[][] from bottom,
    // we get result in reverse order.
    String reverse = "";
    for (int k = res.length() - 1; k >= 0; k--) {
      reverse = reverse + res.charAt(k);
    }
    return reverse;
  }

}
