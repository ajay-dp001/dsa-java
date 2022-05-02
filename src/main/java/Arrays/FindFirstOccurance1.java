package Arrays;

public class FindFirstOccurance1 {

  public static void main(String[] args) {
    int arr[] = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
    int len = arr.length;
    int first_idx = findFirstOccurance(arr, len);
    System.out.println(first_idx);
  }

  private static int findFirstOccurance(int[] arr, int len) {
    int index = search(arr, 0, len - 1);
    int left_idx = index;
    int lastKnownLeftIdx = left_idx;
    while (left_idx != -1) {
      lastKnownLeftIdx = left_idx;
      left_idx = search(arr, 0, left_idx - 1);
    }
    return lastKnownLeftIdx;
  }

  private static int search(int[] arr, int left, int right) {
    if (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == 1) {
        return mid;
      } else if (arr[mid] > 1) {
        return search(arr, left, mid - 1);
      } else {
        return search(arr, mid + 1, right);
      }
    }
    return -1;
  }
}
