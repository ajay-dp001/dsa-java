package string;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=9Kc0eZBGL1U
public class LongestSubStringWithOutRepeatingChar {

  public static void main(String[] args) {
    String str = "abbacbcdbadbdddbcb";
    System.out.println(longestSubStringWithOutRepeating(str));
  }

  private static int longestSubStringWithOutRepeating(String str) {
    int ans = 0;
    int i = -1;
    int j = -1;

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

      //release
      while (j < i) {
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
