package graph;

import graph.GraphType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphArrayListNode<T> implements GraphOperations {

  private final int V;
  private final int E;
  private final List<List<Integer>> adjList;
  private final List<List<AdjacentNode>> adjNodeList;

  public GraphArrayListNode(int v) {
    this.V = v;
    this.E = Integer.MAX_VALUE;
    this.adjList = new ArrayList<>();
    this.adjNodeList = new ArrayList<>();

    for (int i = 0; i < v; i++) {
      adjList.add(new LinkedList<>());
    }
  }

  public GraphArrayListNode(int v, GraphType graphType) {
    this.V = v;
    this.E = Integer.MAX_VALUE;
    this.adjList = new ArrayList<>();
    this.adjNodeList = new ArrayList<>();

    for (int i = 0; i < v; i++) {
      adjNodeList.add(new LinkedList<AdjacentNode>());
    }
  }

  public int getV() {
    return V;
  }

  public int getE() {
    return E;
  }

  public List<List<Integer>> getAdjList() {
    return adjList;
  }

}
