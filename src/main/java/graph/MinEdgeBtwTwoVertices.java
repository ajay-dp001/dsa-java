package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinEdgeBtwTwoVertices {

  public static void main(String[] args) {
    GraphLinkListNode<Integer> graph = new GraphLinkListNode<>(9);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 7);
    addEdge(graph, 1, 7);
    addEdge(graph, 1, 2);
    addEdge(graph, 2, 3);
    addEdge(graph, 2, 5);
    addEdge(graph, 2, 8);
    addEdge(graph, 3, 4);
    addEdge(graph, 4, 5);
    addEdge(graph, 5, 6);
    addEdge(graph, 6, 7);
    addEdge(graph, 7, 8);

    int u = 0, v = 5;
    System.out.println(minEdgeBtw(graph, u, v));
  }

  private static int minEdgeBtw(GraphLinkListNode<Integer> graph, int u, int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(u);

    int[] distanceList = new int[graph.getV()];
    distanceList[u] = 0;

    boolean[] visited = new boolean[graph.getV()];
    visited[u] = true;

    while (!queue.isEmpty()) {
      int vertexU = queue.poll();
      List<Integer> adjListU = graph.getAdjList().get(vertexU);
      for (int i = 0; i < adjListU.size(); i++) {
        if (!visited[adjListU.get(i)]) {
          queue.add(adjListU.get(i));
          visited[adjListU.get(i)] = true;
          distanceList[adjListU.get(i)] = distanceList[vertexU] + 1;
        }
      }
    }
    return distanceList[v];
  }

  private static void addEdge(GraphLinkListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
  }
}
