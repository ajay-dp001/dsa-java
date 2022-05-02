package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GetStairsPath {

  public static void main(String[] args) {
    int num = 4;
    List<String> paths = getStairsPath(num);
    System.out.println(paths);

    printStairsPath(num, "");
  }

  private static void printStairsPath(int num, String ans) {
    if (num < 0) {
      return;
    }
    if (num == 0) {
      System.out.println(ans);
      return;
    }
    printStairsPath(num - 1, ans + "1");
    printStairsPath(num - 2, ans + "2");
    printStairsPath(num - 3, ans + "3");
  }

  public static List<String> getStairsPath(int num) {
    if (num == 0) {
      List<String> resultList = new ArrayList<>();
      resultList.add("");
      return resultList;
    } else if (num < 0) {
      List<String> resultList = new ArrayList<>();
      return resultList;
    }
    List<String> paths1 = getStairsPath(num - 1);
    List<String> paths2 = getStairsPath(num - 2);
    List<String> paths3 = getStairsPath(num - 3);
    List<String> paths = new ArrayList<>();

    for (String path : paths1) {
      paths.add(1 + path);
    }
    for (String path : paths2) {
      paths.add(2 + path);
    }
    for (String path : paths3) {
      paths.add(3 + path);
    }
    return paths;
  }

}
