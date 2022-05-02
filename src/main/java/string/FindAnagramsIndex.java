package string;

import java.util.ArrayList;
import java.util.List;

public class FindAnagramsIndex {

  public static void main(String[] args) {
    String str = "abab";
    String pattern = "ab";
    String str1 = "cbaebabacd";
    String pattern1 = "abc";
    List<Integer> result = findAnagrams(str1, pattern1);
    System.out.println(result);
  }

  public static List<Integer> findAnagrams(String s, String p) {
    int slen = s.length();
    int plen = p.length();

    List<Integer> result = new ArrayList<>();

    if (plen < 1 || slen < plen) {
      return result;
    }

    int[] sarr = new int[26];
    int[] parr = new int[26];

    int i = 0;

    while (i < plen) {
      sarr[s.charAt(i) - 'a']++;
      parr[p.charAt(i) - 'a']++;
      i++;
    }

    if (isAnagram(sarr, parr)) {
      result.add(0);
    }
    int cnt = 1;
    while (cnt + plen - 1 < slen) {
      sarr[s.charAt(cnt - 1) - 'a']--;
      sarr[s.charAt(cnt + plen - 1) - 'a']++;
      if (isAnagram(sarr, parr)) {
        result.add(cnt);
      }
      cnt++;
    }
    return result;
  }

  private static boolean isAnagram(int[] sarr, int[] parr) {
    for (int i = 0; i < 26; i++) {
      if (sarr[i] != parr[i]) {
        return false;
      }
    }
    return true;
  }

}
