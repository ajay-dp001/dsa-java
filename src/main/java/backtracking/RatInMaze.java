package backtracking;

public class RatInMaze {

  private static int N;

  public static void main(String[] args) {
    int[][] maze = {
        {1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}};
    N = maze.length;
    solveMaze(maze, N);
  }

  private static boolean solveMaze(int[][] maze, int len) {
    int[][] sol = new int[len][len];
    if (!solveMazeUtil(maze, 0, 0, sol, len)) {
      System.out.println("No Solution exist.");
      return false;
    }
    printSol(maze);
    System.out.println("Sol is:");
    printSol(sol);
    return true;
  }

  private static boolean isSafe(int[][] maze, int x, int y) {
    return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
  }

  private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol, int len) {
    if (x == len - 1 && y == len - 1 && maze[x][y] == 1) {
      sol[x][y] = 1;
      return true;
    }
    if (isSafe(maze, x, y)) {
      if (sol[x][y] == 1) {
        return false;
      }
      sol[x][y] = 1;
      if (solveMazeUtil(maze, x + 1, y, sol, len)) {
        return true;
      }
      if (solveMazeUtil(maze, x, y + 1, sol, len)) {
        return true;
      }
      if (solveMazeUtil(maze, x - 1, y, sol, len)) {
        return true;
      }
      if (solveMazeUtil(maze, x, y - 1, sol, len)) {
        return true;
      }
      sol[x][y] = 0;
      return false;
    }
    return false;
  }

  private static void printSol(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
