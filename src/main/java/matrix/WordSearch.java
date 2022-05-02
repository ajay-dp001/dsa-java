package matrix;

public class WordSearch {

  public static void main(String[] args) {
    char[][] board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}};

    String str1 = "ABCCED";
    String str2 = "SEE";
    String str3 = "ABCB";

    System.out.println("Exists :" + wordSearch(board, str1));
    System.out.println("Exists :" + wordSearch(board, str2));
    System.out.println("Exists :" + wordSearch(board, str3));
  }

  private static boolean wordSearch(char[][] grid, String str) {

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == str.charAt(0) && dfs(grid, i, j, 0, str)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean dfs(char[][] grid, int i, int j, int cnt, String str) {
    if (cnt == str.length()) {
      return true;
    }
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != str.charAt(cnt)) {
      return false;
    }
    char tempCh = grid[i][j];

    grid[i][j] = ' ';

    boolean found =
        dfs(grid, i + 1, j, cnt + 1, str)
            || dfs(grid, i - 1, j, cnt + 1, str)
            || dfs(grid, i, j + 1, cnt + 1, str)
            || dfs(grid, i, j - 1, cnt + 1, str);

    grid[i][j] = tempCh;

    return found;
  }
}
