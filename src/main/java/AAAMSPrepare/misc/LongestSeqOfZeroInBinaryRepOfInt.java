package AAAMSPrepare.misc;

public class LongestSeqOfZeroInBinaryRepOfInt {

  public static void main(String[] args) {
    int num = 9;
    System.out.println("Dec to Bin :");
    decToBin(num);
    System.out.println(maxZero(num));
  }

  private static int maxZero(int num) {
    int maxlen = 0;
    int cnt = 0;
    while (num != 0) {
      if ((num & 1) == 0) {
        cnt++;
        num >>= 1;
        maxlen = Math.max(maxlen, cnt);
      } else {
        maxlen = Math.max(maxlen, cnt);
        cnt = 0;
        num >>= 1;
      }
    }

    return maxlen;
  }

  public static void decToBin(int num) {
    int[] binary = new int[40];
    int index = 0;
    while (num > 0) {
      binary[index++] = num % 2;
      num = num / 2;
    }
    for (int i = index - 1; i >= 0; i--) {
      System.out.println(binary[i]);
    }
    System.out.println();
  }
}
