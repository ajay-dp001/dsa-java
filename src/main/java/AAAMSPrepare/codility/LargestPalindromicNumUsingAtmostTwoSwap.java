package AAAMSPrepare.codility;

//https://www.geeksforgeeks.org/form-largest-palindromic-number-using-atmost-two-swaps/?ref=lbp
public class LargestPalindromicNumUsingAtmostTwoSwap {

  public static void main(String[] args) {
    char num[] = "4697557964".toCharArray();
    int n = num.length;
    //largestPalin(num, n);

    //Required largest palindromic number
    System.out.println("Largest Palindrome: " + String.valueOf(num));
  }

  private static void largestPalin(int num, int len) {
    if (len < 3) {
      return;
    }
    int mid = (len / 2) - 1;
  }
}
