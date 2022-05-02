package AAAMSPrepare.misc;

public class MergeTwoSortedArray {

  public static void main(String[] args) {
    int[] arr1 = {1, 3, 5, 7};
    int len1 = arr1.length;

    int[] arr2 = {2, 4, 6, 8};
    int len2 = arr2.length;

    int[] arr3 = new int[len1 + len2];

    mergeArrays(arr1, arr2, len1, len2, arr3);

    System.out.println("Array after merging");
    for (int i = 0; i < arr3.length; i++) {
      System.out.print(arr3[i] + " ");
    }
  }

  private static void mergeArrays(int[] arr1, int[] arr2, int len1, int len2, int[] arr3) {
    int i = 0, j = 0, k = 0;

    while (i < len1 && j < len2) {
      if (arr1[i] < arr2[j]) {
        arr3[k++] = arr1[i++];
      } else {
        arr3[k++] = arr2[j++];
      }
    }

    while (i < len1) {
      arr3[k++] = arr1[i++];
    }
    while (j < len2) {
      arr3[k++] = arr2[j++];
    }
  }
}
