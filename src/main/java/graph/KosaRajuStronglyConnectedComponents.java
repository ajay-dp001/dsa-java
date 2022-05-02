package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class KosaRajuStronglyConnectedComponents {

  public static void main(String[] args) {
    GraphLinkListNode<Integer> graph = new GraphLinkListNode<>(5);
    addEdge(graph, 1, 0);
    addEdge(graph, 0, 2);
    addEdge(graph, 2, 1);
    addEdge(graph, 0, 3);
    addEdge(graph, 3, 4);

    System.out.println("Following are strongly connected components in given graph ");
    printSCCs(graph);
  }

  private static void printSCCs(GraphLinkListNode<Integer> graph) {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[graph.getV()];

    for (int i = 0; i < graph.getV(); i++) {
      if (!visited[i]) {
        dfs(graph, i, visited, stack);
      }
    }

    boolean[] visitedTransposeAdjList = new boolean[graph.getV()];

    while (!stack.isEmpty()) {
      int v = stack.pop();
      if (!visitedTransposeAdjList[v]) {
        dfsUtil(graph, v, visitedTransposeAdjList);
        System.out.println();
      }
    }
  }

  private static void dfsUtil(GraphLinkListNode<Integer> graph, int v, boolean[] visitedTransposeAdjList) {
    visitedTransposeAdjList[v] = true;
    System.out.print(v + " ");
    List<Integer> vertices = graph.getTransposeList().get(v);
    for (int vertex : vertices) {
      if (!visitedTransposeAdjList[vertex]) {
        dfsUtil(graph, vertex, visitedTransposeAdjList);
      }
    }
  }

  private static void dfs(GraphLinkListNode<Integer> graph, int v, boolean[] visited, Stack<Integer> stack) {
    visited[v] = true;
    List<Integer> vertices = graph.getAdjList().get(v);
    for (int vertex : vertices) {
      if (!visited[vertex]) {
        dfs(graph, vertex, visited, stack);
      }
    }
    stack.push(v);
  }

  private static void addEdge(GraphLinkListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
    graph.getTransposeList().get(v).add(u);
  }

}
