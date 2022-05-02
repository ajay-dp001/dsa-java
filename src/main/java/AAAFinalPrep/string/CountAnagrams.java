package AAAFinalPrep.string;

import java.util.Arrays;

public class CountAnagrams {

  public static void main(String[] args) {
    String str = "forxxorfxdofr";
    String word = "for";
    System.out.print(countAnagrams(str, word));
  }

  private static int countAnagrams(String str, String wrd) {
    int i = 0, cnt = 0;
    int strln = str.length();
    int wrdlen = wrd.length();
    if (strln < wrdlen || strln == 0 || wrdlen == 0) {
      return cnt;
    }
    int[] strArr = new int[256];
    int[] wrdArr = new int[256];
    while (i < wrdlen) {
      strArr[256 - str.charAt(i)]++;
      wrdArr[256 - wrd.charAt(i)]++;
      i++;
    }
    if (Arrays.equals(strArr, wrdArr)) {
      cnt++;
    }
    while (i < strln) {
      strArr[256 - str.charAt(i)]++;
      strArr[256 - str.charAt(i - wrdlen)]--;
      i++;
      if (Arrays.equals(strArr, wrdArr)) {
        cnt++;
      }
      System.out.println();
    }
    return cnt;
  }
}
