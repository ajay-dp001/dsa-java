package AAAMSPrepare.array;

public class ReverserStringWithOutAffectingSpecialChar {

  public static void main(String[] args) {
    String str1 = "a!!!b.c.d,e'f,ghi";
    String str = "Hay !Stop writing code in Java, use C#.";

    char[] charArray = str.toCharArray();

    System.out.println("Input string: " + str);
    reverse(charArray);
    String revStr = new String(charArray);
    System.out.println("Output string: " + revStr);
  }

  private static void reverse(char[] chArr) {
    int left = 0, right = chArr.length - 1;
    while (left < right) {
      if (!isAlphabet(chArr[left])) {
        left++;
      } else if (!Character.isAlphabetic(chArr[right])) {
        right--;
      } else {
        char temp = chArr[left];
        chArr[left] = chArr[right];
        chArr[right] = temp;
        left++;
        right--;
      }
    }
  }

  private static boolean isAlphabet(char ch) {
    return ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'));
  }

}
