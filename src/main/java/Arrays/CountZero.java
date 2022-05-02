package Arrays;

public class CountZero {

  public static void main(String[] args) {
    int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0};
    int len = arr.length;
    int index = count0(arr, 0, len);
    System.out.println(len - index);
  }

  private static int count0(int[] arr, int left, int right) {
    if (left <= right) {
      int mid = left + (right - left) / 2;

      if ((mid == 0 || arr[mid - 1] == 1) && arr[mid] == 0) {
        return mid;
      }
      if (arr[mid] == 1) {
        return count0(arr, mid + 1, right);
      }
      return count0(arr, left, mid - 1);
    }
    return -1;
  }
}
