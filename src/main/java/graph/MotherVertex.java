package graph;

import java.util.List;

public class MotherVertex {

  public static void main(String[] args) {
    GraphArrayListNode<Integer> graph = new GraphArrayListNode<>(7);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 4, 1);
    addEdge(graph, 6, 4);
    addEdge(graph, 5, 6);
    addEdge(graph, 5, 2);
    addEdge(graph, 6, 0);

    System.out.println("The mother vertex is " + motherVertex(graph, graph.getV()));
  }

  private static int motherVertex(GraphArrayListNode<Integer> graph, int V) {
    boolean[] isVisited = new boolean[V];

    //To Store last finished Vertex
    int last_vertex = -1;
    for (int i = 0; i < V; i++) {
      if (!isVisited[i]) {
        dfsUtil(graph, i, isVisited);
        last_vertex = i;
      }
    }

    boolean[] check = new boolean[V];
    dfsUtil(graph, last_vertex, check);
    for (boolean val : check) {
      if (!val) {
        return -1;
      }
    }
    return last_vertex;
  }

  private static void dfsUtil(GraphArrayListNode<Integer> graph, int v, boolean[] visited) {
    visited[v] = true;
    List<Integer> vertices_list = graph.getAdjList().get(v);
    for (int vertex : vertices_list) {
      if (!visited[vertex]) {
        dfsUtil(graph, vertex, visited);
      }
    }
  }

  private static void addEdge(final GraphArrayListNode<Integer> graph, int u, int v) {
    graph.getAdjList().get(u).add(v);
  }
}
