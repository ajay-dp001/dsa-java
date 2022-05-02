package Arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating {

  public static void main(String[] args) {
    int arr[] = {9, 4, 9, 6, 7, 5, 4};
    int n = arr.length;
    System.out.println(firstNonRepeating(arr, n));

    String str = "abacabad";
    int ln = str.length();
    System.out.println(firstNonRepeatingString(str, ln));

    String str1 = "abacabad";
    int ln1 = str.length();
    System.out.println(firstNonRepeatingOtherway(str1));
  }

  private static int firstNonRepeating(int[] arr, int len) {
    int ans = 0;
    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < len; i++) {
      if (map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i]) + 1);
      } else {
        map.put(arr[i], 1);
      }
    }

    for (int i = 0; i < len; i++) {
      if (map.get(arr[i]) == 1) {
        ans = arr[i];
        break;
      }
    }
    return ans;
  }

  private static char firstNonRepeatingString(String str, int len) {
    char ans = 0;
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < len; i++) {
      char ch = str.charAt(i);
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }

    for (int i = 0; i < len; i++) {
      char ch = str.charAt(i);
      if (map.get(ch) == 1) {
        ans = ch;
        break;
      }
    }
    return ans;
  }

  private static char firstNonRepeatingOtherway(String str) {
    int[] char_count = new int[26];
    for (char ch : str.toCharArray()) {
      char_count[ch - 'a']++;
    }
    for (char ch : str.toCharArray()) {
      if (char_count[ch - 'a'] == 1) {
        return ch;
      }
    }
    return 0;
  }
}
