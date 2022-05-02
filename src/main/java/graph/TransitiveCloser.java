package graph;

import java.util.Arrays;

//O(V2)
public class TransitiveCloser {

  private static int[][] transitiveClosureMatrix;

  public static void main(String[] args) {
    transitiveClosureMatrix = new int[4][4];
    GraphLinkListNode<Integer> graph = new GraphLinkListNode<>(4);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 1, 2);
    addEdge(graph, 2, 0);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 3);
    graph.printGraph(graph.getAdjList());
    System.out.println("Transitive closure Matrix is");

    transitiveClosure(graph, graph.getV());
  }

  private static void transitiveClosure(GraphLinkListNode<Integer> graph, int vertices) {
    for (int i = 0; i < vertices; i++) {
      dfs(graph, i, i);
    }
    for (int i = 0; i < vertices; i++) {
      System.out.println(Arrays.toString(transitiveClosureMatrix[i]));
    }
  }

  private static void dfs(GraphLinkListNode<Integer> graph, int n, int v) {
    if (n == v) {
      if (graph.getAdjList().get(v).contains(v)) {
        transitiveClosureMatrix[n][v] = 1;
      }
    } else {
      transitiveClosureMatrix[n][v] = 1;
    }

    for (int adj : graph.getAdjList().get(v)) {
      if (transitiveClosureMatrix[n][adj] == 0) {
        dfs(graph, n, adj);
      }
    }
  }

  private static void addEdge(GraphLinkListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
  }

}
