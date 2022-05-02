package stringMS;

import java.util.Map;

public class EditDistance {

  public static void main(String[] args) {
    String s1 = "gfg", s2 = "gfkl";
    if (isEditDistanceOne(s1, s2)) {
      System.out.print("Yes");
    } else {
      System.out.print("No");
    }
  }

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
}
