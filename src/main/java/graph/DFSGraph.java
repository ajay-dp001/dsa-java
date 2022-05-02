package graph;

import java.util.List;
import java.util.Stack;

public class DFSGraph {

  public static void main(String[] args) {
    GraphLinkListNode<Integer> graph = new GraphLinkListNode<>(4);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 1, 2);
    addEdge(graph, 2, 0);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 3);

    GraphLinkListNode<Integer> topoGraph = new GraphLinkListNode<>(6);
    addEdge(topoGraph, 5, 2);
    addEdge(topoGraph, 5, 0);
    addEdge(topoGraph, 4, 0);
    addEdge(topoGraph, 4, 1);
    addEdge(topoGraph, 2, 3);
    addEdge(topoGraph, 3, 1);
    graph.printGraph(topoGraph.getAdjList());

    System.out.println("Topo Sort of Graph is: **********");
    topoSort(topoGraph);

    System.out.print("Following is the DFS (Depth First Traversal): ");
    dfs(graph, 2);

    System.out.println("DFS Iterative -1");
    dfsIterative(graph, 2);

    System.out.println("DFS Iterative covering all Vertex -2");
    //To print all vertices of a graph, call DFS for every unvisited vertex
    dfsIterativeCoverAllUnVisitedVertices(graph, 2);

  }

  private static void topoSortPrac(GraphLinkListNode<Integer> graph) {
    Stack<Integer> stack = new Stack<>();
    boolean[] visitied = new boolean[graph.getV()];

    for (int i = 0; i < graph.getV(); i++) {
      if (!visitied[i]) {
        topoSortUtilprac(graph, i, visitied, stack);
      }
    }

    while (!stack.isEmpty()) {
      System.out.println(stack.pop() + " ");
    }
  }

  private static void topoSortUtilprac(GraphLinkListNode<Integer> graph, int vertex, boolean[] visited,
      Stack<Integer> stack) {
    visited[vertex] = true;
    List<Integer> adjList = graph.getAdjList().get(vertex);
    for (int verte : adjList) {
      if (!visited[verte]) {
        topoSortUtil(graph, verte, visited, stack);
      }
    }
    stack.add(vertex);
  }


  //Only for DAG
  private static void topoSort(GraphLinkListNode<Integer> topoGraph) {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[topoGraph.getV()];

    for (int i = 0; i < topoGraph.getV(); i++) {
      if (!visited[i]) {
        topoSortUtil(topoGraph, i, visited, stack);
      }
    }

    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }

  private static void topoSortUtil(GraphLinkListNode<Integer> topoGraph, int vertex, boolean[] visited,
      Stack<Integer> stack) {
    visited[vertex] = true;
    List<Integer> adjList = topoGraph.getAdjList().get(vertex);
    for (int vertx : adjList) {
      if (!visited[vertx]) {
        topoSortUtil(topoGraph, vertx, visited, stack);
      }
    }
    stack.push(vertex);
  }

  private static void dfsIterativeCoverAllUnVisitedVertices(GraphLinkListNode<Integer> graph, int v) {
    boolean[] visited = new boolean[graph.getV()];
    for (int i = 0; i < graph.getV(); i++) {
      if (!visited[i]) {
        dfsUtil(graph, v, visited);
      }
    }
  }

  private static void dfsIterative(GraphLinkListNode<Integer> graph, int v) {
    boolean[] visited = new boolean[graph.getV()];

    Stack<Integer> stack = new Stack<>();
    stack.push(v);
    while (!stack.isEmpty()) {
      v = stack.pop();
      if (!visited[v]) {
        visited[v] = true;
        System.out.print(v + " ");
      }
      for (int vertex : graph.getAdjList().get(v)) {
        if (!visited[vertex]) {
          stack.push(vertex);
        }
      }
    }
  }

  //Time Complexity O(V+E) where V is number of Vertices & E is number of Edges in graph
  private static void dfs(GraphLinkListNode<Integer> graph, int v) {
    //Space Complexity O(V) (since an extra visited array is needed of size V)
    boolean[] visited = new boolean[graph.getV()];
    dfsUtil(graph, v, visited);

    //For Disconnected Graph
    for (int i = 0; i < graph.getV(); i++) {
      if (!visited[i]) {
        dfsUtil(graph, v, visited);
      }
    }
  }

  private static void dfsUtil(GraphLinkListNode<Integer> graph, int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");

    List<Integer> verticesList = graph.getAdjList().get(v);
    for (int vertex : verticesList) {
      if (!visited[vertex]) {
        dfsUtil(graph, vertex, visited);
      }
    }
  }

  private static void addEdge(GraphLinkListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
  }

}
