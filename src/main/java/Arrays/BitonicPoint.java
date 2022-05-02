package Arrays;

public class BitonicPoint {

  public static void main(String[] args) {
    int arr[] = {6, 7, 8, 10, 11, 13, 9, 6, 5, 4, 2, 1};
    int n = arr.length;
    int index = binarySearch(arr, 13, n - 1);
    if (index != -1) {
      System.out.println(arr[index]);
    }
  }

  private static int binarySearch(int[] arr, int key, int len) {
    int left = 0, mid, right = len;
    while (left <= right) {
      mid = left + (right - left) / 2;

      if (arr[mid] == key) {
        return mid;
      }
      if (arr[mid] > key) {
        right = mid - 1;
      }
      if (arr[mid] < key) {
        left = mid + 1;
      }
    }
    return -1;
  }
}
