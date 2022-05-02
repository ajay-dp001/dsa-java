package AAAMSPrepare.misc;

import java.util.HashMap;
import java.util.Map;

public class FindInSortdAndRotaedArray {

  public static void main(String[] args) {
    int arr[] = {15, 16, 17, 18, 19, 1, 2, 3, 4, 5, 6, 7,};
    int len = arr.length;
    int key = 16;
    int sum = 24;
    System.out.println("Element Index :" + search(arr, 0, len - 1, key));

    int pivot = findPivot(arr, 0, len - 1);
    int[] result = pairsInSortedRotated(arr, len, sum);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  private static int findPivot(int[] arr, int low, int high) {
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] < arr[high]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  private static int[] pairsInSortedRotated(int[] arr, int len, int sum) {
    Map<Integer, Integer> map = new HashMap<>();

    int pivot = findPivot(arr, 0, len - 1);
    int i = pivot, j = pivot - 1;

    while (i <= len - 1) {
      int diff = sum - arr[i];
      if (map.containsKey(diff)) {
        return new int[]{i, map.get(diff)};
      } else {
        map.put(arr[i], i);
      }
      i++;
    }
    while (j >= 0) {
      int diff = sum - arr[j];
      if (map.containsKey(diff)) {
        return new int[]{j, map.get(diff)};
      } else {
        map.put(arr[i], j);
      }
      j--;
    }
    return new int[]{};
  }

  //O(NlogN) O(1)
  private static int search(int[] arr, int low, int high, int key) {
    if (low > high) {
      return -1;
    }
    int mid = low + (high - low) / 2;

    if (arr[mid] == key) {
      return mid;
    }

    if (arr[low] <= arr[mid]) {
      if (key >= arr[low] && key <= arr[mid]) {
        return search(arr, low, mid - 1, key);
      }
      return search(arr, mid + 1, high, key);
    }

    if (key >= arr[mid] && key <= arr[high]) {
      return search(arr, mid + 1, high, key);
    }
    return search(arr, low, mid - 1, key);
  }

}
