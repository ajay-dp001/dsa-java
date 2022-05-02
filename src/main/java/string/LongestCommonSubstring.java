package string;

//https://www.youtube.com/watch?v=NvmJBCn4eQI
public class LongestCommonSubstring {

  public static void main(String[] args) {
    String s1 = "pqabcxy";
    String s2 = "xyzabcp";

    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    int row = 0, col = 0, max = 0;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        }
        if (dp[i][j] > max) {
          max = dp[i][j];
          row = i;
          col = j;
        }
      }
    }

    System.out.println(max);
    String res = "";

    while (dp[row][col] != 0) {
      res += s1.charAt(row - 1);
      row--;
      col--;
    }
    // In reverse Order
    System.out.println(res);
  }
}
