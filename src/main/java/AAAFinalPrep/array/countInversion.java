package AAAFinalPrep.array;

import java.util.Arrays;

public class countInversion {

  private static int count = 0;

  public static void main(String[] args) {
    int[] arr = {1, 9, 6, 4, 5};

    int[] tempArr = new int[arr.length];
    System.out.println("Inv Count :" + mergeSort(arr, tempArr, 0, arr.length - 1));

    int[] arr1 = {1, 9, 6, 4, 5};
    System.out.println("Inv Count :" + mergeSort(arr1, 0, arr1.length - 1));

    int[] sortedArr = mergeSortPepCoding(arr1, 0, arr.length - 1);
    System.out.println("Sorted Array :" + Arrays.toString(sortedArr));
    System.out.println("Inversion Count :" + count);
  }

  private static int mergeSort(int[] arr, int[] tempArr, int left, int right) {
    int invCnt = 0;
    if (left < right) {
      int mid = left + (right - left) / 2;
      invCnt += mergeSort(arr, tempArr, left, mid);
      invCnt += mergeSort(arr, tempArr, mid + 1, right);
      invCnt += mergeS(arr, tempArr, left, mid+1 , right);
    }
    return invCnt;
  }

  public static int mergeS(int[] arr, int[] tempArr, int left, int mid, int right) {
    int i = left, j = mid, k = left, inv_cnt = 0;

    while ((i <= (mid -1)) && (j <= right)) {
      if (arr[i] <= arr[j]) {
        tempArr[k++] = arr[i++];
      } else {
        tempArr[k++] = arr[j++];
        inv_cnt += (mid - i);
      }
    }

    while (i <= mid-1 ) {
      tempArr[k++] = arr[i++];
    }

    while (j <= right) {
      tempArr[k++] = arr[j++];
    }

    for (i = left; i <= right; i++) {
      arr[i] = tempArr[i];
    }
    return inv_cnt;
  }


  private static int[] mergeSortPepCoding(int[] arr, int left, int right) {
    if (left == right) {
      int[] resultArr = new int[1];
      resultArr[0] = arr[left];
      return resultArr;
    }

    int mid = left + (right - left) / 2;
    int[] leftArr = mergeSortPepCoding(arr, left, mid);
    int[] rightArr = mergeSortPepCoding(arr, mid + 1, right);
    return mergeArrays(leftArr, rightArr);
  }

  private static int[] mergeArrays(int[] leftArr, int[] rightArr) {
    int i = 0, j = 0, k = 0;

    int[] merged = new int[leftArr.length + rightArr.length];

    while (i < leftArr.length && j < rightArr.length) {

      if (leftArr[i] <= rightArr[j]) {
        merged[k++] = leftArr[i++];
      } else {
        merged[k++] = rightArr[j++];
        count += leftArr.length - i;
      }
    }

    while (i < leftArr.length) {
      merged[k++] = leftArr[i++];
    }
    while (j < rightArr.length) {
      merged[k++] = rightArr[j++];
    }
    return merged;
  }


  private static int mergeSort(int[] arr, int left, int right) {
    int cnt = 0;
    if (left < right) {
      int mid = left + (right - left) / 2;
      cnt += mergeSort(arr, left, mid);
      cnt += mergeSort(arr, mid + 1, right);
      cnt += merge(arr, left, mid, right);
    }
    return cnt;
  }

  private static int merge(int[] arr, int left, int mid, int right) {
    int l1 = mid - left + 1;
    int l2 = right - mid;

    int[] L = new int[l1];
    int[] R = new int[l2];

    for (int i = 0; i < l1; i++) {
      L[i] = arr[left + i];
    }

    for (int j = 0; j < l2; j++) {
      R[j] = arr[mid + j + 1];
    }

    int i = 0, j = 0, swaps = 0;
    int k = left;
    while (i < l1 && j < l2) {
      if (L[i] <= R[j]) {
        arr[k++] = L[i++];
      } else {
        arr[k++] = R[j++];
      }
    }
    while (i < l1) {
      arr[k++] = L[i++];
    }

    while (j < l2) {
      arr[k++] = L[j++];
    }
    return 0;
  }

}
