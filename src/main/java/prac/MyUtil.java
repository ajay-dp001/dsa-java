package prac;

public class MyUtil {

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void swap(int[] arr, int pos1, int pos2) {
    if (pos1 != pos2) {
      int temp = arr[pos1];
      arr[pos1] = arr[pos2];
      arr[pos2] = temp;
    }
  }

}
