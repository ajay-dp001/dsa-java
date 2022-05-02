import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.geeksforgeeks.org/word-break-problem-dp-32/
//https://www.geeksforgeeks.org/word-break-problem-using-backtracking/
public class Solution {

  public static void main(String[] args) {
    String str = "baz";
    int k = 25;
    System.out.println(solution(str, k));
    String str1 = "azy";
    int k1 = -3;
    System.out.println(encrypt(str1, k1));
    System.out.println(encrypt(str, k));

    String[] s1 = {"green", "red", "green", "Maroon", "Black", "yellow", "orange", "BluE", "blue"};
    String[] s2 = {"red", "blue", "yellow",};
    String[] result = reverser(s1, s2);
    for (String res : result) {
      System.out.print(res + " ");
    }
    main1();
  }

  public static String solution(String S, int Y) {

    String result = "";
    for (int i = 0; i < S.length(); ++i) {
      int chVal = S.charAt(i);
      int initialVal = Y;

      if (chVal + Y > 122) {
        Y -= (122 - chVal);
        Y = Y % 26;
        result += (char) (96 + Y);
      } else {
        result += (char) (chVal + Y);
      }
      Y = initialVal;
    }
    return result;
  }

  static String manipulateString(String str, int k) {

    char[] str1 = str.toCharArray();

    // looping through each character of string
    for (int i = 0; i < str.length(); i++) {

      // storing integer ASCII value of
      // the character in 'asc'

      int asc = str1[i];

      // 'rem' contains coded value which
      // needs to be rounded to 26
      int rem = 0, m = 0;
      if (k > 0) {
        rem = asc + k;
        if (rem > 122) {
          rem = rem % 26;
        }
        str1[i] = (char) (rem);
      } else {
        rem = asc - k + 1;
        m = rem % 26;
        str1[i] = (char) (m + 'a');
      }

      // converting 'rem' character in range
      // 0-25 and storing in 'm'

      // printing character by adding ascii value of 'a'
      // so that it becomes in the desired range i.e. a-z

    }

    String str2 = String.valueOf(str1);
    return str2;
  }

  //https://stackoverflow.com/questions/57294167/how-to-process-negative-shifts-in-caesars-cipher-javascript
  public static StringBuffer encrypt(String text, int s) {
    StringBuffer result = new StringBuffer();
    if (s < 0) {
      s = 26 + (s % 26);
    }
    for (int i = 0; i < text.length(); i++) {
      if (Character.isUpperCase(text.charAt(i))) {
        char ch = (char) (((int) text.charAt(i) + s - 65) % 26 + 65);
        result.append(ch);
      } else {
        char ch = (char) (((int) text.charAt(i) + s - 97) % 26 + 97);
        result.append(ch);
      }
    }
    return result;
  }

  public static String[] reverser(String[] s1, String[] s2) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < s2.length; i++) {
      if (!map.containsKey(s2[i].toLowerCase())) {
        map.put(s2[i], i);
      }
    }

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < s1.length; i++) {
      if (map.containsKey(s1[i].toLowerCase())) {
        list.add(i);
      }
    }
    reverse(s1, list, 0, list.size() - 1);
    return s1;
  }

  private static void reverse(String[] arr, List<Integer> list, int left, int right) {
    while (left < right) {
      String temp = arr[list.get(left)];
      arr[list.get(left)] = arr[list.get(right)];
      arr[list.get(right)] = temp;
      left++;
      right--;
    }
  }

  public static boolean wordBreak(String s, List<String> dictionary) {

    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 0; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && dictionary.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public static void main1() {
    String[] dictionary = {"mobile", "samsung", "sam", "sung", "man",
        "mango", "icecream", "and", "go", "i",
        "like", "ice", "cream"};

    String[] dictionary1 = {"how", "when", "will", "you", "today", "a", "are"};
    String se = "howareyoutoday";

    List<String> dict = new ArrayList<>();
    for (String s : dictionary1) {
      dict.add(s);
    }

    wordBreak(se.length(), dict, se);

    if (wordBreak("ilikesamsung", dict)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    if (wordBreak("iiiiiiii", dict)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    if (wordBreak("", dict)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    if (wordBreak("samsungandmango", dict)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    if (wordBreak("ilikesamsung", dict)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    if (wordBreak("samsungandmangok", dict)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }


  static void wordBreak(int n, List<String> dict, String s) {
    String ans = "";
    wordBreakUtil(n, s, dict, ans);
  }

  static void wordBreakUtil(int n, String s, List<String> dict, String ans) {
    for (int i = 1; i <= n; i++) {

      // Extract substring from 0 to i in prefix
      String prefix = s.substring(0, i);

      // If dictionary contains this prefix, then
      // we check for remaining string. Otherwise
      // we ignore this prefix (there is no else for
      // this if) and try next
      if (dict.contains(prefix)) {
        // If no more elements are there, print it
        if (i == n) {

          // Add this element to previous prefix
          ans += prefix;
          System.out.println(ans);
          return;
        }
        wordBreakUtil(n - i, s.substring(i, n), dict, ans + prefix + " ");
      }
    }
  }

}
