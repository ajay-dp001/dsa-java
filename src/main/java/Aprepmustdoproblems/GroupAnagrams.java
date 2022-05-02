package Aprepmustdoproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

public class GroupAnagrams {

  public static void main(String[] args) {
    String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> res = groupAnagramsPep(str);
    for (List<String> list : res) {
      System.out.println(list);
    }

    List<List<String>> list = groupAnagrams(str);
    for (List<String> strs : list) {
      for (String s : strs) {
        System.out.print(s + " ");
      }
      System.out.println();
    }
  }

  private static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      char[] chArr = str.toCharArray();
      Arrays.sort(chArr);

      String sorted = String.valueOf(chArr);

      if (!map.containsKey(sorted)) {
        map.put(sorted, new ArrayList<>());
      }
      map.get(sorted).add(str);
    }

    return new ArrayList<>(map.values());
  }

  private static List<List<String>> groupAnagramsPep(String[] strArr) {
    Map<Map<Character, Integer>, List<String>> bigMap = new HashMap<>();

    for (String str : strArr) {
      Map<Character, Integer> freqMap = new HashMap<>();
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
      }

      if (!bigMap.containsKey(freqMap)) {
        List<String> list = new ArrayList<>();
        list.add(str);
        bigMap.put(freqMap, list);
      } else {
        List<String> list = bigMap.get(freqMap);
        list.add(str);
      }
    }

    List<List<String>> result = new ArrayList<>();
    for (List<String> val : bigMap.values()) {
      result.add(val);
    }
    return result;
  }

}
