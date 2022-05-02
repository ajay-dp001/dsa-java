package AAPrep_final_OnlyAmazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/maximize-score-after-n-operations/discuss/1204735/Simple-Backtracking-and-Memorization-Java
//https://leetcode.com/problems/maximize-score-after-n-operations/discuss/1436675/BitMask-DP-precompute-gcd
//https://leetcode.com/problems/maximize-score-after-n-operations/discuss/1119535/Java-greedy-with-backtracking-(75ms-with-optimization-O(N2-log(N2)))
public class MaxScoreAfterNOperations {

  static int[] map;
  static int[][] dp;

  public static void main(String[] args) {
    int[] arr1 = {1, 2};
    int[] arr2 = {3, 4, 6, 8};
    int[] arr3 = {1, 2, 3, 4, 5, 6};
    System.out.println("Max score is :" + getMaxScore(arr1));
    System.out.println("Max score is :" + getMaxScore(arr2));
    System.out.println("Max score is :" + getMaxScore(arr3));

    Map<Integer, Integer> cache = new HashMap<>();
    System.out.println("Max score is :" + getMaxScoreDfs(arr3, 1, 0, cache));
  }


  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  private static int getMaxScore(int[] nums) {
    map = new int[16384];
    Arrays.fill(map, -1);

    dp = new int[nums.length][nums.length];
    for (int i = 0; i < dp.length; i++) {
      for (int j = i + 1; j < dp[0].length; j++) {
        dp[i][j] = gcd(nums[i], nums[j]);
      }
    }
    return find(nums, 0, 1);
  }

  private static int find(int[] nums, int mask, int idx) {
    if (map[mask] != -1) {
      return map[mask];
    }
    int ans = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int a = (1 << i) + (1 << j);
        if ((mask & a) == 0) {
          ans = Math.max(ans, idx * dp[i][j] + find(nums, mask | a, idx + 1));
        }
      }
    }
    map[mask] = ans;
    return ans;
  }


  private static int getMaxScoreDfs(int[] nums, int round, int state, Map<Integer, Integer> cache) {
    if (round > nums.length / 2) {
      return 0;
    }
    if (cache.containsKey(state)) {
      return cache.get(state);
    }
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int picked = (1 << i) | (1 << j);
        if ((state & picked) == 0) {
          ans = Math.max(ans,
              round * gcd(nums[i], nums[j]) + getMaxScoreDfs(nums, round + 1, state | picked, cache));
        }
      }
    }
    return cache.put(state, ans);
  }
}
