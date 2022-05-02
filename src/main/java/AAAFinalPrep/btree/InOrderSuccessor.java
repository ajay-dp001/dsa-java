package AAAFinalPrep.btree;

import btree.Node;

public class InOrderSuccessor {

  private static class PreviousNode {

    Node pNode;

    public PreviousNode() {
      this.pNode = null;
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

    // Case 1
    inOrderSuccessorOfBinaryTree(root, new PreviousNode(), 1);

    // Case 2
    inOrderSuccessorOfBinaryTree(root, new PreviousNode(), 4);

    // Case 3
    inOrderSuccessorOfBinaryTree(root, new PreviousNode(), 7);
  }

  private static void inOrderSuccessorOfBinaryTree(Node node, PreviousNode previousNode, int searchNode) {
    if (node.right != null) {
      inOrderSuccessorOfBinaryTree(node.right, previousNode, searchNode);
    }

    if (node.key == searchNode) {
      System.out.println("In Order Successor is:" + ((previousNode.pNode != null) ? previousNode.pNode.key : null));
    }
    previousNode.pNode = node;
    if (node.left != null) {
      inOrderSuccessorOfBinaryTree(node.left, previousNode, searchNode);
    }
  }

}
