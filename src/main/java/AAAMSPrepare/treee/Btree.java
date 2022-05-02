package AAAMSPrepare.treee;

import btree.Node;

public class Btree {

  static int dia = 0;

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.left.right = new Node(14);
    root.left.left.right.right = new Node(15);
    root.left.left.right.right.right = new Node(16);
    root.left.right = new Node(5);

    System.out.println("Height of tree is : " + maxDepth(root));
    diameter(root);
    System.out.println("The diameter of given binary tree is : " + dia);

    System.out.println("B Tree i Balanced :" + checkIfBalanced(root));
  }

  private static int checkIfBalanced(Node node) {
    if (node == null) {
      return 0;
    }
    int left_height = checkIfBalanced(node.left);
    if (left_height == -1) {
      return -1;
    }
    int right_height = checkIfBalanced(node.right);
    if (right_height == -1) {
      return -1;
    }
    if (Math.abs(left_height - right_height) > 1) {
      return -1;
    }
    return Math.max(left_height, right_height) + 1;
  }

  private static int maxDepth(Node node) {
    if (node == null) {
      return 0;
    }
    int left_depth = maxDepth(node.left);
    int right_depth = maxDepth(node.right);

    return Math.max(left_depth, right_depth) + 1;
  }

  private static int diameter(Node node) {
    if (node == null) {
      return 0;
    }
    int left_depth = maxDepth(node.left);
    int right_depth = maxDepth(node.right);

    dia = Math.max(dia, left_depth + right_depth);
    return Math.max(left_depth, right_depth) + 1;
  }
}
