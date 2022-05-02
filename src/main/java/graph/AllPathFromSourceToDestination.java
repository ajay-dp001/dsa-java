package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPathFromSourceToDestination {

  public static void main(String[] args) {
    GraphLinkListNode<Integer> graph = new GraphLinkListNode<>(4);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 0, 3);
    addEdge(graph, 2, 0);
    addEdge(graph, 2, 1);
    addEdge(graph, 1, 3);

    //Source, dest
    int src = 2, dest = 3;
    System.out.println("All different paths from source to dest..");
    pritnAllDiffPath(graph, 2, 3);
    checkIfPathExist(graph, 2, 3);

    int start = 0;
    Set<Integer> visitedSet = new HashSet<>();
    hamiltonian(graph, start, visitedSet, start + "", start);
  }

  private static void pritnAllDiffPath(GraphLinkListNode<Integer> graph, int src, int dst) {
    boolean[] visited = new boolean[graph.getV()];

    List<Integer> pathList = new ArrayList<>();
    pathList.add(src);

    pritnAllDiffPathUtil(graph, src, dst, visited, pathList);
  }

  private static void pritnAllDiffPathUtil(GraphLinkListNode<Integer> graph, int src, int dst,
      boolean[] visited, List<Integer> pathList) {
    if (src == dst) {
      System.out.println(pathList);
      return;
    }

    visited[src] = true;
    List<Integer> adjList = graph.getAdjList().get(src);
    for (int adjNode : adjList) {
      if (!visited[adjNode]) {
        pathList.add(adjNode);
        pritnAllDiffPathUtil(graph, adjNode, dst, visited, pathList);
        pathList.remove(Integer.valueOf(adjNode));
      }
    }
    visited[src] = false;
  }

  private static void addEdge(GraphLinkListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
  }

  private static void checkIfPathExist(GraphLinkListNode<Integer> graph, int src, int dst) {
    boolean[] visited = new boolean[graph.getV()];
    System.out.println("Path Exist : " + checkIfPathExistUtil(graph, src, dst, visited));
  }

  private static boolean checkIfPathExistUtil(GraphLinkListNode<Integer> graph, int src, int dst,
      boolean[] visited) {
    if (src == dst) {
      return true;
    }

    visited[src] = true;
    List<Integer> adjList = graph.getAdjList().get(src);
    for (int adjNode : adjList) {
      if (!visited[adjNode]) {
        return checkIfPathExistUtil(graph, adjNode, dst, visited);
      }
    }
    return false;
  }

  private static void hamiltonian(GraphLinkListNode<Integer> graph, int src, Set<Integer> visitedSet,
      String psf, int orgSrc) {

    if (visitedSet.size() == graph.getV() - 1) {
      boolean closingEdge = false;
      List<Integer> adjList = graph.getAdjList().get(src);
      for (int adjNode : adjList) {
        if (adjNode == orgSrc) {
          closingEdge = true;
          break;
        }
      }
      if (closingEdge) {
        System.out.println("Hamiltonian Cycle Exist : *");
      } else {
        System.out.println("Hamiltonian Path Exist : #");
      }
      return;
    }

    visitedSet.add(src);
    List<Integer> adjList = graph.getAdjList().get(src);
    for (int adjNode : adjList) {
      if (!visitedSet.contains(adjNode)) {
        hamiltonian(graph, adjNode, visitedSet, psf + adjNode, orgSrc);
      }
    }
    visitedSet.remove(src);
  }
}
