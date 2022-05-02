package AAAFinalPrep.array;

import java.util.Arrays;

public class MergeSortedArray {

  public static void main(String[] args) {
    int arr1[] = {1, 5, 9, 10, 15, 20};
    int arr2[] = {2, 3, 8, 13, 16, 21};
    int ln1 = arr1.length - 1;
    int ln2 = arr2.length - 1;
    mergeSortedArray(arr1, arr2, ln1, ln2);

    System.out.println("Array 1 " + Arrays.toString(arr1));
    System.out.println("Array 2 " + Arrays.toString(arr2));
  }

  public static void mergeSortedArray(int[] arr1, int[] arr2, int len1, int len2) {
    for (int i = len2; i >= 0; i--) {
      int j, last = arr1[len1];
      for (j = len1 - 1; j >= 0 && arr1[j] > arr2[i]; j--) {
        arr1[j + 1] = arr1[j];
      }
      if (j != len1 - 1 || last > arr2[i]) {
        arr1[j + 1] = arr2[i];
        arr2[i] = last;
      }
    }
  }

  public static void mergSorted(int[] arr1, int[] arr2, int len1, int len2) {
    for (int i = len2; i >= 0; i--) {
      int j, last = arr1[len1];
      for (j = len1 - 1; j >= 0 && arr1[j] > arr2[i]; j--) {
        arr1[j + 1] = arr1[j];
      }
      if (j != len1 - 1 || last > arr2[i]) {
        arr1[j + 1] = arr2[i];
        arr2[i] = last;
      }
    }
  }


  public static void mergeSortedArrayPrac(int[] arr1, int[] arr2, int len1, int len2) {
    for (int i = len2; i >= 0; i--) {
      int j, last = arr1[len1];
      for (j = len1 - 1; j >= 0 && arr1[j] > arr2[i]; j--) {
        arr1[j + 1] = arr1[j];
      }
      if (j != len1 - 1 || last > arr2[i]) {
        arr1[j + 1] = arr2[i];
        arr2[i] = last;
      }
    }
  }

  private static void mergerSortdArray(int[] arr1, int[] arr2, int len1, int len2) {
    for (int i = len2; i >= 0; i--) {
      int j, last = arr1[len1 - 1];
      for (j = len1 - 1; j >= 0 && arr1[j] > arr2[i]; j--) {
        arr1[j + 1] = arr1[j];
      }
      if (j != len1 - 1 || last > arr2[i]) {
        arr1[j + 1] = arr2[i];
        arr2[i] = last;
      }
    }
  }

}
