package string;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=shsYUyF7pEs&list=TLGGryA673xcOjEzMTAxMjAyMg
// Less than equal to 2 unique.
public class CountOfSubStringWithAtMostKDistinctChar {

  public static void main(String[] args) {
    String str = "aabcbcdbca";
    int k = 3;
    String str1 = "aabacbebebe";
    int k1 = 3;
    System.out.println(cntWithAtMostK(str, k));
    System.out.println(cntWithAtMostK(str, k - 1));
    System.out.println(lengthOfLongestSubStringWithKDistinctChar(str1, k1));
    System.out.println(lenOfLongestSubStringForKDistinctChar(str1, k1));
  }

  private static int lenOfLongestSubStringForKDistinctChar(String str, int k) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    int[] count = new int[256];
    int num = 0, i = 0, res = 0;

    for (int j = 0; j < str.length(); j++) {
      if (count[str.charAt(j)]++ == 0) {
        num++;
      }
      if (num > k) {
        while (--count[str.charAt(i++)] > 0)
          ;
        num--;
      }
      res = Math.max(res, j - i + 1);
    }
    return res;
  }

  private static int lengthOfLongestSubStringWithKDistinctChar(String str, int k) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    int[] map = new int[256];

    int l = 0, r = 0, distinct = 0, max = 0, lidx = 0, ridx = 0;

    for (; r < str.length(); r++) {
      if (map[str.charAt(r)] == 0) {
        distinct++;
      }
      map[str.charAt(r)]++;

      while (distinct > k) {
        if (--map[str.charAt(l)] == 0) {
          distinct--;
        }
        l++;
      }
      if (max < (r - l + 1)) {
        lidx = l;
        ridx = r;
        max = r - l + 1;
      }
      System.out.println(str.substring(lidx , ridx + 1));
      //max = Math.max(max, r - l + 1);
    }
    return max;
  }

  private static int cntWithAtMostK(String str, int k) {
    int ans = 0, i = -1, j = -1;
    Map<Character, Integer> map = new HashMap<>();

    while (true) {
      while (i < str.length() - 1) {
        i++;
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        if (map.size() <= k) {
          ans += i - j;
        } else {
          break;
        }
      }

      if (i == str.length() - 1 && map.size() <= k) {
        break;
      }

      while (j < i) {
        j++;
        char ch = str.charAt(j);
        if (map.get(ch) == 1) {
          map.remove(ch);
        } else {
          map.put(ch, map.get(ch) - 1);
        }
        if (map.size() <= k) {
          ans += i - j;
          break;
        }
      }
    }
    return ans;
  }
}
