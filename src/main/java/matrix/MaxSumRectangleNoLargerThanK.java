package matrix;

//https://www.youtube.com/watch?v=yCQN096CwWM&t=725s
//https://github.com/mission-peace/interview/blob/94be5deb0c0df30ade2a569cf3056b7cc1e012f4/src/com/interview/dynamic/SubRectangularMatrixWithMaximumSum.java#L22

//https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/1313721/JavaPython-Sub-problem%3A-Max-Sum-of-Subarray-No-Larger-Than-K-Clean-and-Concise
//https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/147759/Clean-Java-Code-with-TreeSet(Beat-99.99)

import java.util.TreeSet;

public class MaxSumRectangleNoLargerThanK {

  public static void main(String[] args) {
    int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
    int k = 2;
    System.out.println("Max Sum : " + maxSumSubmatrix(matrix, k));
  }

  // O(M^2 * N * logN), Space: O(N)
  public static int maxSumSubmatrix(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    int ans = Integer.MIN_VALUE;
    for (int r1 = 0; r1 < m; ++r1) {
      int[] arr = new int[n]; // arr[i] is sum(matrix[r1][c]...matrix[r2][c])
      for (int r2 = r1; r2 < m; ++r2) {
        for (int c = 0; c < n; ++c) {
          arr[c] += matrix[r2][c];
        }
        ans = Math.max(ans, maxSumSubArray(arr, n, k));
      }
    }
    return ans;
  }

  static int maxSumSubArray(int[] arr, int n, int k) { // O(N * logN)
    TreeSet<Integer> bst = new TreeSet<>();
    bst.add(0);
    int ans = Integer.MIN_VALUE;
    for (int i = 0, right = 0; i < n; ++i) {
      right += arr[i];
      Integer left = bst.ceiling(right - k); // right - left <= k -> left >= right - k
      if (left != null) {
        ans = Math.max(ans, right - left);
      }
      bst.add(right);
    }
    return ans;
  }

}
