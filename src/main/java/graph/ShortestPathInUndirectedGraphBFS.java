package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUndirectedGraphBFS {

  public static void main(String[] args) {
    GraphLinkListNode<Integer> graph = new GraphLinkListNode<>(4);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 1, 2);
    addEdge(graph, 2, 0);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 3);

    int src = 0;
    shortestPath(graph, src);
  }

  private static void shortestPath(GraphLinkListNode<Integer> graph, int src) {
    int[] dist = new int[graph.getV()];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(src);

    while (!queue.isEmpty()) {
      int v = queue.poll();
      List<Integer> verticesList = graph.getAdjList().get(v);
      for (int vertex : verticesList) {
        if (dist[v] + 1 < dist[vertex]) {
          dist[vertex] = dist[v] + 1;
          queue.add(vertex);
        }
      }
    }
    for (int i : dist) {
      System.out.print(dist[i] + " ");
    }
  }

  private static void addEdge(GraphLinkListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
  }

}
