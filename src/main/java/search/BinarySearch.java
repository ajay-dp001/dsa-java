package search;

public class BinarySearch {

  public static void main(String[] args) {
    int arr[] = {-5};
    int arr1[] = {1, 3, 5, 6};
    int arr2[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    int n = arr.length;
    int key = -5;
    int key1 = 0;
    System.out.println("Index of the element is : " + bSearch(arr, key));
    System.out.println("Index of the element is : " + bSearchnew(arr1, key1));
    // System.out.println("Index of the element is : " + pivotedBinarySearch(arr1, n, key));
  }

  private static int binarySearch(int[] arr, int left, int right, int key) {
    if (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == key) {
        return mid;
      }
      if (mid > left && arr[mid - 1] == key) {
        return (mid - 1);
      }
      if (mid < right && arr[mid + 1] == key) {
        return (mid + 1);
      }

      if (arr[mid] > key) {
        return binarySearch(arr, left, mid - 1, key);
      }
      return binarySearch(arr, mid + 1, right, key);
    }
    return -1;
  }

  private static int binarySearchPrac(int[] arr, int left, int right, int key) {
    if (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == key) {
        return mid;
      }
      if (mid > left && arr[mid - 1] == key) {
        return mid - 1;
      }
      if (mid < right && arr[mid + 1] == key) {
        return mid + 1;
      }
      if (arr[mid] > key) {
        return binarySearch(arr, left, mid - 1, key);
      }
      return binarySearch(arr, mid + 1, right, key);
    }
    return -1;
  }

  private static int bsearchPrac(int[] arr, int key) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == key) {
        return mid;
      }
      if (arr[mid] > key) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  private static int bSearch(int[] arr, int key) {
    int mid, left = 0, right = arr.length - 1;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (arr[mid] == key) {
        return mid;
      }
      if (key < arr[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }


  //Find Nearest location.
  private static int bSearchnew(int[] arr, int key) {
    int pivot, left = 0, right = arr.length - 1;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      if (arr[pivot] == key) {
        return pivot;
      }
      if (key < arr[pivot]) {
        if ((pivot - 1 > left) && key > arr[pivot - 1]) {
          return pivot;
        }
        if (pivot == left) {
          return left;
        }
        right = pivot - 1;
      } else {
        if ((pivot + 1 < right) && key < arr[pivot + 1]) {
          return (pivot + 1);
        }
        if (pivot == right) {
          return right + 1;
        }
        left = pivot + 1;
      }
    }
    return -1;
  }
}
