package AAAMSPrepare.misc;

public class ReversWords {

  public static void main(String[] args) {
    String str = "Let's take Leetcode contest";
    System.out.println(reverseWords(str));
  }

  private static String reverseWords(String str) {
    char[] chArr = str.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      if (chArr[i] != ' ') {
        int j = i + 1;
        while (j < str.length() && chArr[j] != ' ') {
          j++;
        }
        reverse(chArr, i, j-1);
        i = j;
      }
    }
    return String.valueOf(chArr);
  }


  private static void reverse(char[] chArr, int i, int j) {
    while (i < j) {
      char tempCh = chArr[i];
      chArr[i] = chArr[j];
      chArr[j] = tempCh;
      i++;
      j--;
    }
  }
}
