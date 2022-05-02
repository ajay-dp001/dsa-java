package btree;

public class InOrderSuccessor {

  static class PreviousNode {

    Node pNode;

    PreviousNode() {
      pNode = null;
    }
  }

  private static void inOrderSuccessorOfBinaryTree(Node root, PreviousNode pre, int searchNode) {
    if (root.right != null) {
      inOrderSuccessorOfBinaryTree(root.right, pre, searchNode);
    }
    if (root.key == searchNode) {
      System.out.println("InOrderSuccessor of Search Node: " + searchNode + " is :" +
          (pre.pNode != null ? pre.pNode.key : "null"));
    }
    pre.pNode = root;
    if (root.left != null) {
      inOrderSuccessorOfBinaryTree(root.left, pre, searchNode);
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
}
