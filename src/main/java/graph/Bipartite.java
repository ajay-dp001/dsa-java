package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

  private static final int V = 4;

  public static void main(String[] args) {
    int arr[][] = {{0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 1, 0}};

    if (isBipartite(arr, 0)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

  private static boolean isBipartite(int[][] arr, int src) {
    int[] color = new int[V];
    color[src] = 1;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(src);

    while (!queue.isEmpty()) {
      int u = queue.poll();
      // Return false if there is a self-loop
      if (arr[u][u] == 1) {
        return false;
      }
      for (int i = 0; i < V; i++) {
        if (arr[u][i] == 1 && color[i] == 0) {
          color[i] = 1 - color[u];
          queue.add(i);
        } else if (arr[u][i] == 1 && color[i] == color[u]) {
          return false;
        }
      }
    }
    return true;
  }
}
