package stringMS;

import java.util.Arrays;

public class CountAnagrams {

  public static void main(String[] args) {
    String str = "forxxorfxdofr";
    String word = "for";
    System.out.print(countAnagrams(str, word));
  }

  private static int countAnagrams(String str, String pattern) {
    int slen = str.length();
    int plen = pattern.length();

    if (slen < 0 || plen < 0 || slen < plen) {
      return 0;
    }

    char[] sarr = new char[256];
    char[] parr = new char[256];

    int cnt = 0, i = 0;
    while (i < plen) {
      sarr[256-str.charAt(i)]++;
      parr[256-str.charAt(i)]++;
      i++;
    }
    if (Arrays.equals(sarr, parr)) {
      cnt++;
    }

    while (i < slen) {
      sarr[256-str.charAt(i)]++;
      parr[256-str.charAt(i - plen)]++;
      i++;
      if (Arrays.equals(sarr, parr)) {
        cnt++;
      }
    }
    return cnt;
  }

}
