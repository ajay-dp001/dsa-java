package AAAMSPrepare.array;

public class RottenOranges {

  private static final int ROW = 3;
  private static final int COL = 5;

  public static void main(String[] args) {
    int mat[][] = {
        {2, 1, 0, 2, 1},
        {1, 0, 1, 2, 1},
        {1, 0, 0, 2, 1}};
    System.out.println("Max time incured: " + rotOranges(mat));
  }

  public static int rotOranges(int[][] arr) {
    boolean changed = false;
    int rotOrangePos = 2;
    while (true) {
      for (int i = 0; i < ROW; i++) {
        for (int j = 0; j < COL; j++) {
          //Rot Oranges present at [i-1, j], [i+1, j], [i, j-1], [i, j+1]
          if (arr[i][j] == rotOrangePos) {
            if (isSafe(i - 1, j) && arr[i - 1][j] == 1) {
              arr[i - 1][j] = arr[i][j] + 1;
              changed = true;
            }
            if (isSafe(i + 1, j) && arr[i + 1][j] == 1) {
              arr[i + 1][j] = arr[i][j] + 1;
              changed = true;
            }
            if (isSafe(i, j - 1) && arr[i][j - 1] == 1) {
              arr[i][j - 1] = arr[i][j] + 1;
              changed = true;
            }
            if (isSafe(i, j + 1) && arr[i][j + 1] == 1) {
              arr[i][j + 1] = arr[i][j] + 1;
              changed = true;
            }
          }
        }
      }
      if (!changed) {
        break;
      }
      changed = false;
      rotOrangePos++;
    }
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COL; j++) {
        if (arr[i][j] == 1) {
          return -1;
        }
      }
    }
    return rotOrangePos - 2;
  }

  private static boolean isSafe(int i, int j) {
    if (i >= 0 && i < ROW && j >= 0 && j < COL) {
      return true;
    }
    return false;
  }

}
