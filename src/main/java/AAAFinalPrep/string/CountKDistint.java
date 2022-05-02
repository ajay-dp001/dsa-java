package AAAFinalPrep.string;

import java.util.Arrays;

public class CountKDistint {

  public static void main(String[] args) {
    int k = 3;
    String str = "abcabdabbcfa";
    System.out.println("Count Sub String");
    // countSubString(str);
    // countSubStringOptimized(str);
    System.out.println(countkDist(str, k));
    int k1 = 2;
    String str1 = "abc";
    System.out.println(countkDist(str1, k1));
    int k2 = 2;
    String str2 = "aba";
    System.out.println(countkDist(str2, k2));
  }

  private static int countkDist(String str, int k) {
    int result = 0;
    int len = str.length();
    int[] cnt = new int[26];

    for (int i = 0; i < len; i++) {
      int distCnt = 0;
      Arrays.fill(cnt, 0);
      for (int j = i; j < len; j++) {
        if (cnt[str.charAt(j) - 'a'] == 0) {
          distCnt++;
        }
        cnt[str.charAt(j) - 'a']++;
        if (distCnt == k) {
          result++;
        }
      }
    }
    return result;
  }

  //N^3
  private static void countSubString(String str) {
    int len = str.length();
    for (int i = 0; i < len; i++) {
      for (int j = i; j < len; j++) {
        for (int k = i; k <= j; k++) {
          System.out.print(str.charAt(k));
        }
        System.out.println();
      }
    }
  }

  //N^2
  private static void countSubStringOptimized(String str) {
    int len = str.length();
    for (int i = 0; i < len; i++) {
      String subStr = "";
      for (int j = i; j < len; j++) {
        subStr += str.charAt(j);
        System.out.print(subStr + "\n");
      }
    }
  }
}
