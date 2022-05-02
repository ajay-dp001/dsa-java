package AAAMSPrepare.array;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatingChar {

  static final int NO_OF_CHAR = 256;
  static char count[] = new char[NO_OF_CHAR];

  private static class CountIndex {
    int count, index;
    public CountIndex(int index) {
      this.count = 1;
      this.index = index;
    }

    public void incCount() {
      this.count++;
    }
  }

  private static Map<Character, CountIndex> map = new LinkedHashMap<>(NO_OF_CHAR);

  public static void main(String[] args) {
    String str = "geeksforgeeks";
    String str1 = "leetcode";

    int idx = fistNonRepeatingChar(str);
    int idx1 = firstNonRepeatingEff(str1);

    System.out.println("First Non Repating Char is : " + str.charAt(idx));

    if (idx1 != -1) {
      System.out.println("First Non Repating Char is : " + str1.charAt(idx1));
    } else {
      System.out.println("Not");
    }

  }

  private static int fistNonRepeatingChar(String str) {
    getCountArray(str);
    int idx = -1;
    for (int i = 0; i < str.length(); i++) {
      if (count[str.charAt(i)] == 1) {
        idx = i;
        break;
      }
    }
    return idx;
  }

  private static void getCountArray(String str) {
    for (int i = 0; i < str.length(); i++) {
      count[str.charAt(i)]++;
    }
  }

  private static void getCountArrayEff(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (map.containsKey(str.charAt(i))) {
        map.get(str.charAt(i)).incCount();
      } else {
        map.put(str.charAt(i), new CountIndex(i));
      }
    }
  }

  private static int firstNonRepeatingEff(String str) {
    getCountArrayEff(str);
    int result = -1;
    for (Entry<Character, CountIndex> entry : map.entrySet()) {
      int count = entry.getValue().count;
      int idx = entry.getValue().index;
      if (count == 1) {
        result = idx;
        break;
      }
    }
    return result;
  }

}
