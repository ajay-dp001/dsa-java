package matrix;
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/1322101/C%2B%2BJavaPython-MaxHeap-MinHeap-Binary-Search-Picture-Explain-Clean-and-Concise
public class KthSmallestElementInSortedMatrix {

  public static void main(String[] args) {
    int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
    int k = 8;
    System.out.println("Kth Smallest :" + kthSmallest(matrix, k));
  }

  public static int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int count = getLessEqual(matrix, mid);
      if (count < k) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return lo;
  }

  private static int getLessEqual(int[][] matrix, int val) {
    int res = 0;
    int n = matrix.length, i = n - 1, j = 0;
    while (i >= 0 && j < n) {
      if (matrix[i][j] > val) {
        i--;
      } else {
        res += i + 1;
        j++;
      }
    }
    return res;
  }
}
