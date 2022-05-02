package AAAMSPrepare.codility;

public class MinSwapToMakeStringBalanced {

  public static void main(String[] args) {
    String str = "[]";
    String str1 = "][][";
    String str2 = "]]][[[";

    System.out.println(printMinSwaps(str2));
  }

  private static int printMinSwaps(String str) {
    int open = 0, balance = 0;
    for (char ch : str.toCharArray()) {
      if (ch == '[') {
        open++;
      } else {
        if (open == 0) {
          balance++;
        } else {
          open--;
        }
      }
    }
    return (balance + 1) / 2;
  }

}
