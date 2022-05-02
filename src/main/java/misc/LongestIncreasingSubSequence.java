package misc;

import java.util.Map;

public class LongestIncreasingSubSequence {

  public static void main(String[] args) {
    int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
    //longestIncreasingSubSequence(arr);
    System.out.println("Length of lis is " + lis(arr));
    int arr1[] = {0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15};
    longestIncreasingSubSequence(arr1);
  }

  private static void longestIncreasingSubSequence(int[] arr) {
    int len = arr.length, max = 0, index = 0;
    int[] lis = new int[len];
    int[] subSequenceIndex = new int[len];

    for (int i = 0; i < len; i++) {
      lis[i] = 1;
    }

    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j] && lis[i] <= (lis[j] + 1)) {
          int oldlen = lis[i];
          lis[i] = Math.max(oldlen, lis[j] + 1);
          subSequenceIndex[i] = j;
        }
      }
    }

    for (int i = 0; i < len; i++) {
      if (max < lis[i]) {
        max = lis[i];
        index = i;
      }
    }
    System.out.println("MaxLength is : " + max);
    while (index != 0) {
      System.out.print(arr[index] + " ");
      index = subSequenceIndex[index];
    }
  }

  private static int lis(int[] arr) {
    int len = arr.length, max = 0;
    int lis[] = new int[len];

    for (int i = 0; i < len; i++) {
      lis[i] = 1;
    }

    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
          lis[i] = lis[j] + 1;
        }
      }
    }

    for (int i = 0; i < len; i++) {
      if (max < lis[i]) {
        max = lis[i];
      }
    }
    return max;
  }
}
