package Aprepmustdoproblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChar {

  public static void main(String[] args) {
    String str = "awwdew";
    System.out.println("Longest SubString without repeating : " + longestSubstringWithOutRepeating(str));
  }

  private static int longestSubstringWithOutRepeating(String str) {
    int i = -1, j = -1, ans = 0;
    Map<Character, Integer> map = new HashMap<>();

    while (true) {
      boolean f1 = false, f2 = false;

      while (i < str.length() - 1) {
        f1 = true;
        i++;
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        if (map.get(ch) == 2) {
          break;
        } else {
          int len = i - j;
          if (len > ans) {
            ans = len;
          }
        }
      }

      while (j < i && i< str.length() - 1) {
        f2 = true;
        j++;
        char ch = str.charAt(j);
        map.put(ch, map.get(ch) - 1);
        if (map.get(ch) == 1) {
          break;
        }
      }

      if (!f1 && !f2) {
        break;
      }

    }
    return ans;
  }

}
