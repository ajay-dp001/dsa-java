package string;

import java.util.HashMap;
import java.util.Map;

public class CountSubStringOfLenKWithKDistintChar1 {

  public static void main(String[] args) {
    int K = 3;
    String str = "aabcdabbcdc";
    System.out.println(countSubstrings(str, K));
  }

  private static int countSubstrings(String str, int k) {
    int ans = 0;
    int len = str.length();
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < k; i++) {
      map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
    }
    if (map.size() == k) {
      ans++;
    }

    for (int j = k; j < len; j++) {
      map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
      map.put(str.charAt(j - k), map.getOrDefault(str.charAt(j - k), 0) - 1);
      if (map.get(str.charAt(j - k)) == 0) {
        map.remove(str.charAt(j - k));
      }
      if (map.size() == k) {
        ans++;
      }
    }
    return ans;
  }

}
