package AAAMSPrepare.misc;

public class RunLengthEncoding {

  public static void main(String[] args) {
    String str = "wwwwaaadexxxxxxywww";
    printRLE(str);
    System.out.println();
    System.out.println(printEncode(str.toCharArray()));
  }

  private static void printRLE(String str) {
    int len = str.length();
    int cnt = 1;
    int i = 1;

    for (i = 1; i < len; i++) {
      if (str.charAt(i) == str.charAt(i - 1)) {
        cnt++;
      } else {
        System.out.print(str.charAt(i - 1));
        System.out.print(cnt);
        cnt = 1;
      }
    }
    System.out.print(str.charAt(i - 1));
    System.out.print(cnt);
  }

  private static int printEncode(char[] chArr) {
    StringBuilder sb = new StringBuilder();
    int cnt = 1;
    for (int i = 1; i < chArr.length; i++) {
      if (chArr[i] == chArr[i - 1]) {
        cnt++;
      } else {
        sb.append(chArr[i-1]);
        sb.append(cnt);
        cnt = 1;
      }
    }

    sb.append(chArr[chArr.length - 1]);
    sb.append(cnt);
    System.out.println(sb);
    return sb.length();
  }

}
