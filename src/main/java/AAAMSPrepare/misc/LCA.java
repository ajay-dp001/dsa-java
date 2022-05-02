package AAAMSPrepare.misc;

import btree.Node;

public class LCA {

  static Node root;

  public static void main(String[] args) {
    int nodeA = 12;
    int nodeB = 32;
    lca(root, nodeA, nodeB);
  }

  public static Node lca(Node node, int nodeA, int nodeB) {
    if (node == null) {
      return null;
    }
    if (node.key == nodeA || node.key == nodeB) {
      return node;
    }
    Node left = lca(node.left, nodeA, nodeB);
    Node right = lca(node.right, nodeA, nodeB);

    if (left != null && right != null) {
      return node;
    }
    return left != null ? left : right;
  }

}
