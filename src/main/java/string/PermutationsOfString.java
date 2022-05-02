package string;

public class PermutationsOfString {

  public static void main(String[] args) {
    String str = "ABA";
    int len = str.length();
    permute(str, 0, len - 1);

    System.out.println();

    String result = "";
    String str1 = "ABA";
    permuteN(str, result);
  }

  private static void permute(String str, int start, int end) {
    if (start == end) {
      System.out.println(str);
    } else {
      for (int i = start; i <= end; i++) {
        str = swap(str, start, i);
        permute(str, start + 1, end);
        str = swap(str, start, i);
      }
    }
  }

  private static String swap(String str, int i, int j) {
    char[] ch = str.toCharArray();
    char temp = ch[i];
    ch[i] = ch[j];
    ch[j] = temp;
    return String.valueOf(ch);
  }

  private static void permuteN(String str, String result) {
    if (str.length() == 0) {
      System.out.println(result + " ");
    }else {
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        String left_subStr = str.substring(0, i);
        String right_subStr = str.substring(i + 1);
        String rest = left_subStr + right_subStr;
        permuteN(rest, result + ch);
      }
    }
  }
}
