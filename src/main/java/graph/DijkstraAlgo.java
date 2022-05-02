package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DijkstraAlgo {

  private static class Node implements Comparator<Node> {

    int v;
    int weight;

    public Node(int v, int weight) {
      this.v = v;
      this.weight = weight;
    }

    public int getV() {
      return this.v;
    }

    public int getWeight() {
      return this.weight;
    }

    @Override
    public int compare(Node n1, Node n2) {
      if (n1.weight < n2.weight) {
        return -1;
      } else if (n1.weight > n2.weight) {
        return 1;
      } else {
        return 0;
      }
    }
  }

  public static void main(String[] args) {
    int n = 5;
    List<List<Node>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    adj.get(0).add(new Node(1, 2));
    adj.get(1).add(new Node(0, 2));

    adj.get(1).add(new Node(2, 4));
    adj.get(2).add(new Node(1, 4));

    adj.get(0).add(new Node(3, 1));
    adj.get(3).add(new Node(0, 1));

    adj.get(3).add(new Node(2, 3));
    adj.get(2).add(new Node(3, 3));

    adj.get(1).add(new Node(4, 5));
    adj.get(4).add(new Node(1, 5));

    adj.get(2).add(new Node(4, 1));
    adj.get(4).add(new Node(2, 1));

    shortestPath(0, adj, n);
  }

  public static void shortestPath(int src, List<List<Node>> adj, int numOfVertices) {
    int[] dist = new int[numOfVertices];
    for (int i = 0; i < numOfVertices; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[src] = 0;

    Queue<Node> pq = new LinkedList<>();
    pq.add(new Node(src, 0));

    while (!pq.isEmpty()) {
      Node tempNode = pq.poll();

      for (Node it : adj.get(tempNode.getV())) {
        if (dist[tempNode.getV()] + it.getWeight() < dist[it.getV()]) {
          dist[it.getV()] = dist[tempNode.getV()] + it.getV();
          pq.add(new Node(it.getV(), dist[it.getV()]));
        }
      }
    }

    for (int i = 0; i < numOfVertices; i++) {
      System.out.println(dist[i] + " ");
    }
  }

}
