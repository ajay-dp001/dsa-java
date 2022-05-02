import java.util.List;
import java.util.Arrays;

public class Sol1 {

  private static int maxLen = Integer.MIN_VALUE;
  private static int maxlen = -1;

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
          maxLen = Math.max(maxLen, ans.split("\\s").length);
          return;
        }
        wordBreakUtil(n - i, s.substring(i, n), dict, ans + prefix + " ");
      }
    }
  }

  // main function
  public static void main(String args[]) {
    String str1 = "iloveicecreamandmango"; // for first test case
    String str2 = "ilovesamsungmobile";     // for second test case
    int n1 = str1.length();                 // length of first string
    int n2 = str2.length();                 // length of second string

    // List of strings in dictionary
    List<String> dict = Arrays.asList("mobile", "samsung", "sam", "sung",
        "man", "mango", "icecream", "and",
        "go", "i", "love", "ice", "cream");
    System.out.println("First Test:");

    // call to the method
    wordBreak(n1, dict, str1);
    System.out.println(maxLen);
    System.out.println("\nSecond Test:");

    // call to the method
    wordBreak(n2, dict, str2);


    breakWord(n1, str1, dict);
  }


  private static void breakWord(int strlen, String str, List<String> dict){
    breakWordUtil(strlen, str, dict, "");
  }

  private static void breakWordUtil(int strLen, String str, List<String> dict, String ansStr){
    for(int i=1; i<=strLen; i++){
      String prefix= str.substring(0, i);
      if(dict.contains(prefix)){
        if(i==strLen){
          ansStr+=prefix;
          maxlen = Math.max(maxlen, ansStr.split("\\s").length);
        }
      }
    }
  }
}