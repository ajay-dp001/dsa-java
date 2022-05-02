package graph;

import java.util.List;

//https://www.youtube.com/watch?v=0dJmTuMrUZM
public class DetectCycleInDirectedGraph {

  public static void main(String[] args) {
    GraphLinkListNode<Integer> graph = new GraphLinkListNode<>(4);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 1, 2);
    addEdge(graph, 2, 0);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 3);

    if (isCyclic(graph)) {
      System.out.println("Graph contains cycle");
    } else {
      System.out.println("Graph doesn't contain cycle");
    }

    // Without Using Extra dfsVisited Array.
    GraphLinkListNode<Integer> graph1 = new GraphLinkListNode<>(5);
    addEdge(graph1, 0, 1);
    addEdge(graph1, 2, 1);
    addEdge(graph1, 2, 3);
    // Below link creates cycle
    addEdge(graph1, 3, 4);
    addEdge(graph1, 4, 2);
    addEdge(graph1, 4, 1);
    System.out.println("Graph contains cycle :" + isCycleExist(graph1));
  }

  private static boolean isCyclic(GraphLinkListNode<Integer> graph) {
    boolean[] visited = new boolean[graph.getV()];
    boolean[] dfsVisited = new boolean[graph.getV()];

    for (int i = 0; i < graph.getV(); i++) {
      if (isCyclicUtil(graph, i, visited, dfsVisited)) {
        return true;
      }
    }
    return false;
  }

  private static boolean isCyclicUtil(GraphLinkListNode<Integer> graph, int i, boolean[] visited,
      boolean[] dfsVisited) {
    if (dfsVisited[i]) {
      return true;
    }
    if (visited[i]) {
      return false;
    }
    visited[i] = true;
    dfsVisited[i] = true;

    List<Integer> adjList = graph.getAdjList().get(i);
    for (int vertex : adjList) {
      if (isCyclicUtil(graph, vertex, visited, dfsVisited)) {
        return true;
      }
    }
    dfsVisited[i] = false;
    return false;
  }

  private static void addEdge(final GraphLinkListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
  }

  private static boolean isCycleExist(GraphLinkListNode<Integer> graph) {
    boolean[] visited = new boolean[graph.getV()];
    for (int i = 0; i < graph.getV(); i++) {
      visited[i] = true;
      List<Integer> adjList = graph.getAdjList().get(i);
      for (int vertex : adjList) {
        if (isCyclicExistUtil(vertex, visited, graph)) {
          return true;
        }
      }
      visited[i] = false;
    }
    return false;
  }

  private static boolean isCyclicExistUtil(int v, boolean[] visited, GraphLinkListNode<Integer> graph) {
    if (visited[v]) {
      return true;
    }
    visited[v] = true;
    List<Integer> adjList = graph.getAdjList().get(v);
    for (int vertex : adjList) {
      if (isCyclicExistUtil(vertex, visited, graph)) {
        return true;
      }
    }
    visited[v] = false;
    return false;
  }
}
