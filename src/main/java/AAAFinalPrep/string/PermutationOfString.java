package AAAFinalPrep.string;

public class PermutationOfString {

  public static void main(String[] args) {
    String str = "ABC";
    int len = str.length();
    permute(str, 0, len - 1);
    System.out.println();
    String result = "";
   // permuteNoDuplicate(str, result);
  }

  public static void permute(String str, int start, int end) {
    if (start == end) {
      System.out.println(str);
    } else {
      for (int i = start; i < end; i++) {
        str = swap(str, start, i);
        permute(str, start + 1, end);
        str = swap(str, start, i);
      }
    }
  }

  private static String swap(String str, int pos1, int pos2) {
    char[] chArr = str.toCharArray();
    char tempCh = chArr[pos1];
    chArr[pos1] = chArr[pos2];
    chArr[pos2] = tempCh;
    return String.valueOf(chArr);
  }


}
