package graph;

public class CountAllPossiblePathBetweenTwoVertices {

  public static void main(String[] args) {
    GraphArrayListNode<Integer> graph = new GraphArrayListNode<>(5);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 0, 3);
    addEdge(graph, 1, 3);
    addEdge(graph, 2, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 4);
    int u = 0, v = 3;
    System.out.println(countPath(graph, u, v));

  }

  private static int countPath(GraphArrayListNode<Integer> graph, int u, int v) {
    int pathCount = 0;
    return countPathUtil(graph, u, v, pathCount);
  }

  //Space Complexity: O(1)
  private static int countPathUtil(GraphArrayListNode<Integer> graph, int u, int v, int pathCount) {
    if (u == v) {
      pathCount++;
    }
    for (int vertex : graph.getAdjList().get(u)) {
      pathCount = countPathUtil(graph, vertex, v, pathCount);
    }
    return pathCount;
  }

  private static void addEdge(final GraphArrayListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
  }

}
