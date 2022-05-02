package queue;

public class RotOranges {

  static int Row = 3;
  static int Col = 5;

  private static boolean isSafe(int i, int j) {
    if (i >= 0 && i < Row && j >= 0 && j < Col) {
      return true;
    }
    return false;
  }

  private static int rotOranges(int[][] mat) {
    boolean changed = false;
    int num = 2;
    while (true) {
      for (int i = 0; i < Row; i++) {
        for (int j = 0; j < Col; j++) {
          // Rot all other oranges present at (i+1, j), (i, j-1), (i, j+1), (i-1, j)
          if (mat[i][j] == num) {
            if (isSafe(i + 1, j) && mat[i + 1][j] == 1) {
              mat[i + 1][j] = mat[i][j] + 1;
              changed = true;
            }
            if (isSafe(i, j + 1) && mat[i][j + 1] == 1) {
              mat[i][j + 1] = mat[i][j] + 1;
              changed = true;
            }
            if (isSafe(i - 1, j) && mat[i - 1][j] == 1) {
              mat[i - 1][j] = mat[i][j] + 1;
              changed = true;
            }
            if (isSafe(i, j - 1) && mat[i][j - 1] == 1) {
              mat[i][j - 1] = mat[i][j] + 1;
              changed = true;
            }
          }
        }
      }
      if (!changed) {
        break;
      }
      changed = false;
      num++;
    }
    for (int i = 0; i < Row; i++) {
      for (int j = 0; j < Col; j++) {
        if (mat[i][j] == 1) {
          return -1;
        }
      }
    }
    return num - 2;
  }

  public static void main(String[] args) {
    int mat[][] = {
        {2, 1, 0, 2, 1},
        {1, 0, 1, 2, 1},
        {1, 0, 0, 2, 1}};
    System.out.println("Max time incured: " + rotOranges(mat));
  }
}