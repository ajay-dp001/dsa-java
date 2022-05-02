package stringMS;

public class SubSequence {

  public static void main(String[] args) {
    String str = "abc";
    subSequences(str, "");
  }

  private static void subSequences(String str, String result) {
    if (str.length() < 1) {
      System.out.println(result);
      return;
    }

    char ch = str.charAt(0);
    String restOfString = str.substring(1);

    subSequences(restOfString, result);
    subSequences(restOfString, result + ch);
  }
}
