package stiverprac;

import java.util.Arrays;

//https://www.youtube.com/watch?v=kQ1mJlwW-c0&list=RDCMUCJskGeByzRRSvmOyZOz61ig&start_radio=1
public class CountInversions {

  public static void main(String[] args) {
    int[] arr = {1, 9, 6, 4, 5};
    System.out.println("Inv Count :" + mergeSort(arr, 0, arr.length - 1));

    int[] arr1 = {1, 9, 6, 4, 5};
    int[] aux1 = Arrays.copyOf(arr1, arr1.length);
    System.out.println("Inv Count :" + mergeSort2ndMethod(arr1, aux1, 0, arr1.length - 1));

  }

  private static int mergeSort(int[] arr, int lt, int rt) {
    int cnt = 0;
    if (lt < rt) {
      int mid = lt + (rt - lt) / 2;
      cnt += mergeSort(arr, lt, mid);
      cnt += mergeSort(arr, mid + 1, rt);
      cnt += merge(arr, lt, mid, rt);
    }
    return cnt;
  }

  private static int merge(int[] arr, int lt, int mid, int rt) {
    int n1 = mid - lt + 1;
    int n2 = rt - mid;

    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; i++) {
      L[i] = arr[lt + i];
    }
    for (int j = 0; j < n2; j++) {
      R[j] = arr[mid + j + 1];
    }

    int i = 0, j = 0, swaps = 0;
    int k = lt;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k++] = L[i++];
      } else {
        arr[k++] = R[j++];
        swaps += (mid + 1) - (lt + i);
      }
    }

    while (i < n1) {
      arr[k++] = L[i++];
    }

    while (j < n2) {
      arr[k++] = R[j++];
    }
    return swaps;
  }

  private static int mergeSort2ndMethod(int[] arr, int[] aux, int low, int high) {
    // base case
    if (high <= low) {        // if run size <= 1
      return 0;
    }
    int mid = (low + ((high - low) >> 1));
    int invCnt = 0;
    invCnt += mergeSort2ndMethod(arr, aux, low, mid);
    invCnt += mergeSort2ndMethod(arr, aux, mid + 1, high);
    invCnt += merge2ndMethod(arr, aux, low, mid, high);

    return invCnt;
  }

  private static int merge2ndMethod(int[] arr, int[] aux, int low, int mid, int high) {
    int k = low, i = low, j = mid + 1;
    int invCount = 0;
    while (i <= mid && j <= high) {
      if (arr[i] <= arr[j]) {
        aux[k++] = arr[i++];
      } else {
        aux[k++] = arr[j++];
        invCount += (mid - i + 1);
      }
    }
    // copy remaining elements
    while (i <= mid) {
      aux[k++] = arr[i++];
    }
    // copy back to the original array to reflect sorted order
    for (i = low; i <= high; i++) {
      arr[i] = aux[i];
    }
    return invCount;
  }
}
