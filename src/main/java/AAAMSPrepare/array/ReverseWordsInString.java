package AAAMSPrepare.array;

public class ReverseWordsInString {

  public static void main(String[] args) {
    String str1 = "i like this program very much";
    String str2 = "Be a game changer the world is already full of players";
    String str3 = "getting good at coding needs a lot of practice";


    String str11 = "i like this program";
    String[] strArr = reversWordsInString(str11);
    str3 = String.join(" ", strArr);
    System.out.println(str3);
  }

  private static String[] reversWordsInString(String str) {
    String[] strArr = str.split("\\s");
    int len = strArr.length;

    if (len % 2 == 0) {
      int mid = len / 2;
      while (mid <= len - 1) {
        String temp = strArr[len - mid - 1];
        strArr[len - mid - 1] = strArr[mid];
        strArr[mid] = temp;
        mid++;
      }
    } else {
      int mid = (len / 2) + 1;
      while (mid <= len - 1) {
        String temp = strArr[len - mid - 1];
        strArr[len - mid - 1] = strArr[mid];
        strArr[mid] = temp;
        mid++;
      }
    }
    return strArr;
  }

}
