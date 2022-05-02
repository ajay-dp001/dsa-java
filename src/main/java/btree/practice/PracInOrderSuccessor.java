package btree.practice;

import btree.Node;

public class PracInOrderSuccessor {

  private static class PreviousNode {

    Node node;

    public PreviousNode() {
      this.node = null;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    inOrderSuccessor(root, new PreviousNode(), 4);
  }

  private static void inOrderSuccessor(Node node, PreviousNode prv, int k) {
    if (node.right != null) {
      inOrderSuccessor(node.right, prv, k);
    }
    if (node.key == k) {
      System.out.println("InOrder Successor is :" + (prv != null ? prv.node.key : null));
    }
    prv.node = node;
    if (node.left != null) {
      inOrderSuccessor(node.left, prv, k);
    }
  }

}
