package AAAMSPrepare.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RearrangeToFormPalindrome {

  public static void main(String[] args) {
    String str = "mdaam";
    System.out.println(getPalindrome(str));
    String str1 = "mdaamw";
    System.out.println(canFormPalindrome(str1));
  }

  private static String getPalindrome(String str) {
    Map<Character, Integer> map = new HashMap<>();

    for (char ch : str.toCharArray()) {
      if (map.containsKey(ch)) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
      } else {
        map.put(ch, 1);
      }
    }

    int oddCnt = 0;
    char oddChar = 0;

    for (Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue() % 2 != 0) {
        oddCnt++;
        oddChar = entry.getKey();
      }
    }

    if (oddCnt > 1 || oddCnt == 1 && str.length() % 2 == 0) {
      return "No Palindrome";
    }

    String firstHalf = "", secondHalf = "";

    for (Entry<Character, Integer> entry : map.entrySet()) {
      String ss = "";
      for (int i = 0; i < entry.getValue() / 2; i++) {
        ss += entry.getKey();
      }
      firstHalf = firstHalf + ss;
      secondHalf = ss + secondHalf;
    }
    return (oddCnt == 1) ? (firstHalf + oddChar + secondHalf) : (firstHalf + secondHalf);
  }

  private static boolean canFormPalindrome(String str) {
    int[] sArr = new int[26];
    for (char ch : str.toCharArray()) {
      sArr[ch - 'a']++;
    }
    int odd = 0;
    for (int i : sArr) {
      if ((i & 1) == 1) {
        odd++;
      }
      if (odd > 1) {
        return false;
      }
    }
    return true;
  }

  private static void countPalindrome(int min, int max) {
    for (int i = max; i <= max; i++) {
      if (isPalindrome(i)) {
        System.out.print(i + " ");
      }
    }
  }

  private static boolean isPalindrome(int num) {
    int rev = 0;
    while (num != 0) {
      int rem = num % 10;
      rev = rev * 10 + rem;
      num = num / 10;
    }
    return rev == num;
  }
}
