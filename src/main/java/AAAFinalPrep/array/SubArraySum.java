package AAAFinalPrep.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubArraySum {

  public static void main(String[] args) {
    int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
    int arr1[] = {-15, 2, -4, 18, 9, -5, 10, 23};
    int len = arr.length;
    int sum = 23;
    int sum1 = 20;
    printSubArray(arr, len);
    subArrayWithGivenSum(arr, len, sum);
    subArrayWithGivenSumOn(arr1, len, sum1);
  }

  //O(N) for both +ve ,-ve integer
  private static void subArrayWithGivenSumOn(int[] arr, int len, int sum) {
    int currSum = 0, start = 0, end = -1;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < len; i++) {
      currSum += arr[i];
      if (currSum - sum == 0) {
        start = 0;
        end = i;
        break;
      }
      if (map.containsKey(currSum - sum)) {
        start = map.get(currSum - sum) + 1;
        end = i;
        break;
      }
      map.put(currSum, i);
    }
    if (end == -1) {
      System.out.println("No Sub Array Found");
    } else {
      System.out.println("SubArray found btw :" + start + " to " + end);
    }
  }

  //O(N) Only For +ve integer
  private static void subArrayWithGivenSumON(int[] arr, int len, int sum) {
    int currSum = arr[0], start = 0;
    for (int i = 1; i < len; i++) {
      while (currSum > sum && start < i - 1) {
        currSum = currSum - arr[start];
        start++;
      }
      if (currSum == sum) {
        int prt = i - 1;
        System.out.println("Sub Array found between index: " + start + " and " + prt);
        return;
      }
      currSum += arr[i];
    }
    System.out.println("No Array found");
  }

  //O(N^2)
  private static void subArrayWithGivenSum(int[] arr, int len, int sum) {
    int currSum;
    for (int i = 0; i < len; i++) {
      currSum = arr[i];
      for (int j = i + 1; j < len; j++) {
        if (currSum == sum) {
          int prt = j - 1;
          System.out.println("Sub Array found between index: " + i + " and " + prt);
          return;
        }
        if (currSum > sum) {
          break;
        }
        currSum += arr[j];
      }
    }
    System.out.println("No Array found");
  }

  private static void printSubArray(int[] arr, int len) {
    for (int i = 0; i < len; i++) {
      for (int j = i; j < len; j++) {
        for (int k = i; k <= j; k++) {
          System.out.print(arr[k] + " ");
        }
        System.out.println();
      }
    }
  }

}
