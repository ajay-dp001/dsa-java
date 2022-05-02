package Arrays;

public class Count0OccuranceInLogNBinarySearch {

  public static void main(String[] args) {
    int arr[] = {2,2};
    int x = 3;
    int len = arr.length;
    int cnt = count(arr, x, len);
    System.out.println(x + " occurs " + cnt + " times");
    int result[] = anotherWay(arr, x, len);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  private static int[] anotherWay(int[] arr, int trgt, int len) {
    if (arr.length > 0) {
      int index = search(arr, trgt, 0, len-1); //Search for target
      if (index == -1) {  //if target not found return from here
        return new int[]{-1, -1};
      }

      int leftIndx = index;
      int lastKnownLeftIndex = index;
      while (leftIndx != -1) {
        lastKnownLeftIndex = leftIndx;
        leftIndx = search(arr, trgt, 0, leftIndx - 1);
      }

      int rightIndx = index;
      int lastKnownRightIndex = index;
      while (rightIndx != -1) {
        lastKnownRightIndex = rightIndx;
        rightIndx = search(arr, trgt, rightIndx + 1, len - 1);
      }
      return new int[]{lastKnownLeftIndex, lastKnownRightIndex};
    }
    return new int[1];
  }

  private static int search(int[] arr, int trgt, int left, int right) {
    if (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == trgt) {
        return mid;
      } else if (arr[mid] > trgt) {
        return search(arr, trgt, left, mid - 1);
      } else {
        return search(arr, trgt, mid + 1, right);
      }
    }
    return -1;
  }

  private static int count(int[] arr, int x, int len) {
    int first_idx = findFirst(arr, 0, len - 1, x);
    System.out.println(first_idx);
    if (first_idx == -1) {
      return 0;
    }
    int last_idx = findLast(arr, 0, len - 1, x, len - 1);
    System.out.println(last_idx);
    if (last_idx == -1) {
      return 0;
    }
    return last_idx - first_idx + 1;
  }

  private static int findFirst(int[] arr, int left, int right, int x) {
    if (left <= right) {
      int mid = left + (right - left) / 2;

      if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
        return mid;
      } else if (x > arr[mid]) {
        return findFirst(arr, mid + 1, right, x);
      } else {
        return findFirst(arr, left, mid - 1, x);
      }
    }
    return -1;
  }

  private static int findLast(int[] arr, int left, int right, int x, int len) {
    if (left <= right) {
      int mid = left + (right - left) / 2;

      if ((mid == len || x < arr[mid + 1]) && arr[mid] == x) {
        return mid;
      } else if (x < arr[mid]) {
        return findLast(arr, left, mid - 1, x, len);
      } else {
        return findLast(arr, mid + 1, right, x, len);
      }
    }
    return -1;
  }
}
