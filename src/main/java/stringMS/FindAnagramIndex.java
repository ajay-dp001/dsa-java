package stringMS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import linklist.LinkList;
import org.checkerframework.checker.units.qual.A;

public class FindAnagramIndex {

  public static void main(String[] args) {
    String str = "cbaebabacd";
    String pat = "abc";
    List<Integer> result = findAnagramIndex(str, pat);
    System.out.println(result);
  }

  private static List<Integer> findAnagramIndex(String str, String pat) {
    int slen = str.length(), plen = pat.length();
    List<Integer> resultList = new ArrayList<>();

    if (plen < 1 || slen < plen) {
      return resultList;
    }

    int[] sarr = new int[26];
    int[] parr = new int[26];

    int i = 0;
    while (i < plen) {
      sarr[str.charAt(i) - 'a']++;
      parr[str.charAt(i) - 'a']++;
      i++;
    }
    if (Arrays.equals(sarr, parr)) {
      resultList.add(0);
    }

    while (i < slen) {
      sarr[str.charAt(i) - 'a']++;
      sarr[str.charAt(i - plen) - 'a']--;
      i++;
      if (Arrays.equals(sarr, parr)) {
        resultList.add(i-plen);
      }
    }
    return resultList;
  }

}
