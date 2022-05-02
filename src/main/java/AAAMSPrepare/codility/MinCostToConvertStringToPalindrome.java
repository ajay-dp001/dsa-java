package AAAMSPrepare.codility;

public class MinCostToConvertStringToPalindrome {

  public static void main(String[] args) {
    String str = "abcdef";
    System.out.println(cost(str));
  }

  private static int cost(String str) {
    int len = str.length();
    int res = 0;
    for (int i = 0, j = len - 1; i < j; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        res += Math.min(str.charAt(i), str.charAt(j)) - 'a' + 1;
      }
    }
    return res;
  }
}
