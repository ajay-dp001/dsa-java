package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeTwoUnSortedArray {

  public static void main(String[] args) {
    int a[] = {10, 5, 15};
    int b[] = {20, 3, 2, 12};

    int ln1 = a.length;
    int ln2 = b.length;

    int result[] = new int[ln1 + ln2];
    sortedMerge(a, b, result, ln1, ln2);

    System.out.print("Sorted merged list :");
    for (int i = 0; i < ln1 + ln2; i++) {
      System.out.print(" " + result[i]);
    }
  }

  private static void sortedMerge(int[] ar1, int[] ar2, int[] result, int ln1, int ln2) {
    Arrays.sort(ar1);
    Arrays.sort(ar2);

    int i = 0, j = 0, k = 0;
    while (i < ln1 && j < ln2) {
      if (ar1[i] < ar2[j]) {
        result[k++] = ar1[i++];
      } else {
        result[k++] = ar2[j++];
      }
    }
    while (i < ln1) {
      result[k++] = ar1[i++];
    }
    while (j < ln2) {
      result[k++] = ar2[j++];
    }
  }
}
