package stringMS;

import java.util.Map;
import java.util.TreeMap;

public class CountPalindromicSubString {

  public static void main(String[] args) {
    String str = "abaab";
    printPalindrome(str);
    System.out.println(countPalindrom(str.toCharArray(), str.length()));
  }

  private static void printPalindrome(String str) {
    for (int i = 0; i < str.length(); i++) {
      for (int j = i + 1; j <= str.length(); j++) {
        String ps = str.substring(i, j);
        if (isPalindrome(ps)) {
          System.out.println(ps);
        }
      }
    }
  }

  private static boolean isPalindrome(String str) {
    int i = 0, j = str.length() - 1;
    while (i < j) {
      if (str.charAt(i) == str.charAt(j)) {
        i++;
        j--;
      } else {
        return false;
      }
    }
    return true;
  }

  static int longestPalSubstr(String str) {
    // get length of input String
    int n = str.length();

    // All subStrings of length 1
    // are palindromes
    int maxLength = 1, start = 0;

    // Nested loop to mark start and end index
    for (int i = 0; i < str.length(); i++) {
      for (int j = i; j < str.length(); j++) {
        int flag = 1;

        // Check palindrome
        for (int k = 0; k < (j - i + 1) / 2; k++) {
          if (str.charAt(i + k) != str.charAt(j - k)) {
            flag = 0;
          }
        }

        // Palindrome
        if (flag != 0 && (j - i + 1) > maxLength) {
          start = i;
          maxLength = j - i + 1;
        }
      }
    }

    System.out.print("Longest palindrome subString is: ");
    printSubStr(str, start, start + maxLength - 1);

    // return length of LPS
    return maxLength;
  }

  static void printSubStr(String str, int low, int high) {
    for (int i = low; i <= high; ++i) {
      System.out.print(str.charAt(i));
    }
  }

  // This function prints the
  // longest palindrome substring
  // (LPS) of str[]. It also
  // returns the length of the
  // longest palindrome
  //https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/?ref=lbp
  public static int longestPalSubstr1(String str) {
    int n = str.length(); // calculcharAting size of string
    if (n < 2) {
      return n; // if string is empty then size will be 0.
    }
    // if n==1 then, answer will be 1(single
    // character will always palindrome)

    int maxLength = 1, start = 0;
    int low, high;
    for (int i = 0; i < n; i++) {
      low = i - 1;
      high = i + 1;
      while (high < n && str.charAt(high) == str.charAt(
          i)) //increment 'high'
      {
        high++;
      }

      while (low >= 0 && str.charAt(low) == str.charAt(i)) // decrement 'low'
      {
        low--;
      }

      while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
        low--;
        high++;
      }

      int length = high - low - 1;
      if (maxLength < length) {
        maxLength = length;
        start = low + 1;
      }
    }
    System.out.print("Longest palindrome substring is: ");
    System.out.println(str.substring(start, start + maxLength));
    return maxLength;

  }

  private static int countPalindrom(char[] chArr, int len) {
    int[][] dp = new int[len][len];
    boolean[][] pString = new boolean[len][len];

    // palindrome of single length
    for (int i = 0; i < len; i++) {
      pString[i][i] = true;
    }

    // palindrome of length 2
    for (int i = 0; i < len - 1; i++) {
      if (chArr[i] == chArr[i + 1]) {
        pString[i][i + 1] = true;
        dp[i][i + 1] = 1;
      }
    }

    for (int diag = 2; diag < len; diag++) {
      for (int i = 0; i < len - diag; i++) {
        int j = diag + i;
        if (chArr[i] == chArr[j] && pString[i + 1][j - 1]) {
          pString[i][j] = true;
        }

        if (pString[i][j]) {
          dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1 - dp[i + 1][j - 1];
        } else {
          dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
        }
      }
    }
    return dp[0][len - 1];
  }

  public static int countPS(String str) {
    String temp = "";
    StringBuffer stf;
    int count = 0;
    // Iterate the loop twice
    for (int i = 0; i < str.length(); i++) {
      for (int j = i + 1; j <= str.length(); j++) {
        // Get each substring
        temp = str.substring(i, j);
        // If length is greater than or equal to two
        // Check for palindrome
        if (temp.length() >= 2) {
          // Use StringBuffer class to reverse the string
          stf = new StringBuffer(temp);
          stf.reverse();
          // Compare substring with reverse of substring
          if (stf.toString().compareTo(temp) == 0) {
            count++;
          }
        }
      }
    }
    return count;
  }

  // Function to print all distinct palindrome
  // sub-strings of s
  static void palindromeSubStrs(String s) {
    //map<string, int> m;
    TreeMap<String, Integer> m = new TreeMap<>();
    int n = s.length();

    // table for storing results (2 rows for odd-
    // and even-length palindromes
    int[][] R = new int[2][n + 1];

    // Find all sub-string palindromes from the
    // given input string insert 'guards' to
    // iterate easily over s
    s = "@" + s + "#";

    for (int j = 0; j <= 1; j++) {
      int rp = 0;   // length of 'palindrome radius'
      R[j][0] = 0;

      int i = 1;
      while (i <= n) {
        //  Attempt to expand palindrome centered
        // at i
        while (s.charAt(i - rp - 1) == s.charAt(i +
            j + rp)) {
          rp++;  // Incrementing the length of
        }
        // palindromic radius as and
        // when we find valid palindrome

        // Assigning the found palindromic length
        // to odd/even length array
        R[j][i] = rp;
        int k = 1;
        while ((R[j][i - k] != rp - k) && (k < rp)) {
          R[j][i + k] = Math.min(R[j][i - k],
              rp - k);
          k++;
        }
        rp = Math.max(rp - k, 0);
        i += k;
      }
    }

    // remove 'guards'
    s = s.substring(1, s.length() - 1);

    // Put all obtained palindromes in a hash map to
    // find only distinct palindromess
    m.put(s.substring(0, 1), 1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= 1; j++) {
        for (int rp = R[j][i]; rp > 0; rp--) {
          m.put(s.substring(i - rp - 1, i - rp - 1
              + 2 * rp + j), 1);
        }
      }
      m.put(s.substring(i, i + 1), 1);
    }

    // printing all distinct palindromes from
    // hash map
    System.out.println("Below are " + (m.size())
        + " palindrome sub-strings");

    for (Map.Entry<String, Integer> ii : m.entrySet()) {
      System.out.println(ii.getKey());
    }
  }
}
