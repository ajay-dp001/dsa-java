package graph;

import java.util.List;

public interface GraphOperations {

  default void printGraph(List<List<Integer>> adjList) {
    for (int i = 0; i < adjList.size(); i++) {
      System.out.println("Adjacency List of Vertex : " + i);
      System.out.print("HEAD ");
      for (int j = 0; j < adjList.get(i).size(); j++) {
        System.out.print("->" + adjList.get(i).get(j));
      }
      System.out.println();
    }
  }

}
