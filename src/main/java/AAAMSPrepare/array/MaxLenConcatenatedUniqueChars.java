package AAAMSPrepare.array;

import java.util.List;

public class MaxLenConcatenatedUniqueChars {

  public int maxLength(List<String> arr) {
    return helper(arr, 0, "");
  }

  private int helper(List<String> arr, int curIndex, String curStr) {
    if (curIndex == arr.size()) {
      return curStr.length();
    }

    int op1 = 0;

    if (isValid(curStr, arr.get(curIndex))) {
      op1 = helper(arr, curIndex + 1, curStr + arr.get(curIndex));
    }

    int op2 = helper(arr, curIndex + 1, curStr);

    return Math.max(op1, op2);
  }

  private boolean isValid(String str1, String str2) {
    int[] str1Chars = new int[26];
    for (char str1Char : str1.toCharArray()) {
      str1Chars[str1Char - 'a']++;
    }

    int[] str2Chars = new int[26];
    for (char str2Char : str2.toCharArray()) {
      if (str1Chars[str2Char - 'a'] > 0) {
        return false;
      }
      str2Chars[str2Char - 'a']++;
      if (str2Chars[str2Char - 'a'] > 1) {
        return false;
      }
    }

    return true;
  }
}
