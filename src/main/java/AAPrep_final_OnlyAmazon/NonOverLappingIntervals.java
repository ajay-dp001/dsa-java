package AAPrep_final_OnlyAmazon;
//https://leetcode.com/problems/non-overlapping-intervals/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverLappingIntervals {

  public static void main(String[] args) {
    int[][] arr = {{1, 3}, {8, 10}, {8, 9}, {15, 18}, {2, 6}, {2, 4}, {16, 17}, {9, 11}};
    int[][] re = merge(arr);
  }

  public static class interval {

    int start, end;

    interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public int eraseOverlapIntervals(int[][] intervals) {

    // answer is the total interval length minus the longest non-overlapping sequence
    // dp + binary search
    Arrays.sort(intervals, (a, b) -> {
      if (a[1] == b[1]) {
        return a[0] - b[0];
      } else {
        return a[1] - b[1];
      }
    });

    List<interval> list = new ArrayList<>();
    list.add(new interval(Integer.MIN_VALUE, Integer.MIN_VALUE));

    int n = intervals.length;

    for (int i = 0; i < n; i++) {
      list.add(new interval(intervals[i][0], intervals[i][1]));
    }

    int ans = 0;
    int[] dp = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      int p = binarySearch(intervals[i - 1][0], list);
      dp[i] = Math.max(dp[i - 1], dp[p] + 1);
    }
    return n - dp[n];
  }


  public int binarySearch(int v, List<interval> list) {
    int lo = 0, hi = list.size() - 1, ans = 0;
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      interval cur = list.get(mid);
      if (cur.end > v) {
        hi = mid - 1;
      } else if (cur.end <= v) {
        lo = mid + 1;
        ans = mid;
      }
    }
    return ans;
  }

  private static int[][] merge(int[][] intervals) {
    List<int[]> result = new ArrayList<>();
    if (intervals == null || intervals.length == 0) {
      return result.toArray(new int[0][]);
    }

    Arrays.sort(intervals, (a, b) -> {
      if (a[1] == b[1]) {
        return a[0] - b[0];
      } else {
        return a[1] - b[1];
      }
    });

    int start = intervals[0][0];
    int end = intervals[0][1];

    for (int[] arr : intervals) {
      if (arr[0] <= end) {
        end = Math.max(end, arr[1]);
      } else {
        result.add(new int[]{start, end});
        start = arr[0];
        end = arr[1];
      }
    }
    result.add(new int[]{start, end});
    return result.toArray(new int[0][]);
  }

}
