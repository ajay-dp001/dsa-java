package graph;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {

  public static void main(String[] args) {
    GraphArrayListNode<Integer> graph = new GraphArrayListNode<>(4);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 1, 2);
    addEdge(graph, 2, 0);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 3);

    graph.printGraph(graph.getAdjList());

    System.out.print("Following is the BFS (Breadth First Traversal): ");
    bfs(graph, 2);
  }

  private static void bfs(GraphArrayListNode<Integer> graph, int v) {
    boolean[] visited = new boolean[graph.getV()];
    visited[v] = true;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);

    while (!queue.isEmpty()) {
      v = queue.poll();
      System.out.print(v + " ");

      List<Integer> verticesList = graph.getAdjList().get(v);
      for (int vertex : verticesList) {
        if (!visited[vertex]) {
          queue.add(vertex);
          visited[vertex] = true;
        }
      }
    }
  }

  private static void addEdge(final GraphArrayListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
  }
}
