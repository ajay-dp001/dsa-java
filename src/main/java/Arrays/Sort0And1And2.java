package Arrays;

import prac.MyUtil;

public class Sort0And1And2 {

  public static void main(String[] args) {
    int arr[] = {0, 2, 1, 2, 0};
    dutchNationalFlagAlgo(arr);
    //sort012(arr);
    MyUtil.printArray(arr);
  }

  private static void dutchNationalFlagAlgo(int[] arr) {
    int lo = 0, mid = 0, hi = arr.length - 1;
    int temp;
    while (mid <= hi) {
      switch (arr[mid]) {
        case 0:
          temp = arr[lo];
          arr[lo] = arr[mid];
          arr[mid] = temp;
          lo++;
          mid++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          temp = arr[mid];
          arr[mid] = arr[hi];
          arr[hi] = temp;
          hi--;
          break;
      }
    }
  }

  private static void sort012(int[] arr) {
    int j = 0, cnt0 = 0, cnt1 = 0, cnt2 = 0;
    for (int i = 0; i < arr.length; i++) {
      switch (arr[i]) {
        case 0:
          cnt0++;
          break;
        case 1:
          cnt1++;
          break;
        case 2:
          cnt2++;
          break;
      }
    }

    while (cnt0 > 0) {
      arr[j++] = 0;
      cnt0--;
    }
    while (cnt1 > 0) {
      arr[j++] = 1;
      cnt1--;
    }
    while (cnt2 > 0) {
      arr[j++] = 2;
      cnt2--;
    }
  }


}
