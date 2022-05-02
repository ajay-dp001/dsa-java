package AAAMSPrepare.codility;

public class MinAdjSwapToMakeStringPalindrome {

  public static void main(String[] args) {
    String str = "geeksfgeeks";
    int res = countSwaps(str.toCharArray());
    System.out.println(res);
  }

  public static int countSwaps(char[] chArr) {
    int len = chArr.length;
    int cnt = 0;

    for (int i = 0; i < len / 2; i++) {
      int left_ptr = i, right_ptr = len - left_ptr - 1;
      while (left_ptr < right_ptr) {
        if (chArr[left_ptr] == chArr[right_ptr]) {
          break;
        } else {
          right_ptr--;
        }
      }

      if (left_ptr == right_ptr) {
        return -1;
      }

      for (int j = right_ptr; j < len - left_ptr - 1; j++) {
        swap(chArr, j, j + 1);
        cnt++;
      }
    }
    return cnt;
  }

  private static void swap(char[] str, int pos1, int pos2) {
    char chTemp = str[pos1];
    str[pos1] = str[pos2];
    str[pos2] = chTemp;
  }

}
