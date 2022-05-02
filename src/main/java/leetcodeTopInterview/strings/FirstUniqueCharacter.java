package leetcodeTopInterview.strings;

import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.units.qual.C;

public class FirstUniqueCharacter {

  public static void main(String[] args) {
    String str1 = "aabb";
    String str2 = "leetcode";
    String str3 = "loveleetcode";

    System.out.println("Result: " + firstUniqChar(str1));
    System.out.println("Result: " + firstUniqChar(str2));
    System.out.println("Result: " + firstUniqChar(str3));
  }

  private static int firstUniqCharEff(String str) {
    int min = Integer.MAX_VALUE;
    for (char ch = 'a'; ch < 'z'; ch++) {
      int idx = str.indexOf(ch);
      if (idx != -1 && idx == str.lastIndexOf(ch)) {
        min = Math.min(min, idx);
      }
    }
    if (min != Integer.MAX_VALUE) {
      return min;
    }
    return -1;
  }

  private static int firstUniqChar(String str) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (!map.containsKey(ch)) {
        map.put(ch, i);
      } else {
        map.put(ch, -1);
      }
    }

    int min = Integer.MAX_VALUE;
    for (char ch : map.keySet()) {
      int idx = map.get(ch);
      if (idx > -1 && idx < min) {
        min = idx;
      }
    }
    return min != Integer.MAX_VALUE ? min : -1;
  }
}
