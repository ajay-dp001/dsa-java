package stringMS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.youtube.com/watch?v=Ky_da5Nckx4
public class SmallestSubStringOfUniqueChar {

  public static void main(String[] args) {
    String str = "bbacacdcbbcaadcdca";
    int k = 4;
    System.out.println(smallestSubArrayOfUnique(str));
  }

  private static int smallestSubArrayOfUnique(String str) {
    Set<Character> set = new HashSet<>();
    Map<Character, Integer> map = new HashMap<>();

    for (Character ch : str.toCharArray()) {
      set.add(ch);
    }

    int i = -1, j = -1, len = str.length();
    while (true) {
      boolean f1 = false, f2 = false;
      while (i < str.length() - 1 && map.size() < set.size()) {
        f1 = true;
        i++;
        char ch = str.charAt(i);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
      }

      while (j < i && map.size() == set.size()) {
        f2 = true;
        int plen = i - j;
        if (plen < len) {
          len = plen;
        }
        j++;
        char ch = str.charAt(j);
        if (map.get(ch) == 1) {
          map.remove(ch);
        } else {
          map.put(ch, map.get(ch) - 1);
        }
      }

      if (!f1 && !f2) {
        break;
      }
    }
    return len;
  }

}
