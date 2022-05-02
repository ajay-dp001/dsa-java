package Aprepmustdoproblems;

public class ReverseWordsInString {

  public static void main(String[] args) {
    String str = "The Sky is Blue";
    int len = str.length();
    String ans = reverse(str, len);
    System.out.println(ans);
  }

  private static String reverse(String str, int len) {
    String res = "";
    String curr = "";

    for (int i = len - 1; i >= 0; i--) {
      curr = "";
      while (i >= 0 && str.charAt(i) != ' ') {
        curr += str.charAt(i);
        i--;
      }
      if (curr.length() > 0) {
        res += (res.length() == 0 ? "" : " ") + curr;
      }
    }
    return res;
  }

}
