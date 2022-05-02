package stringMS;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueChar2 {

  public static void main(String[] args) {
    String str = "aabcbcdbca";
    int k = 2;
    System.out.println(longSubStringWithKUnique(str, k));
  }

  private static int longSubStringWithKUnique(String str, int k) {
    int len = str.length(), i = -1, j = -1, cnt = 0;
    Map<Character, Integer> map = new HashMap<>();

    while (true) {
      boolean f1 = false, f2 = false;
      while (i < len - 1) {
        f1 = true;
        i++;
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        if (map.size() == k) {
          int strLen = i - j;
          if (strLen > cnt) {
            cnt = strLen;
          }
        } else if (map.size() > k) {
          break;
        }
      }
      while (j < i) {
        f2 = true;
        j++;
        char ch = str.charAt(j);
        if (map.get(ch) == 1) {
          map.remove(ch);
        } else {
          map.put(ch, map.get(ch) - 1);
        }
        if (map.size() == k) {
          int strLen = i - j;
          if (strLen > cnt) {
            cnt = strLen;
          }
          break;
        }
      }
      if (!f1 && !f2) {
        break;
      }
    }
    return cnt;
  }

}
