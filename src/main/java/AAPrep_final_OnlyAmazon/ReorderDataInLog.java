package AAPrep_final_OnlyAmazon;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderDataInLog {

  public static void main(String[] args) {
    String[] log = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
    System.out.println("ReOrdered Log:" + Arrays.toString(reorderLogFiles(log)));
  }

  public static String[] reorderLogFiles(String[] log) {
    Comparator<String> cmp = new Comparator<String>() {
      @Override
      public int compare(String str1, String str2) {
        int s1Space = str1.indexOf(' ');
        int s2Space = str2.indexOf(' ');

        char s1FirstChar = str1.charAt(s1Space + 1);
        char s2FirstChar = str2.charAt(s2Space + 1);

        if (s1FirstChar <= '9') {
          if (s2FirstChar <= '9') {
            return 0;
          } else {
            return 1;
          }
        }

        if (s2FirstChar <= '9') {
          return -1;
        }
        int v = str1.substring(s1Space + 1).compareTo(str2.substring(s2Space + 1));
        if (v == 0) {
          return str1.substring(0, s1Space).compareTo(str2.substring(0, s2Space));
        }
        return v;
      }
    };
    Arrays.sort(log, cmp);
    return log;
  }

}
