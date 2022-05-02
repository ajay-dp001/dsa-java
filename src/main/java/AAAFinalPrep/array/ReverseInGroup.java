package AAAFinalPrep.array;

public class ReverseInGroup {

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
    int k = 3;

    int n = arr.length;
    reverse(arr, n, k);

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void reverse(int[] arr, int len, int k) {
    for (int i = 0; i < len; i += k) {
      int left = i;
      int right = Math.min(i + k - 1, len - 1);
      while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
      }
    }
  }

}
