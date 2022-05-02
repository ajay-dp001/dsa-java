package Arrays;

public class SearchinSortedRotated {

  private static int binarySearch(int arr[], int low, int high, int key) {
    if (high < low) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (key == arr[mid]) {
      return mid;
    }
    if (key > arr[mid]) {
      return binarySearch(arr, (mid + 1), high, key);
    }
    return binarySearch(arr, low, (mid - 1), key);
  }


  private static int findPivot(int[] arr, int low, int high) {
    if (high < low) {
      return -1;
    }
    if (high == low) {
      return low;
    }

    int mid = (low + high) / 2;
    if (mid < high && arr[mid] > arr[mid + 1]) {
      return mid;
    }
    if (mid > low && arr[mid] < arr[mid - 1]) {
      return (mid - 1);
    }
    if (arr[low] >= arr[mid]) {
      return findPivot(arr, low, mid - 1);
    }
    return findPivot(arr, mid + 1, high);
  }

  private static int pivotedBinarySearch(int[] arr, int key, int length) {
    int pivot = findPivot(arr, 0, length - 1);
    if (pivot == -1) {
      return binarySearch(arr, 0, length - 1, key);
    }

    if (arr[pivot] == key) {
      return pivot;
    }
    if (arr[0] <= key) {
      return binarySearch(arr, 0, pivot - 1, key);
    }
    return binarySearch(arr, pivot + 1, length - 1, key);
  }

  static int search(int[] nums, int target) {
    int lo = 0, hi = nums.length;

    while (lo < hi) {
      int mid = (lo + hi) / 2;

      double num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid]
          : target < nums[0] ? -Integer.MAX_VALUE : Integer.MAX_VALUE;

      if (num < target) {
        lo = mid + 1;
      } else if (num > target) {
        hi = mid;
      } else {
        return mid;
      }
    }

    return -1;
  }


  public static void main(String[] args) {
    int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    int key = 3;
    System.out.println(pivotedBinarySearch(arr, key, arr.length));
    System.out.println(search(arr, 3));
  }
}
