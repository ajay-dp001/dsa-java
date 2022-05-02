package AAAMSPrepare.codility;

import java.util.Arrays;
import org.checkerframework.checker.units.qual.A;

public class SwapsToConvertStringToAnagram {

  public static void main(String[] args) {
    String s1 = "abcd";
    String s2 = "cdab";

    int size = s2.length();
    if (isAnagram(s1, s2)) {
      System.out.println(countSteps(s1.toCharArray(), s2.toCharArray(), size));
    } else {
      System.out.println(-1);
    }
  }

  private static boolean isAnagram(String s1, String s2) {
    s1 = sortString(s1);
    s2 = sortString(s2);
    return s1.equals(s2);
  }

  private static String sortString(String s1) {
    char[] chArr = s1.toCharArray();
    Arrays.sort(chArr);
    return new String(chArr);
  }

  public static int countSteps(char[] s1, char[] s2, int size) {
    int i = 0, j = 0, result = 0;
    while (i < size) {
      j = i;
      while (s1[j] != s2[i]) {
        j++;
      }
      while (i < j) {
        char temp = s1[j];
        s1[j] = s1[j - 1];
        s1[j - 1] = temp;
        j--;
        result++;
      }
      i++;
    }
    return result;
  }

}
