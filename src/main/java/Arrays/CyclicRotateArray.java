package Arrays;

public class CyclicRotateArray {

  static int len;

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5,6,7};
    int key = 3;
    len = arr.length;
    rotate(arr, key);
    rotateFast(arr, key);
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void rotate(int arr[], int key) {
    int cnt = 0;
    while (cnt < key) {
      int tmp = arr[len - 1];
      for (int i = (len - 1); i >= 1; i--) {
        arr[i] = arr[i - 1];
      }
      arr[0] = tmp;
      cnt++;
    }
  }

  public static void rotateFast(int arr[], int key) {
    key = key % arr.length;
    reverse(arr, 0, arr.length - 1);
    reverse(arr, key, arr.length - 1);
    reverse(arr, 0, key - 1);

  }

  private static void reverse(int[] arr, int start, int end) {
    int temp;
    while (start < end) {
      temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
}
