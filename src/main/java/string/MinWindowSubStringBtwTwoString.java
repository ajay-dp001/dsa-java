package string;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubStringBtwTwoString {

  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    System.out.println(minWindowSubStrng(s, t));
  }

  private static String minWindowSubStrng(String s, String t) {
    int[] mapS = new int[256];
    int[] mapT = new int[256];

    for (char ch : t.toCharArray()) {
      mapT[ch]++;
    }

    String result = "";
    int right = 0, min = Integer.MAX_VALUE;

    for (int left = 0; left < s.length(); left++) {
      while (right < s.length() && !sContainsT(mapS, mapT)) {
        mapS[s.charAt(right++)]++;
      }
      if (sContainsT(mapS, mapT) && min > right - left + 1) {
        result = s.substring(left, right);
        min = right - left + 1;
      }
      mapS[s.charAt(left)]--;
    }
    return result;
  }

  private static boolean sContainsT(int[] mapS, int[] mapT) {
    for (int i = 0; i < mapT.length; i++) {// s should cover all characters in t
      if (mapT[i] > mapS[i]) {
        return false;
      }
    }
    return true;
  }

  private static String sol(String s1, String s2) {
    String ans = "";
    Map<Character, Integer> map2 = new HashMap<>();

    for (int i = 0; i < s2.length(); i++) {
      char ch = s2.charAt(i);
      map2.put(ch, map2.getOrDefault(ch, 0) + 1);
    }

    int matchCnt = 0;
    int desiredMatchCnt = s2.length();
    Map<Character, Integer> map1 = new HashMap<>();
    int i = -1, j = -1;

    while (true) {
      boolean f1 = false, f2 = false;
      while (i < s1.length() - 1 && matchCnt < desiredMatchCnt) {
        f1 = true;
        i++;
        char ch = s1.charAt(i);
        map1.put(ch, map1.getOrDefault(ch, 0) + 1);

        if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
          matchCnt++;
        }
      }

      while (j < i && matchCnt == desiredMatchCnt) {
        f2 = true;
        String potentialAns = s1.substring(j + 1, i + 1);
        if (ans.length() == 0 || potentialAns.length() < ans.length()) {
          ans = potentialAns;
        }
        j++;
        char ch = s1.charAt(j);
        if (map1.get(ch) == 1) {
          map1.remove(ch);
        } else {
          map1.put(ch, map1.get(ch) - 1);
        }

        if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
          matchCnt--;
        }
      }

      if (!f1 && !f2) {
        break;
      }
    }

    return ans;
  }
}
