package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSequence {

  public static void main(String[] args) {
    String str = "abc";
    List<String> res = printSubSeq(str);
    System.out.println(res);

    printSubSeqEff(str, "");

    System.out.println("*************************");

    int[] arr = {10, 20, 30, 40, 50};
    int target = 70;
    targetSumSubSet(arr, 0, "", 0, target);

    //**************************************************
    String str1 = "cab";
    printSubSeqInLexicographicOrder(str1);

    System.out.println();
    //*****************************************
    int[] arr3 = {10, 22, 9, 33, 21, 50, 41, 60, 50, 3};
    increasingSubSequence(arr3);
    System.out.println(longestIncreasingSubSequence(arr3));
  }

  private static void printSubSeqInLexicographicOrder(String str) {
    char[] chArr = str.toCharArray();
    Arrays.sort(chArr);
    permute(new String(chArr), str.length(), -1, "");
  }

  private static void permute(String str, int len, int idx, String ans) {
    if (idx == len) {
      return;
    }
    System.out.print(ans + " ");
    for (int i = idx + 1; i < len; i++) {
      ans += str.charAt(i);
      permute(str, len, i, ans);
      // Backtracking
      ans = ans.substring(0, ans.length() - 1);
    }
    return;
  }
  //https://www.youtube.com/watch?v=tRpkluGqINc
  private static void targetSumSubSet(int[] arr, int idx, String set, int sumOfSet, int target) {
    if (idx == arr.length) {
      if (sumOfSet == target) {
        System.out.println(set + " ");
      }
      return;
    }
    targetSumSubSet(arr, idx + 1, set, sumOfSet, target);
    targetSumSubSet(arr, idx + 1, set + arr[idx] + " ", sumOfSet + arr[idx], target);
  }

  private static void printSubSeqEff(String str, String ans) {
    if (str.length() == 0) {
      System.out.print(ans + " ");
      return;
    }
    char ch = str.charAt(0);
    String restOfStr = str.substring(1);

    printSubSeqEff(restOfStr, ans + "");
    printSubSeqEff(restOfStr, ans + ch);
  }

  public static List<String> printSubSeq(String str) {
    if (str.length() == 0) {
      List<String> resultList = new ArrayList<>();
      resultList.add("");
      return resultList;
    }

    char ch = str.charAt(0);//a
    String restOfString = str.substring(1); //bc
    List<String> recResult = printSubSeq(restOfString); // [--, -c, b-, bc]

    List<String> myResult = new ArrayList<>();
    for (String rstr : recResult) {
      myResult.add("" + rstr);
      myResult.add(ch + rstr);
    }

    return myResult;
  }

  static void printSubsets(char set[]) {
    int n = set.length;
    for (int i = 0; i < (1 << n); i++) {
      for (int j = 0; j < n; j++)
      // (1<<j) is a number with jth bit 1 so when we 'and' them with the subset number we get which numbers
      // are present in the subset and which are not.
      {
        if ((i & (1 << j)) > 0) {
          System.out.print(set[j] + " ");
        }
      }
    }
  }

  //https://www.youtube.com/watch?v=odrfUCS9sQk
  //O N^2
  private static void increasingSubSequence(int[] arr) {
    int overAllMax = 0;
    int[] dp = new int[arr.length];

    for (int i = 0; i < dp.length; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          if (dp[j] > max) {
            max = dp[j];
          }
        }
      }
      dp[i] = max + 1;
      if (dp[i] > overAllMax) {
        overAllMax = dp[i];
      }
    }
    System.out.println(overAllMax);
  }

  //NlogN
  private static int longestIncreasingSubSequence(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }
    int[] tail = new int[arr.length];
    tail[0] = arr[0];

    int len = 1;

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > tail[len - 1]) {
        tail[len++] = arr[i];
      } else {
        int idx = Arrays.binarySearch(tail, 0, len - 1, arr[i]);
        if (idx < 0) {
          idx = -1 * idx - 1;
        }
        tail[idx] = arr[i];
      }
    }
    return len;
  }

}
