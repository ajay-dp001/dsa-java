package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CountPathToReachDestInMaze {

  public static void main(String[] args) {
    int n = 3, m = 3;
    List<String> paths = getMazePaths(1, 1, n, m);
    System.out.println(paths);

    printMazePaths(1, 1, n, m, "");
  }

  private static void printMazePaths(int sRow, int sCol, int dRow, int dCol, String pathSoFar) {
    if (sRow > dRow || sCol > dCol) {
      return;
    }
    if (sRow == dRow && sCol == dCol) {
      System.out.print(pathSoFar + " ");
      return;
    }
    printMazePaths(sRow, sCol + 1, dRow, dCol, pathSoFar + "h");
    printMazePaths(sRow + 1, sCol, dRow, dCol, pathSoFar + "v");
  }

  public static List<String> getMazePaths(int srcRow, int srcCol, int dRow, int dCol) {
    if (srcRow == dRow && srcCol == dCol) {
      List<String> resultList = new ArrayList<>();
      resultList.add("");
      return resultList;
    }
    List<String> hPaths = new ArrayList<>();
    List<String> vPaths = new ArrayList<>();
    if (srcCol < dCol) {
      hPaths = getMazePaths(srcRow, srcCol + 1, dRow, dCol);
    }
    if (srcRow < dRow) {
      vPaths = getMazePaths(srcRow + 1, srcCol, dRow, dCol);
    }

    List<String> paths = new ArrayList<>();

    for (String hPath : hPaths) {
      paths.add("h" + hPath);
    }

    for (String vPath : vPaths) {
      paths.add("v" + vPath);
    }

    return paths;
  }

}
