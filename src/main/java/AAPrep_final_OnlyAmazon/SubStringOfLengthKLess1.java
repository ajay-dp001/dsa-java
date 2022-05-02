package AAPrep_final_OnlyAmazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubStringOfLengthKLess1 {

  public static void main(String[] args) {
    String str = "awaglk";
    int k = 4;
    System.out.println(solve(str, k));
  }

  static List<String> solve(String s, int k) {

    int low = 0;
    int high = 0;
    Map<Character, Integer> map = new HashMap<>();
    Set<String> ans = new HashSet<>();
    while (high < s.length()) {
      char sh = s.charAt(high);
      map.put(sh, map.getOrDefault(sh, 0) + 1);

      if (high - low + 1 == k) {

        if (map.size() == k - 1) { // find k-1 distinct chars in k window size {
          ans.add(s.substring(low, high + 1));
        }
        map.put(s.charAt(low), map.getOrDefault(s.charAt(low), 0) - 1);

        if (map.get(s.charAt(low)) <= 0) {
          map.remove(s.charAt(low));
        }
        low++;
      }
      high++;
    }
    return new ArrayList<>(ans);
  }

}
