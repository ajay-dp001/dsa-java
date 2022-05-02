package backtracking;

public class WordSearch {

  static boolean[][] visited;

  public static void main(String[] args) {
    String word = "ABCCED";
    char[][] arr = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    System.out.println("Word Exist :" + findWord(arr, word));
  }

  private static boolean findWord(char[][] charr, String word) {
    for (int i = 0; i < charr.length; i++) {
      for (int j = 0; j < charr[0].length; j++) {
        if (word.charAt(0) == charr[i][j] && exist(charr, word, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean exist(char[][] charr, String word, int i, int j, int count) {
    if (count == word.length()) {
      return true;
    }
    if (i < 0 || j < 0 || i >= charr.length || j >= charr[0].length || charr[i][j] != word.charAt(count)) {
      return false;
    }
    char temp = charr[i][i];
    charr[i][j] = ' ';

    boolean found = exist(charr, word, i + 1, j, count + 1)
        || exist(charr, word, i - 1, j, count + 1)
        || exist(charr, word, i, j - 1, count + 1)
        || exist(charr, word, i, j + 1, count + 1);

    charr[i][j] = temp;
    return found;
  }

}
