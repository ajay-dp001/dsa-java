package AAAFinalPrep.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {

  public static void main(String[] args) {
    int target = 100;
    int[] arr = {34, 55, 12, 66, 77, 47, 28, 56, 52, 32, 48};
    //O(N^2)
    int result = twoSumBruteForce(arr, target);
    System.out.println("No of Pairs are: " + result);
    //O(N)
    twoSum(arr, target);

    int[] x = {2, 1, 3, 6, 2, 9, 4};
    int[] y = {1, 5, 4, 2};
    int xlen = x.length;
    int ylen = y.length;
    System.out.println(countPairsBruteForce(x, y, xlen, ylen));
    System.out.println(countPairsBruteForceEff(x, y, xlen, ylen));

    int[] X = {10, 19, 18};
    int[] Y = {11, 15, 9};

    int m = X.length;
    int n = Y.length;

    System.out.print(countPairsBruteForceEff(X, Y, m, n));
  }

  public static int twoSumBruteForce(int[] arr, int sum) {
    int cnt = 0, len = arr.length;
    for (int i = 0; i < len; i++) {
      for (int j = i+1; j < len; j++) {
        if (arr[i] + arr[j] == sum) {
          cnt++;
        }
      }
    }
    return cnt;
  }

  public static void twoSum(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int diff = target - arr[i];
      if (map.containsKey(diff)) {
        System.out.println(map.get(diff) + "" + i);
      } else {
        map.put(arr[i], i);
      }
    }
  }

  private static long countPairsBruteForce(int[] X, int[] Y, int m, int n) {
    long ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (Math.pow(X[i], Y[j]) > Math.pow(Y[j], X[i])) {
          ans++;
        }
      }
    }
    return ans;
  }

  private static long countPairsBruteForceEff(int[] arrX, int[] arrY, int m, int n) {
    //To Store count of 0,1,2,3,4
    int[] freqArr = new int[5];
    for (int i = 0; i < n; i++) {
      if (arrY[i] < 5) {
        freqArr[arrY[i]]++;
      }
    }

    Arrays.sort(arrY);
    long total_pairs = 0;
    for (int i = 0; i < m; i++) {
      total_pairs += countPairs(arrX[i], arrY, n, freqArr);
    }
    return total_pairs;
  }

  private static int countPairs(int x, int[] arrY, int len2, int[] freqArr) {
    if (x == 0) {
      return 0;
    }
    if (x == 1) {
      return freqArr[0];
    }
    int cnt = 0;
    int idx = Arrays.binarySearch(arrY, x);
    if (idx < 0) {
      idx = Math.abs(idx + 1);
      cnt = len2 - idx;
    } else {
      while (idx < len2 && arrY[idx] == x) {
        idx++;
      }
      cnt = len2 - idx;
    }

    cnt += (freqArr[0] + freqArr[1]);
    if (x == 2) {
      cnt -= (freqArr[3] + freqArr[4]);
    }
    if (x == 3) {
      cnt += freqArr[2];
    }
    return cnt;
  }

  private static long countPairPracEff(int[] arr1, int[] arr2, int len1, int len2) {
    int[] freqArr = new int[5];
    for (int i = 0; i < len2; i++) {
      if (arr1[i] < 5) {
        freqArr[arr2[i]]++;
      }
    }

    Arrays.sort(arr2);
    long totalPairs = 0;
    for (int i = 0; i < len1; i++) {
      totalPairs += countPairsPrac(arr1[i], arr2, len2, freqArr);
    }
    return totalPairs;
  }

  private static int countPairsPrac(int num, int[] arr2, int len2, int[] freqArr) {
    if (num == 0) {
      return 0;
    }
    if (num == 1) {
      return freqArr[0];
    }
    int cnt = 0;
    int idxX = Arrays.binarySearch(arr2, num);
    if (idxX < 0) {
      idxX = Math.abs(idxX + 1);
      cnt = len2 - idxX;
    } else {
      while (idxX < len2 && arr2[idxX] == num) {
        idxX++;
      }
      cnt = len2 - idxX;
    }

    cnt += freqArr[0] + freqArr[1];
    if (num == 2) {
      cnt -= (freqArr[3] + freqArr[4]);
    }
    if (num == 3) {
      cnt += freqArr[2];
    }
    return cnt;
  }
}
