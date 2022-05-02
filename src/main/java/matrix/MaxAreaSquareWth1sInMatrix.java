package matrix;

public class MaxAreaSquareWth1sInMatrix {

  public static void main(String[] args) {
    int[][] matrix = {
        {0, 1, 1, 1, 0},
        {1, 1, 1, 1, 1},
        {0, 1, 1, 1, 1},
        {0, 1, 1, 1, 1},
        {0, 0, 1, 1, 1}};

    int max_area = maxsqArea(matrix);
    System.out.println("Max Area :" + max_area);

    System.out.println("Max Area :" + maxSquareArea(matrix));
  }
  //Efficient
  private static int maxSquareArea(int[][] matrix) {
    int rows = matrix.length;
    int cols = rows > 0 ? matrix[0].length : 0;

    int[] dp = new int[cols + 1];
    int maxLen = 0, prev = 0;

    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        int temp = dp[j];
        if (matrix[i - 1][j - 1] == 1) {
          dp[j] = Math.min(dp[j], Math.min(dp[j - 1], prev)) + 1;
          maxLen = Math.max(maxLen, dp[j]);
        } else {
          dp[j] = 0;
        }
        prev = temp;
      }
    }
    return maxLen * maxLen;
  }

  private static int maxsqArea(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    int max_area = 0;
    int[][] dp = new int[rows + 1][cols + 1];

    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        if (grid[i - 1][j - 1] == 1) {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
          max_area = Math.max(max_area, dp[i][j]);
        }
      }
    }
    return max_area * max_area;
  }
}
