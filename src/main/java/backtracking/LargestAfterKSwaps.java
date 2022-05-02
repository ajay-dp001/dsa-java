package backtracking;

public class LargestAfterKSwaps {

  private static class Result {

    static String result = "";
  }

  public static void main(String[] args) {
    String str = "129814999";
    int k = 4;
    Result.result = str;
    findMaximumNum(str.toCharArray(), k);
    System.out.println("Max Num is: " + Result.result);
  }

  private static void findMaximumNum(char[] chArr, int k) {
    if (k == 0) {
      return;
    }
    int len = chArr.length;
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        if (chArr[i] < chArr[j]) {
          char temp = chArr[i];
          chArr[i] = chArr[j];
          chArr[j] = temp;

          String str = new String(chArr);
          if (Result.result.compareTo(str) < 0) {
            Result.result = str;
          }
          findMaximumNum(chArr, k - 1);

          temp = chArr[i];
          chArr[i] = chArr[j];
          chArr[j] = temp;
        }
      }
    }
  }

}
