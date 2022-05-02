package string;
//https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/523136/JavaC%2B%2BPython-Sliding-Window
// https://iq.opengenus.org/substrings-with-k-distinct-characters/#:~:text=The%20brute%20force%20method%20is,substrings%20are%20equal%20to%20k.

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import org.checkerframework.checker.units.qual.C;

public class CountSubStringWithKUniqueChars3 {

  public static void main(String[] args) {
    int k = 3;
    String str = "abcabdabbcfa";
    String str12 = "aabcbcdbca";

    System.out.println(subStringwithKUniqueChar(str12, k));
    System.out.println(countkDist(str12, k));

    //O(n) Solution based on transformation from leetcode 340
    //Exact(k) = At most(k) - At most(k - 1)
    System.out.println(countWithAtMostKUniqueChar(str12, k) - countWithAtMostKUniqueChar(str12, k - 1));
  }

  private static int countWithAtMostKUniqueChar(String str, int k) {
    if (k == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    int i = -1, j = -1, cnt = 0;
    while (true) {
      while (i < str.length() - 1) {
        i++;
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        if (map.size() <= k) {
          cnt += i - j;
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

        if (map.size() > k) {
          continue;
        } else {
          cnt += i - j;
          break;
        }
      }
    }
    return cnt;
  }

  static int countkDist(String str, int k) {
    int res = 0;
    int n = str.length();
    // To store count of characters from 'a' to 'z'
    int cnt[] = new int[26];

    // Consider all substrings beginning with str[i]
    for (int i = 0; i < n; i++) {
      int dist_count = 0;

      // Initializing count array with 0
      Arrays.fill(cnt, 0);

      // Consider all substrings between str[i..j]
      for (int j = i; j < n; j++) {
        // If this is a new character for this substring, increment dist_count.
        if (cnt[str.charAt(j) - 'a'] == 0) {
          dist_count++;
        }

        // Increment count of current character
        cnt[str.charAt(j) - 'a']++;

        // If distinct character count becomes k, then increment result.
        if (dist_count == k) {
          res++;
        }
      }
    }

    return res;
  }

  private static int subStringwithKUniqueChar(String str, int k) {
    if (k == 1) {
      return solForK1(str, k);
    }
    Map<Character, Integer> mapb = new HashMap<>();
    Map<Character, Integer> maps = new HashMap<>();

    int is = -1, ib = -1, r = -1, ans = 0;
    while (true) {
      boolean f1 = false, f2 = false, f3 = false;
      while (ib < str.length() - 1) {
        f1 = true;
        ib++;
        char ch = str.charAt(ib);
        mapb.put(ch, mapb.getOrDefault(ch, 0) + 1);
        if (mapb.size() == k + 1) {
          removeInMap(mapb, ch);
          ib--;
          break;
        }
      }

      while (is < ib) {
        f2 = true;
        is++;
        char ch = str.charAt(is);
        maps.put(ch, maps.getOrDefault(ch, 0) + 1);
        if (maps.size() == k) {
          removeInMap(maps, ch);
          is--;
          break;
        }
      }

      while (r < is) {
        f3 = true;
        if (mapb.size() == k && maps.size() == k - 1) {
          ans += ib - is;
        }
        r++;
        char ch = str.charAt(r);
        removeInMap(maps, ch);
        removeInMap(mapb, ch);

        if (maps.size() < k - 1 || mapb.size() < k) {
          break;
        }
      }

      if (!f1 && !f2 && !f3) {
        break;
      }
    }
    return ans;
  }

  private static int solForK1(String str, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int i = -1, j = -1, ans = 0;
    while (true) {
      boolean f1 = false, f2 = false;
      while (i < str.length() - 1) {
        f1 = true;
        i++;
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        if (map.size() == 2) {
          removeInMap(map, ch);
          i--;
          break;
        }
      }

      while (j < i) {
        f2 = true;
        if (map.size() == 1) {
          ans += i - j;
        }
        j++;
        char ch = str.charAt(j);
        removeInMap(map, ch);

        if (map.size() == 0) {
          break;
        }
      }
      if (!f1 && !f2) {
        break;
      }
    }
    return ans;
  }

  private static void removeInMap(Map<Character, Integer> map, char ch) {
    if (map.get(ch) == 1) {
      map.remove(ch);
    } else {
      map.put(ch, map.get(ch) - 1);
    }
  }
}
