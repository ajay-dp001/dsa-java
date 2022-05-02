package backtracking;

import java.util.ArrayList;
import java.util.List;

public class MazePathsWithJump {

  public static void main(String[] args) {
    int n = 3, m = 3;
    List<String> paths = getmazePaths(1, 1, n, m);
    System.out.println(paths);

    printMazePaths(1, 1, n, m, "");
  }

  public static void printMazePaths(int sRow, int sCol, int dRow, int dCol, String psf) {
    if (sRow == dRow && sCol == dCol) {
      System.out.print(psf+" ");
      return;
    }
    //Horizontal Moves
    for (int ms = 1; ms <= dCol - sCol; ms++) {
      printMazePaths(sRow, sCol + ms, dRow, dCol, psf + "h" + ms);
    }

    //Vertical Moves
    for (int ms = 1; ms <= dRow - sRow; ms++) {
      printMazePaths(sRow+ms, sCol, dRow, dCol, psf + "v" + ms);
    }

    //Diagonal Moves
    for (int ms = 1; ms <= dRow - sRow && ms <= dCol - sCol; ms++) {
      printMazePaths(sRow + ms, sCol + ms, dRow, dCol, psf+"d"+ms);
    }
  }

  public static List<String> getmazePaths(int sRow, int sCol, int dRow, int dCol) {
    if (sRow == dRow && sCol == dCol) {
      List<String> baseRes = new ArrayList<>();
      baseRes.add("");
      return baseRes;
    }
    List<String> paths = new ArrayList<>();

    //Horizontal Moves
    for (int ms = 1; ms <= dCol - sCol; ms++) {
      List<String> hPaths = getmazePaths(sRow, sCol + ms, dRow, dCol);
      for (String hPath : hPaths) {
        paths.add("h" + ms + hPath);
      }
    }

    //Vertical Moves
    for (int ms = 1; ms <= dRow - sRow; ms++) {
      List<String> vPaths = getmazePaths(sRow + ms, sCol, dRow, dCol);
      for (String vPath : vPaths) {
        paths.add("v" + ms + vPath);
      }
    }

    //Diagonal Moves
    for (int ms = 1; ms <= dRow - sRow && ms <= dCol - sCol; ms++) {
      List<String> dPaths = getmazePaths(sRow + ms, sCol + ms, dRow, dCol);
      for (String dPath : dPaths) {
        paths.add("d" + ms + dPath);
      }
    }

    return paths;
  }

}
