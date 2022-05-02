package string;
//https://www.youtube.com/watch?v=We3YDTzNXEk
//https://www.geeksforgeeks.org/edit-distance-dp-5/
public class EditDistance {

  public static void main(String[] args) {
    String s1 = "gfg", s2 = "gf";
    if (isEditDistanceOne(s1, s2)) {
      System.out.print("Yes");
    } else {
      System.out.print("No");
    }
    int min= minDistance(s1, s2);
    System.out.println(min);
  }

  //Time : O(n) Space O(1)
  private static boolean isEditDistanceOne(String s1, String s2) {
    int len1 = s1.length(), len2 = s2.length();
    if (Math.abs(len1 - len2) > 1) {
      return false;
    }

    int i = 0, j = 0, cnt = 0;
    while (i < len1 && j < len2) {
      if (s1.charAt(i) != s2.charAt(j)) {
        if (cnt == 1) {
          return false;
        }
        if (len1 > len2) {
          i++;
        } else if (len1 < len2) {
          j++;
        } else {
          i++;
          j++;
        }
        cnt++;
      } else {
        i++;
        j++;
      }
    }

    if (i < len1 || j < len2) {
      cnt++;
    }
    return cnt == 1;
  }


  public static int minDistance(String w1, String w2) {
    int len1 = w1.length();
    int len2 = w2.length();

    int[][] dp = new int[len1 + 1][len2 + 1];

    for (int i = 0; i <= len1; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= len2; i++) {
      dp[0][i] = i;
    }
    for (int i = 0; i < len1; i++) {
      for (int j = 0; j < len2; j++) {
        if (w1.charAt(i) == w2.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j];
        } else {
          dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]) + 1;
        }
      }

    }
    return dp[len1][len2];

  }
}
