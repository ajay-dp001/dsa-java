package AAAMSPrepare.graph;

import graph.AdjacentNode;
import graph.GraphLinkListNode;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import org.checkerframework.checker.units.qual.A;

public class DetectCycle {

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
    findConnectedComponets(graph);

    detectCycleInDirectedGraph(graph);

  }

  private static void topoSortUtil(GraphLinkListNode<Integer> graph, int v, boolean[] visistd,
      Stack<Integer> stack){
    visistd[v] = true;
    List<Integer> adjList =  graph.getAdjList().get(v);

    stack.add(v);
  }

  private static boolean detectCycleInDirectedGraph(GraphLinkListNode<Integer> graph) {
    boolean[] visisted = new boolean[graph.getV()];
    boolean[] dfsVisted = new boolean[graph.getV()];

    for (int i = 0; i < graph.getV(); i++) {
      if (isCyclicDirectedGraph(graph, i, visisted, dfsVisted)) {
        return true;
      }
    }
    return false;
  }

  private static boolean isCyclicDirectedGraph(GraphLinkListNode<Integer> graph, int v, boolean[] visisted,
      boolean[] dfsVisited) {
    if (dfsVisited[v]) {
      return true;
    }
    if (visisted[v]) {
      visisted[v] = false;
    }
    visisted[v] = true;
    dfsVisited[v] = true;
    List<Integer> list = graph.getAdjList().get(v);
    for (int vertex : list) {
      if (isCyclicDirectedGraph(graph, vertex, visisted, dfsVisited)) {
        return true;
      }
    }
    dfsVisited[v] = false;
    return false;
  }

  private static void findConnectedComponets(GraphLinkListNode<Integer> graph) {
    boolean[] visited = new boolean[graph.getV()];
    List<List<Integer>> listList = new ArrayList<>();

    for (int i = 0; i < graph.getV(); i++) {
      if (!visited[i]) {
        List<Integer> list = new ArrayList<>();
        findConnectedComponetsUtil(graph, i, visited, list);
        listList.add(list);
      }
    }
  }

  private static void findConnectedComponetsUtil(GraphLinkListNode<Integer> graph, int v, boolean[] visited,
      List<Integer> list) {
    visited[v] = true;
    list.add(v);
    List<Integer> adjList = graph.getAdjList().get(v);
    for (int vertex : adjList) {
      if (!visited[vertex]) {
        findConnectedComponetsUtil(graph, vertex, visited, list);
      }
    }
  }

  private static boolean isCyclicUtil(GraphLinkListNode<Integer> graph, int v, boolean[] visited,
      int parent) {
    visited[v] = true;
    List<Integer> adjNode = graph.getAdjList().get(v);
    for (int vertex : adjNode) {
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

  private static void addEdge(GraphLinkListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
    graph.getAdjList().get(v).add(u);
  }

}
