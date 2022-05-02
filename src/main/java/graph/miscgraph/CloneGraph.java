package graph.miscgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/clone-graph/submissions/
public class CloneGraph {

  private static class Node {

    public int val;
    public List<Node> neighbors;

    public Node(int val, List<Node> neighbors) {
      this.val = val;
      this.neighbors = neighbors;
    }
  }

  private static final Map<Integer, Node> map = new HashMap<>();

  public static void main(String[] args) {
    //cloneGraph(node);
  }

  private static Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    if (map.containsKey(node.val)) {
      return map.get(node.val);
    }
    Node clonedNode = new Node(node.val, new ArrayList<>());
    map.put(clonedNode.val, clonedNode);

    for (Node neighbor : node.neighbors) {
      clonedNode.neighbors.add(cloneGraph(neighbor));
    }
    return clonedNode;
  }

}
