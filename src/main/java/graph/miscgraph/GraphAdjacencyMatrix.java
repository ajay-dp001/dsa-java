package graph.miscgraph;

import java.util.Arrays;

public class GraphAdjacencyMatrix {

  private int size;
  private int[][] adjacencyMatrix;

  public GraphAdjacencyMatrix(final int size) {
    this.size = size;
    adjacencyMatrix = new int[size][size];
    for (int[] rows : adjacencyMatrix) {
      Arrays.fill(rows, Integer.MIN_VALUE);
    }
  }

  public static void main(String[] args) {
    GraphAdjacencyMatrix adjMatrix = new GraphAdjacencyMatrix(5);
    for (int[] rows : adjMatrix.adjacencyMatrix) {
      for (int rowIdx:rows){
        System.out.print(rowIdx);
      }
      System.out.println();
    }
  }
}
