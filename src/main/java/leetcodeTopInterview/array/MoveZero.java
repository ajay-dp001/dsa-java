package leetcodeTopInterview.array;

public class MoveZero {

  public static void main(String[] args) {
    int[] ar = {0};
    int[] arr = {0, 1, 0, 3, 12};
    moveZeroToEndEff(arr);
   // moveZeroToEnd(arr);
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  private static void moveZeroToEndEff(int[] arr) {
    int idx = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        arr[idx++] = arr[i];
      }
    }
    for (int i = idx; i < arr.length; i++) {
      arr[i] = 0;
    }
  }

  private static void moveZeroToEnd(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] == 0) {
        int temp = i, j = i - 1;
        while (arr[i] == 0 && i < arr.length - 1) {
          i++;
        }
        arr[j] = arr[i];
        arr[i] = 0;
        i = temp;
      }
    }
  }
}
