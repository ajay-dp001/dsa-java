package graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {

  public static void main(String[] args) {
    GraphLinkListNode<AdjacentNode> graph = new GraphLinkListNode<>(6, GraphType.WEIGHTED);
    addEdge(graph, 0, 1, 5);
    addEdge(graph, 0, 2, 3);
    addEdge(graph, 1, 3, 6);
    addEdge(graph, 1, 2, 2);
    addEdge(graph, 2, 4, 4);
    addEdge(graph, 2, 5, 2);
    addEdge(graph, 2, 3, 7);
    addEdge(graph, 3, 4, -1);
    addEdge(graph, 4, 5, -2);
    int src = 1;
    shortestPathInDAG(graph, src);
  }

  //Only for DAG
  private static void shortestPathInDAG(GraphLinkListNode<AdjacentNode> topoGraph, int src) {
    Stack<Integer> stack = new Stack<>();

    int[] dist = new int[topoGraph.getV()];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    boolean[] visited = new boolean[topoGraph.getV()];

    for (int i = 0; i < topoGraph.getV(); i++) {
      if (!visited[i]) {
        topoSortUtil(topoGraph, i, visited, stack);
      }
    }

    while (!stack.isEmpty()) {
      int vertex = stack.pop();
      if (dist[vertex] != Integer.MAX_VALUE) {
        List<AdjacentNode> adjNodeList = topoGraph.getAdjNodeList().get(vertex);
        for (AdjacentNode adjNode : adjNodeList) {
          if (dist[adjNode.getV()] > dist[vertex] + adjNode.getWeight()) {
            dist[adjNode.getV()] = dist[vertex] + adjNode.getWeight();
          }
        }
      }
    }

    // Print the calculated shortest distances
    for (int i = 0; i < topoGraph.getV(); i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        System.out.print("INF ");
      } else {
        System.out.print(dist[i] + " ");
      }
    }
  }

  private static void topoSortUtil(GraphLinkListNode<AdjacentNode> topoGraph, int vertex, boolean[] visited,
      Stack<Integer> stack) {
    visited[vertex] = true;
    List<AdjacentNode> adjList = topoGraph.getAdjNodeList().get(vertex);
    for (AdjacentNode vertx : adjList) {
      if (!visited[vertx.getV()]) {
        topoSortUtil(topoGraph, vertx.getV(), visited, stack);
      }
    }
    stack.push(vertex);
  }

  public static void addEdge(GraphLinkListNode<AdjacentNode> graph, int u, int v, int weight) {
    final AdjacentNode adjNode = new AdjacentNode(v, weight);
    graph.getAdjNodeList().get(u).add(adjNode);
  }

}
