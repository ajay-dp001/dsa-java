package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

  public static void main(String[] args) {
    int vertices = 5;

    List<List<Integer>> adjList = new ArrayList<>();
    List<List<Integer>> tansposeList = new ArrayList<>();

    for (int i = 0; i < vertices; i++) {
      adjList.add(new ArrayList<>());
    }

    for (int i = 0; i < vertices; i++) {
      tansposeList.add(new ArrayList<>());
    }

    /*//Adding Edges one by one
    adjEdge(adjList, 0, 1);
    adjEdge(adjList, 0, 4);
    adjEdge(adjList, 1, 2);
    adjEdge(adjList, 1, 3);
    adjEdge(adjList, 1, 4);
    adjEdge(adjList, 2, 3);
    adjEdge(adjList, 3, 4);*/

    adjEdge(adjList, tansposeList, 0, 1);
    adjEdge(adjList, tansposeList, 0, 4);
    adjEdge(adjList, tansposeList, 0, 3);
    adjEdge(adjList, tansposeList, 2, 0);
    adjEdge(adjList, tansposeList, 3, 2);
    adjEdge(adjList, tansposeList, 4, 1);
    adjEdge(adjList, tansposeList, 4, 3);

    printGraph(adjList);
    System.out.println();
    printGraph(tansposeList);
  }

  private static void printGraph(List<List<Integer>> adjList) {
    for (int i = 0; i < adjList.size(); i++) {
      System.out.println("Adjacency List of Vertex : " + i);
      System.out.print("HEAD ");
      for (int j = 0; j < adjList.get(i).size(); j++) {
        System.out.print("->" + adjList.get(i).get(j));
      }
      System.out.println();
    }
  }

  private static void adjEdge(List<List<Integer>> adjList, List<List<Integer>> tansposeList, int u, int v) {
    adjList.get(u).add(v);
    adjList.get(v).add(u);
    tansposeList.get(v).add(u);
  }

}
