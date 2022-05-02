package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphLinkListNode<T> implements GraphOperations {

  private final int V;
  private final GraphType graphType;
  private final List<List<Integer>> adjList;
  private final List<List<Integer>> transposeList;
  private final List<List<AdjacentNode>> adjNodeList;

  public GraphLinkListNode(int numOfVertices) {
    this.V = numOfVertices;
    this.adjList = new LinkedList<>();
    this.adjNodeList = new LinkedList<>();
    this.transposeList = new LinkedList<>();
    this.graphType = GraphType.NON_WEIGHTED;

    for (int i = 0; i < numOfVertices; i++) {
      adjList.add(new LinkedList<>());
      transposeList.add(new LinkedList<>());
    }
  }

  public GraphLinkListNode(int numOfVertices, GraphType graphType) {
    this.V = numOfVertices;
    this.graphType = graphType;
    this.adjList = new ArrayList<>();
    this.adjNodeList = new ArrayList<>();
    this.transposeList = new LinkedList<>();

    for (int i = 0; i < numOfVertices; i++) {
      adjNodeList.add(new LinkedList<AdjacentNode>());
    }
  }

  public int getV() {
    return V;
  }

  public List<List<Integer>> getAdjList() {
    return adjList;
  }

  public List<List<AdjacentNode>> getAdjNodeList() {
    return adjNodeList;
  }

  public List<List<Integer>> getTransposeList() {
    return transposeList;
  }
}
