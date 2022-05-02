package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.checkerframework.checker.units.qual.A;

public class FindConnectedComponent {

  public static void main(String[] args) {
    GraphLinkListNode<AdjacentNode> graph = new GraphLinkListNode<>(7, GraphType.WEIGHTED);
    addEdge(graph, 0, 1, 10);
    addEdge(graph, 2, 3, 10);
    addEdge(graph, 4, 5, 10);
    addEdge(graph, 5, 6, 10);
    addEdge(graph, 4, 6, 10);
    int src = 0;
    connectedComponents(graph, src);
  }

  private static void connectedComponents(GraphLinkListNode<AdjacentNode> graph, int v) {
    boolean[] visited = new boolean[graph.getV()];
    List<List<Integer>> listList = new ArrayList<>();

    for (int vtx = 0; vtx < graph.getV(); vtx++) {
      if (!visited[vtx]) {
        List<Integer> list = new ArrayList<>();
        connectedComponentsUtils(graph, vtx, list, visited);
        listList.add(list);
      }
    }
    System.out.println(listList);
    // Find Friend pairs such that no two Friends in same group match.
    int pairs = 0;
    for (int i = 0; i < listList.size(); i++) {
      for (int j = i + 1; j < listList.size(); j++) {
        int cnt = listList.get(i).size() * listList.get(j).size();
        pairs += cnt;
      }
    }
    System.out.println(pairs);
  }

  private static void connectedComponentsUtils(GraphLinkListNode<AdjacentNode> graph, int vertex,
      List<Integer> list, boolean[] visited) {
    visited[vertex] = true;
    list.add(vertex);

    List<AdjacentNode> adjList = graph.getAdjNodeList().get(vertex);
    for (AdjacentNode adjNode : adjList) {
      if (!visited[adjNode.getV()]) {
        connectedComponentsUtils(graph, adjNode.getV(), list, visited);
      }
    }
  }

  public static void addEdge(GraphLinkListNode<AdjacentNode> graph, int u, int v, int weight) {
    final AdjacentNode adjNode = new AdjacentNode(v, weight);
    graph.getAdjNodeList().get(u).add(adjNode);
  }
}
