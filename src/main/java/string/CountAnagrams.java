package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {

  public static void main(String[] args) {
    String str = "forxxorfxdofr";
    String word = "for";
    System.out.print(countAnagrams(str, word));
  }

  private static int countAnagrams(String str, String word) {
    int sln = str.length();
    int pln = word.length();

    int cnt = 0;
    if (pln < 1 || sln < pln) {
      return cnt;
    }

    char[] sArr = new char[256];
    char[] pArr = new char[256];

    int i = 0;

    while (i < pln) {
      sArr[256 - str.charAt(i)]++;
      pArr[256 - word.charAt(i)]++;
      i++;
    }
    if (Arrays.equals(sArr, pArr)) {
      cnt++;
    }
    while (i < sln) {
      sArr[256 - str.charAt(i)]++;
      sArr[256 - str.charAt(i - pln)]--;
      i++;
      if (Arrays.equals(sArr, pArr)) {
        cnt++;
      }
    }
    return cnt;
  }

}
