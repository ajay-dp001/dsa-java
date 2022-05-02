package matrix;

public class SearchInMatrix {

  public static void main(String[] args) {
    int target = 3;
    int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    System.out.println(searchInMatrix(target, matrix));
    System.out.println(searchInMatrixEff(target, matrix));

    int[][] matrix1 = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}};
    int[][] mat ={{-5}};
    System.out.println(searchMatrix(matrix1, 5));
  }

  private static boolean searchInMatrix(int target, int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    int idx = 0;
    for (int i = 0; i < rows; i++) {
      if (matrix[i][0] <= target && matrix[i][cols - 1] >= target) {
        idx = i;
        break;
      }
    }

    for (int j = 0; j < cols; j++) {
      if (matrix[idx][j] == target) {
        return true;
      }
    }
    return false;
  }

  private static boolean searchInMatrixEff(int target, int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;

    int start = 0, end = rows * cols - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      int mid_val = matrix[mid / cols][mid % cols];

      if (mid_val == target) {
        return true;
      }

      if (mid_val < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return false;
  }

  private static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
      return false;
    }

    int row = 0, col = matrix[0].length - 1;

    while (col >= 0 && row <= matrix.length - 1) {
      if (target == matrix[row][col]) {
        return true;
      } else if (target < matrix[row][col]) {
        col--;
      } else if (target > matrix[row][col]) {
        row++;
      }
    }
    return false;
  }

}
