package AAAFinalPrep.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=ZD7WxJ3O2XE
public class FindTriplet {

  public static void main(String[] args) {
    int arr[] = {1, 4, 45, 6, 10, 8};
    int sum = 22;
    int len = arr.length;
    findTripletSum(arr, len, sum);
    findTripletSumEfficient(arr, len, sum);

    int[] arr2 = {1, 2, 3, 5};
    int len2 = arr2.length;
    System.out.println("Max Triplet Sum is :" + maxTripletSum(arr2, len2));

    //Count Triplets
    int[] arr1 = {1, 2, 3, 4, 5};
    int len1 = arr1.length;
    System.out.println("Triplet Count is: " + countTriplets(arr1, len1));

  }

  private static int cntTrip(int[] arr, int len) {
    int maxVal = 0;
    for (int i = 0; i < len; i++) {
      maxVal = Math.max(maxVal, arr[i]);
    }

    int[] freqArr = new int[maxVal + 1];
    for (int i = 0; i < len; i++) {
      freqArr[arr[i]]++;
    }

    int comb = 0;

    comb += freqArr[0] * (freqArr[0] - 1) * (freqArr[0] - 2) / 6;

    for (int i = 1; i <= maxVal; i++) {
      comb += freqArr[0] * (freqArr[i]) * (freqArr[i] - 1) / 2;
    }

    for (int i = 1; i * 2 <= maxVal; i++) {
      comb += freqArr[i] * (freqArr[i] - 1) / 2 * (freqArr[2 * i]);
    }

    for (int i = 1; i <= maxVal; i++) {
      for (int j = i + 1; i + j <= maxVal; j++) {
        comb += freqArr[i] * freqArr[j] * freqArr[i + j];
      }
    }
    return comb;
  }

  private static int countTriplets(int[] arr, int len) {
    int max_val = 0;

    for (int i = 0; i < len; i++) {
      max_val = Math.max(max_val, arr[i]);
    }
    int[] freqArr = new int[max_val + 1];

    for (int i = 0; i < len; i++) {
      freqArr[arr[i]]++;
    }

    int cnt = 0;

    cnt += freqArr[0] * (freqArr[0] - 1) * (freqArr[0] - 2) / 6;

    for (int i = 1; i <= max_val; i++) {
      cnt += freqArr[0] * freqArr[i] * (freqArr[i] - 1) / 2;
    }

    for (int i = 1; 2 * i <= max_val; i++) {
      cnt += freqArr[i] * (freqArr[i] - 1) / 2 * freqArr[2 * i];
    }

    for (int i = 1; i <= max_val; i++) {
      for (int j = i + 1; i + j <= max_val; j++) {
        cnt += freqArr[i] * freqArr[j] * freqArr[i + j];
      }
    }
    return cnt;
  }

  public static int maxTripletSum(int[] arr, int len) {
    int maxA = 0, maxB = 0, maxC = 0;
    for (int i = 0; i < len; i++) {
      if (arr[i] > maxA) {
        maxC = maxB;
        maxB = maxA;
        maxA = arr[i];
      } else if (arr[i] > maxB) {
        maxC = maxB;
        maxB = arr[i];
      } else if (arr[i] > maxC) {
        maxC = arr[i];
      }
    }
    return maxA + maxB + maxC;
  }

  //O(N^2)
  private static void findTripletSumEfficient(int[] arr, int len, int sum) {
    Arrays.sort(arr);
    for (int i = 0; i < len - 2; i++) {
      int j = i + 1;
      int k = len - 1;
      while (j < k) {
        if (arr[i] + arr[j] + arr[k] == sum) {
          System.out.println("Triplet is at: " + i + " " + j + " " + k);
          return;
        } else if (arr[i] + arr[j] + arr[k] < sum) {
          j++;
        } else {
          k--;
        }
      }
    }
  }


  //O(N^3)
  private static void findTripletSum(int[] arr, int len, int sum) {
    for (int i = 0; i < len - 2; i++) {
      for (int j = i + 1; j < len - 1; j++) {
        for (int k = j + 1; k < len; k++) {
          if (arr[i] + arr[j] + arr[k] == sum) {
            System.out.println("Triplet are present at: " + i + " " + j + " " + k);
          }
        }
      }
    }
  }


  private static long countTripletGPQuestion(int[] arr, long r) {
    Map<Long, Integer> prevMap = new HashMap();
    Map<Long, Integer> nextMap = new HashMap();
    for (long num : arr) {
      nextMap.putIfAbsent(num, nextMap.getOrDefault(num, 0) + 1);
    }
    long sum = 0;
    for (int i = 0; i < r; i++) {
      long rcnt = 0, lcnt = 0;
      long num = arr[0];
      nextMap.put(num, nextMap.getOrDefault(num, 0) - 1);
      if (prevMap.containsKey(num / r) && num % r == 0) {
        lcnt += prevMap.get(num / r);
      }
      if (nextMap.containsKey(num * r)) {
        rcnt = nextMap.get(num * r);
      }
      sum += rcnt * lcnt;
      prevMap.put(num, prevMap.getOrDefault(num, 0) + 1);
    }
    return sum;
  }

}
