package sort;

import prac.MyUtil;

public class MergSort {

  private static void merge(int[] arr, int lt, int mid, int rt) {
    int n1 = mid - lt + 1;
    int n2 = rt - mid;

    int L[] = new int[n1];
    int R[] = new int[n2];

    for (int i = 0; i < n1; i++) {
      L[i] = arr[lt + i];
    }

    for (int j = 0; j < n2; j++) {
      R[j] = arr[mid + 1 + j];
    }

    int i = 0, j = 0;
    int k = lt;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  public static void sort(int arr[], int lt, int rt) {
    if (lt < rt) {
      int mid = lt + (rt - lt) / 2;
      sort(arr, lt, mid);
      sort(arr, mid + 1, rt);
      merge(arr, lt, mid, rt);
    }
  }

  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int len = arr.length;
    sort(arr, 0, len - 1);
    MyUtil.printArray(arr);
  }

}
