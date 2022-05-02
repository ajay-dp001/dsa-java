package AAAMSPrepare.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateFromString {

  public static void main(String[] args) {
    String str = "geeksforgeeks";
    char[] chArr = str.toCharArray();
    int len = chArr.length;
    System.out.println("Remove Duplicate from Array " + removeDuplicateEff(chArr, len));
    System.out.println("Remove Duplicate from Array " + unique(str));
  }

  //On^2, O(1)
  private static String removeDuplicate(char[] chArr, int len) {
    int index = 0;
    for (int i = 0; i < len; i++) {
      int j = 0;
      for (j = 0; j < i; j++) {
        if (chArr[i] == chArr[j]) {
          break;
        }
      }
      if (j == i) {
        chArr[index++] = chArr[i];
      }
    }
    return String.valueOf(Arrays.copyOf(chArr, index));
  }

  //On, O(n)
  private static String removeDuplicateEff(char[] chArr, int len) {
    Map<Character, Integer> map = new HashMap<>();
    String str = "";
    for (int i = 0; i < len; i++) {
      if (!map.containsKey(chArr[i])) {
        str += chArr[i];
        map.put(chArr[i], 1);
      }
    }
    return str;
  }

  //On
  public static String unique(String s) {
    String str = "";
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if (str.indexOf(c) < 0) {
        str += c;
      }
    }
    return str;
  }

}
