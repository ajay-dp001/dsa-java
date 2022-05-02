package Arrays;

import java.util.Arrays;

public class MergeSortedArrayWithO1ExtraSpae {

  public static void main(String[] args) {
    int arr1[] = {1, 5, 9, 10, 15, 20};
    int arr2[] = {2, 3, 8, 13, 16, 21};
    int ln1 = arr1.length;
    int ln2 = arr2.length;
    mergSorted(arr1, arr2, ln1, ln2);

    System.out.println("Array 1 " + Arrays.toString(arr1));
    System.out.println("Array 2 " + Arrays.toString(arr2));

    int arr11[] = {1, 2, 3, 4, 6, 7};
    int arr22[] = {2, 5, 6};
    int ln11 = arr11.length;
    int ln22 = arr22.length;
    merge(arr11, ln11, arr22, ln22);
    System.out.println("Array 1 " + Arrays.toString(arr11));
    System.out.println("Array 2 " + Arrays.toString(arr22));

    int ar1[] = {-5, 3, 6, 12, 15};
    int ar2[] = {-12, -10, -6, -3, 4, 10};
    int len1 = ar1.length;
    int len2 = ar2.length;
    merge(ar1, len1, ar2, len2);

    System.out.println("Array 1 " + Arrays.toString(ar1));
    System.out.println("Array 2 " + Arrays.toString(ar2));
    int median = 1 + (len1 + len2) / 2;
    System.out.println("Median is " + median);
  }

  // TimeComplexity O((n+m)log(m+n)) Space O(1)
  private static void mergSorted(int[] arr1, int[] arr2, int ln1, int ln2) {
    int i = 0, temp;
    while (arr1[ln1 - 1] > arr2[0]) {
      if (arr1[i] > arr2[0]) {
        temp = arr1[i];
        arr1[i] = arr2[0];
        arr2[0] = temp;
        Arrays.sort(arr2);
      }
      i++;
    }
  }

  // O(m*n)
  public static void merge(int[] arr1, int ln1, int[] arr2, int ln2) {
    for (int i = ln2 - 1; i >= 0; i--) {
      int j, last = arr1[ln1 - 1];
      for (j = ln1 - 2; j >= 0 && arr1[j] > arr2[i]; j--) {
        arr1[j + 1] = arr1[j];
      }
      if (j != ln1 - 2 || last > arr2[i]) {
        arr1[j + 1] = arr2[i];
        arr2[i] = last;
      }
    }
  }
}
