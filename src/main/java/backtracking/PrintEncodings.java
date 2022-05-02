package backtracking;

public class PrintEncodings {

  public static void main(String[] args) {
    String str = "123";
    printEncodings(str, "");
  }

  public static void printEncodings(String str, String asf) {
    if (str.length() == 0) {
      System.out.println(asf);
      return;
    } else if (str.length() == 1) {
      char ch = str.charAt(0);
      if (ch == '0') {
        return;
      } else {
        int chVal = ch - '0';
        char code = (char) ('a' + chVal - 1);
        asf += code;
        System.out.println(asf);
      }
    } else {
      char ch = str.charAt(0);
      String rOfString = str.substring(1);
      if (ch == '0') {
        return;
      } else {
        int chVal = ch - '0';
        char code = (char) ('a' + chVal - 1);
        printEncodings(rOfString, asf + code);
      }

      String ch12 = str.substring(0, 2);
      String rOfString2 = str.substring(2);

      int ch12v = Integer.parseInt(ch12);
      if (ch12v <= 26) {
        char code = (char) ('a' + ch12v - 1);
        printEncodings(rOfString2, asf + code);
      }
    }
  }

}
