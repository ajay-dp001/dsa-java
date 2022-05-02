package matrix;

import java.util.LinkedList;
import java.util.Queue;

//https://github.com/naresh1406/youtube/blob/master/src/main/cp/leetcode/problems/_0542_01_Matrix.java
//https://leetcode.com/problems/01-matrix/discuss/1710877/Java-BFS-Solution
public class Distance01Matrix {

  public static void main(String[] args) {
    int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    int[][] matrix1 = {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}};
    int[][] result = bfs(matrix1);

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static int[][] updateMatrix(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    //Top to bottom and left to right
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] != 0) {
          int top = i - 1 >= 0 ? matrix[i - 1][j] : (int) 1e9;
          int left = j - 1 >= 0 ? matrix[i][j - 1] : (int) 1e9;
          matrix[i][j] = Math.min(top, left) + 1;
        }
      }
    }

    //Bottom to top and right to left
    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 0; j--) {
        int bottom = i + 1 < rows ? matrix[i + 1][j] : (int) 1e9;
        int right = j + 1 < cols ? matrix[i][j + 1] : (int) 1e9;
        matrix[i][j] = Math.min(matrix[i][j], Math.min(bottom, right) + 1);
      }
    }
    return matrix;
  }

  //https://www.youtube.com/watch?v=KpOoGf1fWzE
  private static int[][] bfs(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          queue.offer(new int[]{i, j});
        } else {
          matrix[i][j] = -1;
        }
      }
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      for (int[] d : dirs) {
        int r = cell[0] + d[0];
        int c = cell[1] + d[1];
        if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] != -1) {
          continue;
        }
        queue.add(new int[]{r, c});
        matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
      }
    }

    return matrix;
  }

}
