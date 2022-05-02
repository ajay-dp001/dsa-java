package stringMS;

import java.util.Arrays;

public class LexicographicMinRotatedSequence {

  public static void main(String[] args) {
    System.out.println(minLexRotation("GEEKSFORGEEKS"));
    System.out.println(minLexRotation("GEEKSQUIZ"));
    System.out.println(minLexRotation("BCABDADAB"));

    String S = "DCACBCAA";
    int n = 8;
    printSmallestSequence(S, n);
  }

  private static String minLexRotation(String str) {
    int len = str.length();
    String[] arr = new String[len];

    String concat = str + str;
    for (int i = 0; i < len; i++) {
      arr[i] = concat.substring(i, i + len);
    }
    Arrays.sort(arr);
    return arr[0];
  }

  private static void printSmallestSequence(String str, int len) {
    char[] charr = str.toCharArray();
    int starting_idx = smallestSeq(charr, len);
    for (int i = 0; i < len; i++) {
      System.out.print(charr[(starting_idx + i) % len] + " ");
    }
  }

  private static int smallestSeq(char[] charr, int len) {
    int idx = 0;
    for (int i = 1; i < len; i++) {
      if (compareSeq(charr, idx, i, len)) {
        idx = i;
      }
    }
    return idx;
  }

  private static boolean compareSeq(char[] arr, int x, int y, int len) {
    for (int i = 0; i < len; i++) {
      if (arr[x] < arr[y]) {
        return false;
      } else if (arr[x] > arr[y]) {
        return true;
      }
      x = (x + 1) % len;
      y = (y + 1) % len;
    }
    return true;
  }


}
