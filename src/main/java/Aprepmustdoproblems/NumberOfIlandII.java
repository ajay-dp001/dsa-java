package Aprepmustdoproblems;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIlandII {

  public static void main(String[] args) {
    //int[][] arr = new int[3][5];
    int[][] arr = {{0, 5, 3, 0, 0}, {0, 2, 0, 0, 0}, {0, 3, 0, 2, 5}};
    boolean[][] visited = new boolean[3][5];

    int count = 0, max_sum = 0;
    List<Integer> visitedList = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] != 0 && !visited[i][j]) {
          int sum=0;
          for (int v : isConnected(arr, i, j, visited, visitedList)) {
            sum += v;
          }
          max_sum = Math.max(max_sum, sum);
          count++;
        }
      }
    }
    System.out.println("Number of Virus.." + max_sum);
  }

  private static boolean isSafe(int[][] arr, int i, int j, boolean[][] visited) {
    if (i >= 0 && i < arr.length && j >= 0 && j < arr[0].length && arr[i][j] != 0 && !visited[i][j]) {
      return true;
    }
    return false;
  }

  private static List<Integer> isConnected(int[][] arr, int i, int j, boolean[][] visited,
      List<Integer> vList) {
    if (isSafe(arr, i, j, visited)) {
      vList.add(arr[i][j]);

      visited[i][j] = true;
      isConnected(arr, i - 1, j, visited, vList);
      isConnected(arr, i + 1, j, visited, vList);
      isConnected(arr, i, j - 1, visited, vList);
      isConnected(arr, i, j + 1, visited, vList);
      isConnected(arr, i - 1, j - 1, visited, vList);
      isConnected(arr, i + 1, j + 1, visited, vList);
      isConnected(arr, i - 1, j + 1, visited, vList);
      isConnected(arr, i + 1, j - 1, visited, vList);
    }
    return vList;
  }
}
