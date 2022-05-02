package AAPrep_final_OnlyAmazon;

public class BinarySearch {

  public static void main(String[] args) {
    int num = 10;
    int arr[] = {2, 3, 4, 10, 40};
    int result = binarySearch(arr, 0, arr.length, num);
    if (result != -1) {
      System.out.println("Num exist at location :" + result);
    } else {
      System.out.println("Num dosen't exist");
    }
  }

  private static int binarySearch(int[] arr, int left, int right, int x) {
    if (left <= right) {
      int mid = left + (right - left) / 2;

      if (arr[mid] == x) {
        return mid;
      }

      if (arr[mid] > x) {
        return binarySearch(arr, left, mid - 1, x);
      }
      return binarySearch(arr, mid + 1, right, x);
    }
    return -1;
  }

}
