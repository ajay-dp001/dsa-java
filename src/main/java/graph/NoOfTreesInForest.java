package graph;

import java.util.List;

public class NoOfTreesInForest {

  public static void main(String[] args) {
    GraphLinkListNode<Integer> graph = new GraphLinkListNode<>(5);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 3, 4);
    System.out.println("Count Num of Trees: " + countTrees(graph));
  }

  //Time Complexity : O(V + E)
  private static int countTrees(GraphLinkListNode<Integer> graph) {
    boolean[] isVisited = new boolean[graph.getV()];
    int res = 0;
    for (int i = 0; i < graph.getV(); i++) {
      if (!isVisited[i]) {
        dfsUtil(graph, i, isVisited);
        res++;
      }
    }
    return res;
  }

  private static void dfsUtil(GraphLinkListNode<Integer> graph, int v, boolean[] isVisited) {
    isVisited[v] = true;
    List<Integer> verticesList = graph.getAdjList().get(v);
    for (int vertex : verticesList) {
      if (!isVisited[vertex]) {
        dfsUtil(graph, vertex, isVisited);
      }
    }
  }

  private static void addEdge(GraphLinkListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
  }

}
