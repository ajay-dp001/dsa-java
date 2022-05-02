package string;

import java.lang.annotation.ElementType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MostFrequentWord {

  public static void main(String[] args) {
    String arr[] = {"geeks", "for", "geeks", "a", "portal", "to", "learn", "can", "be",
        "computer", "science", "zoom", "yup", "fire", "in", "be", "data", "geeks"};
    String sol = findWord(arr);
    System.out.println(sol);
  }

  private static String findWord(String[] str) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length; i++) {
      if (map.containsKey(str[i])) {
        map.put(str[i], map.get(str[i]) + 1);
      } else {
        map.put(str[i], 1);
      }
    }

    String key = "";
    int value = 0;

    for (Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > value) {
        value = entry.getValue();
        key = entry.getKey();
      }
    }

    return key;
  }

}
