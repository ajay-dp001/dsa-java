package AAAMSPrepare.arrayInterviewBit;

public class StringQuestions {

  static int cnt = 0;

  public static void main(String[] args) {
    String str = "abcd";
    printSubSequence(str, "");
    System.out.println();
    String str1 = "abccbc";
    countPalindromicSubString(str1);

   System.out.println("Longest Palindrome :" + longestPalindromicSubString(str1)); //Count
   System.out.println("Longest Palindrome :" + longestLenPalindromicSubString(str1)); //getString
   System.out.println("Longest Palindrome :" + findAlPalindromicSubString(str1)); //getAllString

    //Reverse String
    String revStr = "The  Sky  is    Blue";
    String revStrResult = revStringWords(revStr);
    System.out.println(revStrResult);


    //Min char to make String Palindromic
    String str112 = "ABC";
    String s = "BABABAA";
    String str2 = "AACECAAAA";
    System.out.println("Min Steps to make String Palindrome : " + minStepsToMakeStringPalindrome(s));
    System.out.println("Min Steps to make String Palindrome : " + deleteStrategy(s));
  }

  private static int deleteStrategy(String str) {
    int cnt = 0;
    while (str.length() > 0) {
      if (isPalindrome(str)) {
        break;
      } else {
        cnt++;
        str = str.substring(0, str.length() - 1);
      }
    }
    return cnt;
  }

  private static boolean isPalindrome(String str) {
    int len = str.length();
    for (int i = 0, j = len - 1; i <= j; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  private static int minStepsToMakeStringPalindrome(String str) {
    StringBuilder strB = new StringBuilder(str);
    strB = strB.reverse();

    String strNew = str + "$" + strB;

    int[] lps = new int[strNew.length()];
    computeLps(strNew, lps);

    return (str.length() - lps[strNew.length() - 1]);
  }

  private static void computeLps(String str, int[] arr) {
    int i = 0, j = 1, len = str.length();
    while (j < len) {
      if (str.charAt(i) == str.charAt(j)) {
        i++;
        arr[j] = i;
        j++;
      } else {
        if (i != 0) {
          i = arr[i - 1];
        } else {
          arr[j] = 0;
          j++;
        }
      }
    }
  }

  private static String revStringWords(String str) {
    if (str == null) {
      return null;
    }

    char[] chArr = str.toCharArray();
    int len = chArr.length;

    //Reverse full String
    reverse(chArr, 0, len - 1);

    //Reverser each Word
    revWords(chArr, len);

    return cleanUpSpace(chArr, len);
  }

  private static String cleanUpSpace(char[] chArr, int len) {
    int i = 0, j = 0;
    while (j < len) {
      while (j < len && chArr[j] == ' ') {
        j++;
      }
      while (j < len && chArr[j] != ' ') {
        chArr[i++] = chArr[j++];
      }
      while (j < len && chArr[j] == ' ') {
        j++;
      }
      if (j < len) {
        chArr[i++] = ' ';
      }
    }
    return new String(chArr).substring(0, i);
  }

  private static void revWords(char[] chArr, int len) {
    int i = 0, j = 0;
    while (i < len) {
      while (i < j || i < len && chArr[i] == ' ') {
        i++;
      }
      while (j < i || j < len && chArr[j] != ' ') {
        j++;
      }
      reverse(chArr, i, j - 1);
    }
  }

  private static void reverse(char[] charArr, int i, int j) {
    while (i < j) {
      char temp = charArr[i];
      charArr[i++] = charArr[j];
      charArr[j--] = temp;
    }
  }

  private static int findAlPalindromicInSubString(String str, int left, int right) {
    int cnt = 0;
    while (left >= 0 && right < str.length()) {
      if (str.charAt(left) != str.charAt(right)) {
        break;
      }
      cnt++;
      System.out.println(str.substring(left, right + 1));
      left--;
      right++;
    }
    return cnt;
  }

  //On^2
  private static int findAlPalindromicSubString(String str) {
    int cnt = 0;
    for (int i = 0; i < str.length(); i++) {
      cnt += findAlPalindromicInSubString(str, i - 1, i + 1);
      cnt += findAlPalindromicInSubString(str, i, i + 1);
    }
    return cnt;
  }

  private static int expandFromMiddle(String str, int left, int right) {
    if (str == null || left > right) {
      return 0;
    }
    while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }

  private static String longestLenPalindromicSubString(String str) {
    if (str == null || str.length() < 1) {
      return "";
    }
    int left = 0, right = 0;
    for (int i = 0; i < str.length(); i++) {
      int len1 = expandFromMiddle(str, i, i);
      int len2 = expandFromMiddle(str, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > right - left) {
        left = i - ((len - 1) / 2);
        right = i + len / 2;
      }
    }
    return str.substring(left, right + 1);
  }

  private static int longestPalindromicSubString(String str) {
    boolean[][] dp = new boolean[str.length()][str.length()];
    int len = 0;

    for (int diag = 0; diag < str.length(); diag++) {

      for (int i = 0, j = diag; j < str.length(); i++, j++) {
        if (diag == 0) {
          dp[i][j] = true;
        } else if (diag == 1) {
          dp[i][j] = str.charAt(i) == str.charAt(j);
        } else {
          if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
            dp[i][j] = true;
          } else {
            dp[i][j] = false;
          }
        }
        if (dp[i][j]) {
          len = diag + 1;
        }
      }
    }
    return len;
  }

  //Count Palindromic SubString
  private static int countPalindromicSubString(String str) {
    boolean[][] dp = new boolean[str.length()][str.length()];
    int cnt = 0;
    for (int dig = 0; dig < str.length(); dig++) {
      for (int i = 0, j = dig; j < str.length(); i++, j++) {
        if (dig == 0) {
          dp[i][j] = true;
        } else if (dig == 1) {
          dp[i][j] = str.charAt(i) == str.charAt(j);
        } else {
          if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
            dp[i][j] = true;
          } else {
            dp[i][j] = false;
          }
        }
        if (dp[i][j]) {
          cnt++;
        }
      }
    }
    System.out.println(cnt);
    return cnt;
  }

  private static void printSubSequence(String str, String ans) {
    if (str.length() == 0) {
      cnt++;
      System.out.println(ans + " " + cnt);
      return;
    }
    char ch = str.charAt(0);
    String restOfString = str.substring(1);

    printSubSequence(restOfString, ans + "");
    printSubSequence(restOfString, ans + ch);
  }

  //Count Palindromic SubSequence
  private static int countPalindromicSubSubSequence(String str) {
    int[][] dp = new int[str.length()][str.length()];

    for (int dig = 0; dig < str.length(); dig++) {

      for (int i = 0, j = dig; j < str.length(); i++, j++) {
        if (dig == 0) {
          dp[i][j] = 1;
        } else if (dig == 1) {
          dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
        } else {
          if (str.charAt(i) == str.charAt(j)) {
            dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1;
          } else {
            dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
          }
        }
      }
    }
    System.out.println(dp[0][str.length() - 1]);
    return dp[0][str.length() - 1];
  }
}