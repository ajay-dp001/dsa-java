package leetcodeTopInterview.strings;

public class ImplementMyAtoi {

  public static void main(String[] args) {
    String str1 = "    -42";
    String str2 = "4193 with words";
    String str3 = "42";
    String str4 = "0032";
    String str5 = "+1";
    String str6 = " ";
    System.out.println("My atoi :" + myAtoi(str1));
    System.out.println("My atoi :" + myAtoi(str2));
    System.out.println("My atoi :" + myAtoi(str3));
    System.out.println("My atoi :" + myAtoi(str4));
    System.out.println("My atoi :" + myAtoi(str5));
    System.out.println("My atoi :" + myAtoi(str6));
  }

  private static int myAtoi(String str) {
    str = str.trim();
    int i = 0, base = 0, sign = 1;

    if (!str.isEmpty() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
      sign = str.charAt(i++) == '+' ? 1 : -1;
    }

    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
        return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      base = base * 10 + (str.charAt(i++) - '0');
    }
    return base * sign;
  }

}
