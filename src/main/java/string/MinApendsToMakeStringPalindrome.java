package string;

public class MinApendsToMakeStringPalindrome {

  public static void main(String[] args) {
    String str = "abede";
    System.out.println("No of Apends are: " + noOfApends(str));
  }

  private static int noOfApends(String str) {
    if (isPalindrome(str.toCharArray())) {
      return 0;
    }
    return 1 + noOfApends(str.substring(1));
  }

  private static boolean isPalindrome(char[] charArray) {
    int len = charArray.length;
    if (len == 1) {
      return true;
    }
    int ptr1 = 0;
    int ptr2 = len - 1;
    while (ptr2 >= ptr1) {
      if (charArray[ptr1] != charArray[ptr2]) {
        return false;
      }
      ptr1++;
      ptr2--;
    }
    return true;
  }
}
