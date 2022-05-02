package leetcodeTopInterview.strings;

public class ValidPalindrome {

  public static void main(String[] args) {
    String str1 = "0P";
    String str2 = "race a car";
    String str3 = "A man, a plan, a canal: Panama";
    System.out.println(" Palindrome :" + isPalindrome(str1));
    System.out.println(" Palindrome :" + isPalindrome(str2));
    System.out.println(" Palindrome :" + isPalindrome(str3));
  }

  private static boolean isPalindrome(String str) {
    int start = 0, end = str.length()-1;
    char[] chArr = str.toCharArray();

    while (start <= end) {
      while (start < end && !Character.isLetterOrDigit(chArr[start])) {
        start++;
      }
      while (start <= end && !Character.isLetterOrDigit(chArr[end])) {
        end--;
      }
      if (start <= end && Character.toLowerCase(chArr[start]) != Character.toLowerCase(chArr[end])) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

}
