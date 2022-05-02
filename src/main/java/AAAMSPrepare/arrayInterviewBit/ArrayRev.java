package AAAMSPrepare.arrayInterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayRev {

  public static void main(String[] args) {

    int[] arr = {1, 2, 3};
    int len = arr.length;
    allSubArray(arr, len);
    System.out.println("Max Sum : " + maxSumSubArray(arr, len));

    int[] arr1 = {1, 0, 0, 1, 0, 1, 1};
    int len1 = arr1.length;
    System.out.println("Count is  :" + subArrayWithEqual0And1(arr1, len1));

    int arr2[] = {4, 3, 2, 7, 8, 2, 3, 1};
    int len2 = arr2.length;
    List<Integer> result = findDuplicate(arr2, len2);
    System.out.println(result);

    int a[][] = {
        {1, 2, 3, 4, 5, 6},
        {7, 8, 9, 10, 11, 12},
        {13, 14, 15, 16, 17, 18}};
    printSpiral(a);

    System.out.println();

    int[][] resultArr = generateMatrix(3);

    for (int i = 0; i < resultArr.length; i++) {
      for (int j = 0; j < resultArr[0].length; j++) {
        System.out.print(resultArr[i][j] + " ");
      }
      System.out.println();
    }

    List<String> list = new ArrayList<>();
    list.add("54");
    list.add("564");
    list.add("548");
    list.add("60");
    list.add("9");
    list.add("84");
    List<String> list2 = new ArrayList<>();

    int[] arr3 = {1, 34, 3, 98, 9};
    List<String> newList = new ArrayList<>();
    for (int num : arr3) {
      String str = Integer.toString(num);
      newList.add(str);
    }
    printLargest(newList);

    int[] arr4 = {1, 2, 3, 6, 5, 2};
    int[] arr41 = {5, 1, 1};
    int len4 = arr.length;
    int len41 = arr41.length;

    nextPermute(arr4, len4);
    System.out.println(Arrays.toString(arr4));
    nextPermute(arr41, len41);

    int[] arr12 = {0, 10, 2, -10, -20};
    System.out.println(firstsmallestPositiveMissing(arr12));

    int[][] arr5 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    printDiagonal(arr5);
    printAntiDiagonal(arr5);

    int[] arr6 = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
    int len6 = arr.length;
    int res6 = minLenUnSortedArray(arr6, len6);
    System.out.println(res6);

    int[] arr7 = {1, 2, 3, 5, 7};
    int len7 = arr.length;
    allSubArrayNSquare(arr7, len7);
  }

  private static int minLenUnSortedArray(int[] arr, int len) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    boolean flag = false;

    for (int i = 1; i < len; i++) {
      if (arr[i] < arr[i - 1]) {
        flag = true;
      }
      if (flag) {
        min = Math.min(min, arr[i]);
      }
    }

    flag = false;
    for (int i = len - 2; i >= 0; i--) {
      if (arr[i] < arr[i + 1]) {
        flag = true;
      }
      if (flag) {
        max = Math.max(max, arr[i]);
      }
    }

    int left, right;
    for (left = 0; left < len; left++) {
      if (min < arr[left]) {
        break;
      }
    }
    for (right = len - 1; right >= 0; right--) {
      if (max > arr[right]) {
        break;
      }
    }
    return right - left < 0 ? 0 : right - left + 1;
  }

  //NlogN
  private static int minLenUnsortedArray(int[] arr, int len) {
    int[] tempArr = arr.clone();
    Arrays.sort(tempArr);

    int start = len, end = 0;
    for (int i = 0; i < len; i++) {
      if (tempArr[i] != arr[i]) {
        start = Math.min(start, i);
        end = Math.max(end, i);
      }
    }
    return (end - start >= 0) ? end - start + 1 : 0;
  }

  private static void printAntiDiagonal(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;

    for (int i = 0; i < col - 1; i++) {
      int row_temp = 0;
      int col_temp = i;
      while (col_temp >= 0) {
        System.out.print(arr[row_temp][col_temp] + " ");
        row_temp++;
        col_temp--;
      }
      System.out.println();
    }

    for (int i = 0; i < row; i++) {
      int row_temp = i;
      int col_temp = col - 1;

      while (row_temp <= row - 1) {
        System.out.print(arr[row_temp][col_temp] + " ");
        row_temp++;
        col_temp--;
      }
      System.out.println();
    }
  }

  private static void printDiagonal(int[][] arr) {
    int row = arr.length;
    int col = arr[0].length;

    for (int i = 0; i < row - 1; i++) {
      int row_temp = i;
      int col_temp = 0;
      while (row_temp >= 0) {
        System.out.print(arr[row_temp][col_temp] + " ");
        row_temp--;
        col_temp++;
      }
      System.out.println();
    }

    for (int i = 0; i < col; i++) {
      int row_temp = row - 1;
      int col_temp = i;
      while (col_temp <= col - 1) {
        System.out.print(arr[row_temp][col_temp] + " ");
        row_temp = row_temp - 1;
        col_temp = col_temp + 1;
      }
      System.out.println();
    }
  }

  private static int firstsmallestPositiveMissing(int[] arr) {
    int len = arr.length;
    boolean[] boolArr = new boolean[len];

    for (int i = 0; i < len; i++) {
      if (arr[i] > 0 && arr[i] <= len) {
        boolArr[arr[i]] = true;
      }
    }
    for (int i = 1; i < len; i++) {
      if (!boolArr[i]) {
        return i;
      }
    }
    return len + 1;
  }

  private static void nextPermute(int[] arr, int len) {
    if (arr == null || len <= 1) {
      return;
    }
    int i = len - 2;
    while (i >= 0 && arr[i] >= arr[i + 1]) {
      i--;
    }
    if (i >= 0) {
      int j = len - 1;
      while (i != j && arr[i] >= arr[j]) {
        j--;
      }
      swap(arr, i, j);
    }
    reverse(arr, i + 1, len - 1);
  }

  private static void swap(int[] arr, int ps1, int ps2) {
    int temp = arr[ps1];
    arr[ps1] = arr[ps2];
    arr[ps2] = temp;
  }

  private static void reverse(int[] arr, int i, int j) {
    while (i < j) {
      swap(arr, i++, j--);
    }
  }

  private static void printLargest(List<String> list) {
    Collections.sort(list, (str1, str2) -> {
      String s1 = str1 + str2;
      String s2 = str2 + str1;
      return s1.compareTo(s2) > 0 ? -1 : 1;
    });

    for (String res : list) {
      System.out.print(res);
    }
  }

  private static int[][] generateMatrix(int A) {
    int rBIdx = 0, rEIdx = A, cBIdx = 0, cEIdx = A;
    int[][] arr = new int[A][A];
    int cnt = 1;
    while (rBIdx < rEIdx && cBIdx < cEIdx) {
      for (int i = cBIdx; i < cEIdx; i++) {
        arr[rBIdx][i] = cnt++;
      }
      rBIdx++;
      for (int i = rBIdx; i < rEIdx; i++) {
        arr[i][cEIdx - 1] = cnt++;
      }
      cEIdx--;
      if (rBIdx < rEIdx) {
        for (int i = cEIdx - 1; i >= cBIdx; i--) {
          arr[rEIdx - 1][i] = cnt++;
        }
        rEIdx--;
      }
      if (cBIdx < cEIdx) {
        for (int i = rEIdx - 1; i >= rBIdx; i--) {
          arr[i][cBIdx] = cnt++;
        }
        cBIdx++;
      }
    }
    return arr;
  }

  private static void printSpiral(int[][] arr) {
    int rowBIdx = 0, colBIdx = 0, rowEIdx = arr.length, colEIdx = arr[0].length;
    while (rowBIdx < rowEIdx && colBIdx < colEIdx) {
      for (int i = colBIdx; i < colEIdx; i++) {
        System.out.print(arr[rowBIdx][i] + " ");
      }
      rowBIdx++;
      for (int i = rowBIdx; i < rowEIdx; i++) {
        System.out.print(arr[i][colEIdx - 1] + " ");
      }
      colEIdx--;
      if (rowBIdx < rowEIdx) {
        for (int i = colEIdx - 1; i >= colBIdx; i--) {
          System.out.print(arr[rowEIdx - 1][i] + " ");
        }
      }
      rowEIdx--;
      if (colBIdx < colEIdx) {
        for (int i = rowEIdx - 1; i >= rowBIdx; i--) {
          System.out.print(arr[i][colBIdx] + " ");
        }
        colBIdx++;
      }
    }
  }

  // Num will ne btw 1-N
  private static List<Integer> findDuplicate(int[] nums, int len) {
    List<Integer> output_arr = new ArrayList<>();

    for (int i = 0; i < len; i++) {
      int index = Math.abs(nums[i]) - 1;

      if (nums[index] < 0) {
        output_arr.add(index + 1);
      }
      nums[index] = -nums[index];
    }

    return output_arr;
  }

  public static int subArrayWithEqual0And1(int[] arr, int len) {
    int cnt = 0, sum = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < len; i++) {
      if (arr[i] == 0) {
        arr[i] = -1;
      }
      sum += arr[i];
      if (sum == 0) {
        cnt++;
      }
      if (map.containsKey(sum)) {
        cnt += map.get(sum);
      }

      if (!map.containsKey(sum)) {
        map.put(sum, 1);
      } else {
        map.put(sum, map.get(sum) + 1);
      }
    }
    return cnt;
  }

  private static int maxSumSubArray(int[] arr, int len) {
    int sum = 0, max_sum = arr[0];
    for (int i = 0; i < len; i++) {
      sum += arr[i];
      if (max_sum < sum) {
        max_sum = sum;
      }
      if (sum < 0) {
        sum = 0;
      }
    }
    return max_sum;
  }

  private static void allSubArray(int[] arr, int len) {
    int max_sum = 0;
    for (int i = 0; i < len; i++) {
      for (int j = i; j < len; j++) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
          System.out.print(arr[k] + " ");
          sum = sum + arr[k];
          if (max_sum < sum) {
            max_sum = sum;
          }
        }
        System.out.println();
        System.out.println("Max Sum :" + max_sum);
      }
    }
  }

  //O(N^2)
  private static void allSubArrayNSquare(int[] arr, int len) {
    int cnt = 0;
    for (int i = 0; i < len; i++) {
      String str = "";
      for (int j = i; j < len; j++) {
        str += arr[j];
        cnt++;
        System.out.println(str + " " + cnt);
      }
    }
  }
}
