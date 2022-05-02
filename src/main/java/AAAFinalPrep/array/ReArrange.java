package AAAFinalPrep.array;

import java.util.Arrays;

public class ReArrange {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6};
    int len = arr.length;
    rearrangeOn(arr, len);
    System.out.println(Arrays.toString(arr));
  }

  public static void rearrange(int[] arr, int len) {
    int start = 0, end = len - 1;
    boolean flag = false;
    int[] tempArr = new int[len];
    for (int i = 0; i < len; i++) {
      if (flag) {
        tempArr[i] = arr[start++];
      } else {
        tempArr[i] = arr[end--];
      }
      flag = !flag;
    }
    System.out.println(Arrays.toString(tempArr));
  }

  public static void rearrangeOn(int[] arr, int len) {
    int min_elem = arr[0];
    int max_elem = arr[len - 1];
    for (int i = 0; i < len; i++) {
      if (i % 2 == 0) {
        arr[i] = max_elem;
        max_elem -= 1;
      } else {
        arr[i] = min_elem;
        min_elem += 1;
      }
    }
  }
}
