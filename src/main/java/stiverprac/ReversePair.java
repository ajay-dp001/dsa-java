package stiverprac;

public class ReversePair {

  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 3, 1};
    System.out.println("Reverse Pair :" + mergeSort(arr, 0, arr.length - 1));
  }

  private static int mergeSort(int[] arr, int lt, int rt) {
    int rc = 0;
    if (lt < rt) {
      int mid = lt + (rt - lt) / 2;
      rc += mergeSort(arr, lt, mid);
      rc += mergeSort(arr, mid+1, rt);
      rc += merge(arr, lt, mid, rt);
    }
    return rc;
  }

  private static int merge(int[] arr, int lt, int mid, int rt) {
    int cnt = 0;
    int x = mid + 1;
    for (int i = lt; i <= mid; i++) {
      while (x <= rt && arr[i] > (2 * arr[x])) {
        x++;
      }
      cnt += (x - (mid + 1));
    }

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

    int i = 0, j = 0;
    int k = lt;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k++] = L[i++];
      } else {
        arr[k++] = R[j++];
      }
    }

    while (i < n1) {
      arr[k++] = arr[i++];
    }
    while (j < n2) {
      arr[k++] = arr[j++];
    }
    return cnt;
  }

}
