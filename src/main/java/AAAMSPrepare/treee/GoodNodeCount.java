package AAAMSPrepare.treee;

import btree.Node;

public class GoodNodeCount {

  private static int count = 0;

  public static void main(String[] args) {
    Node root = new Node(3);
    root.left = new Node(1);
    root.right = new Node(4);
    root.left.left = new Node(3);
    root.right.left = new Node(1);
    root.right.right = new Node(5);
    int result = goodNodes(root);
  }

  public static int goodNodes(Node node) {
    goodNodesCntUtil(node, node.key);
    return count;
  }

  private static void goodNodesCntUtil(Node node, int max) {
    if (node == null) {
      return;
    }
    if (node.key >= max) {
      max = node.key;
      count++;
    }
    goodNodesCntUtil(node.left, max);
    goodNodesCntUtil(node.right, max);
  }

}
