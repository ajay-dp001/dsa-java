package Aprepmustdoproblems;

public class PalindromeSubString {

  public static void main(String[] args) {
    String str = "cbbd";
    countPlanindrom(str);
  }

  private static void countPlanindrom(String str) {
    boolean[][] dp = new boolean[str.length()][str.length()];
    int cnt = 0, len = 0;
    String ans = "";
    for (int dia = 0; dia < str.length(); dia++) {
      for (int row = 0, col = dia; col < dp.length; row++, col++) {
        if (dia == 0) {
          ans = str.charAt(dia) + " ";
          dp[row][col] = true;
        } else if (dia == 1) {
          if (str.charAt(row) == str.charAt(col)){
            dp[row][col] = true;
            ans = str.substring(row, col + 1);
          }
        } else {
          if (str.charAt(row) == str.charAt(col) && dp[row + 1][col - 1]) {
            dp[row][col] = true;
            if (ans.length() < col - row + 1) {
              ans = str.substring(row, col + 1);
            }
          }
        }
        if (dp[row][col]) {
          cnt++;
          len = dia + 1;
        }
      }
    }
    System.out.println(cnt);
    System.out.println(len);
    System.out.println(ans);
  }
}
