package graph;

import java.util.List;

public class DetectCycleInUnDirectedGraph {

  public static void main(String[] args) {

    GraphLinkListNode<Integer> graph = new GraphLinkListNode<>(5);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 2, 1);
    addEdge(graph, 0, 3);
    addEdge(graph, 3, 4);

    if (isCyclic(graph)) {
      System.out.println("Graph contains cycle");
    } else {
      System.out.println("Graph doesn't contain cycle");
    }
  }

  private static boolean isCyclic(GraphLinkListNode<Integer> graph) {
    boolean[] visited = new boolean[graph.getV()];
    for (int i = 0; i < graph.getV(); i++) {
      if (!visited[i]) {
        if (isCyclicUtil(graph, i, visited, -1)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isCyclicUtil(GraphLinkListNode<Integer> graph, int v, boolean[] visited,
      int parent) {
    visited[v] = true;
    List<Integer> adjList = graph.getAdjList().get(v);
    for (int vertex : adjList) {
      if (!visited[vertex]) {
        if (isCyclicUtil(graph, vertex, visited, v)) {
          return true;
        } else if (vertex != parent) {
          return true;
        }
      }
    }
    return false;
  }

  private static void addEdge(GraphLinkListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
    graph.getAdjList().get(v).add(u);
  }
}