package AAPrep_final_OnlyAmazon;

import java.util.Arrays;

public class SortAlphaNumericString {

  public static void main(String[] args) {
    String str1 = "geeks12for32geeks";
    System.out.println(sort(str1));
    String str2 = "eeeef12ggk23korss";
    System.out.println(sort(str2));
    String str3 = "d4c3b2a1";
    System.out.println(sort(str3));
    String str4 = "a1b2c3d4";
    System.out.println(sort(str4));


  }

  private static String sort(String str) {
    char[] ch = new char[str.length()];
    ch = str.toCharArray();
    Arrays.sort(ch);

    int alb_cnt = 0, num_cnt = 0;
    while (ch[alb_cnt] < 97) {
      alb_cnt++;
    }

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) < 97) {
        str = str.substring(0, i) + ch[num_cnt++] + str.substring(i + 1);
      } else {
        str = str.substring(0, i) + ch[alb_cnt++] + str.substring(i + 1);
      }
    }
    return str;
  }

}
