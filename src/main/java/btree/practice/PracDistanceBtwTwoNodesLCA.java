package btree.practice;

import btree.Node;

public class PracDistanceBtwTwoNodesLCA {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);

    System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));
    System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));
  }

  private static int findDistance(Node root, int nodeAval, int nodeBval) {
    Node lcaNode = lca(root, nodeAval, nodeBval);
    System.out.println("Lca-1 : " + lcaNode.key);
    int d1 = findLevel(lcaNode, nodeAval, 0);
    int d2 = findLevel(lcaNode, nodeBval, 0);
    return d1 + d2;
  }

  private static int findLevel(Node lcaNode, int val, int level) {
    if (lcaNode == null) {
      return -1;
    }
    if (lcaNode.key == val) {
      return level;
    }
    int left = findLevel(lcaNode.left, val, level + 1);
    if (left == -1) {
      return findLevel(lcaNode.right, val, level + 1);
    }
    return left;
  }

  private static Node lca(Node node, int nodeAval, int nodeBval) {
    if (node == null) {
      return null;
    }
    if (node.key == nodeAval || node.key == nodeBval) {
      return node;
    }
    Node left = lca(node.left, nodeAval, nodeBval);
    Node right = lca(node.right, nodeAval, nodeBval);

    if (left != null && right != null) {
      return node;
    }
    if (left == null && right == null) {
      return null;
    }
    if (left != null) {
      return lca(node.left, nodeAval, nodeBval);
    } else {
      return lca(node.right, nodeAval, nodeBval);
    }
  }
}
