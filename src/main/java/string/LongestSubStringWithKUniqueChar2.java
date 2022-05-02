package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueChar2 {

  public static void main(String[] args) {
    String str = "aabcbcdbca";
    String str1 = "aabacbebebe";
    int k = 2;
    int k1 = 3;
    System.out.println(longSubStringwithKUnique(str1, k1));
    System.out.println(longSubStringwithKUnique(str, k));
  }

  private static int longSubStringwithKUnique(String str, int k) {
    int ans = 0, i = -1, j = -1, left = 0, right = 0;
    Map<Character, Integer> map = new HashMap<>();

    while (true) {
      boolean f1 = false, f2 = false;
      while (i < str.length() - 1) {
        f1 = true;
        i++;
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        if (map.size() < k) {
          continue;
        } else if (map.size() == k) {
          int len = i - j;
          if (len > ans) {
            left = i;
            right = j;
            ans = len;
          }
        } else {
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

        if (map.size() > k) {
          continue;
        } else if (map.size() == k) {
          int len = i - j;
          if (len > ans) {
            left = i;
            right = j;
            ans = len;
          }
          break;
        }
      }
      if (!f1 && !f2) {
        break;
      }
    }
    System.out.println(str.substring(right+1,left+1));
    return ans;
  }
}
