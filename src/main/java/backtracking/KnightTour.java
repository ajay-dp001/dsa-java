package backtracking;

// https://www.youtube.com/watch?v=SP880DBRJ_8
public class KnightTour {

  static int N = 8;

  public static void main(String[] args) {
    int len = 5;
    int row = 4, col = 4;

    int[][] chess = new int[len][len];

    knightTour(chess, row, col, 1);
    solveKnightTour(chess, N);
  }

  /* Time Complexity There are N2 Cells and for each, we have a maximum of 8 possible moves to choose from,
  so the worst running time is O(8^(N^2)),
  Space Complexity :O(N^2)
  */
  private static void knightTour(int[][] chess, int row, int col, int move) {
    if (row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0) {
      return;
    } else if (move == chess.length * chess.length) {
      chess[row][col] = move;
      displayBoard(chess);
      chess[row][col] = 0;
      return;
    }

    chess[row][col] = move;
    knightTour(chess, row - 2, col + 1, move + 1);
    knightTour(chess, row - 1, col + 2, move + 1);
    knightTour(chess, row + 1, col + 2, move + 1);
    knightTour(chess, row + 2, col + 1, move + 1);
    knightTour(chess, row + 2, col - 1, move + 1);
    knightTour(chess, row + 1, col - 2, move + 1);
    knightTour(chess, row - 1, col - 2, move + 1);
    knightTour(chess, row - 2, col - 1, move + 1);
    chess[row][col] = 0;
  }


  private static boolean solveKnightTour(int[][] chess, int N) {
    int[][] sol = new int[8][8];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sol[i][j] = -1;
      }
    }
    int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
    sol[0][0] = 0;
    if (!solveKnightTourUtil(0, 0, 1, sol, xMove, yMove)) {
      System.out.println("Solution does not exist.!");
      return false;
    }
    displayBoard(sol);
    return true;
  }

  private static boolean solveKnightTourUtil(int x, int y, int move, int[][] sol, int[] xMove, int[] yMove) {
    int k, next_x, next_y;
    if (move == N * N) {
      return true;
    }
    for (k = 0; k < 8; k++) {
      next_x = x + xMove[k];
      next_y = y + yMove[k];
      if (isSafe(next_x, next_y, sol)) {
        sol[next_x][next_y] = move;
        if (solveKnightTourUtil(next_x, next_y, move + 1, sol, xMove, yMove)) {
          return true;
        } else {
          sol[next_x][next_y] = -1;
        }
      }
    }
    return false;
  }

  private static boolean isSafe(int x, int y, int sol[][]) {
    return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
  }

  private static void displayBoard(int[][] chess) {
    for (int i = 0; i < chess.length; i++) {
      for (int j = 0; j < chess[0].length; j++) {
        System.out.print(chess[i][j] + " ");
      }
      System.out.println();
    }
  }


}
