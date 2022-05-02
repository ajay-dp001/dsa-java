package AAAMSPrepare.treee;

import btree.Node;

public class CorrectBST {

  public static void main(String[] args) {
        /*   6
            / \
           10  2
          / \ / \
         1  3 7 12

        10 and 2 are swapped
        */

    Node root = new Node(6);
    root.left = new Node(10);
    root.right = new Node(2);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.right = new Node(12);
    root.right.left = new Node(7);

    System.out.println("Inorder Traversal of the original tree");
    printInorder(root);
    correctBST(root);

    System.out.println("Inorder Traversal of the fixed tree");
    printInorder(root);
  }

  static Node prev, first, middle, last;

  private static void correctBST(Node node) {
    prev = first = middle = last = null;
    correctBSTUtil(node);
    if (first != null && last != null) {
      int temp = first.key;
      first.key = last.key;
      last.key = temp;
    } else if (first != null && middle != null) {
      int temp = first.key;
      first.key = middle.key;
      middle.key = temp;
    }
  }

  private static void correctBSTUtil(Node node) {
    if (node == null) {
      return;
    }
    correctBSTUtil(node.left);
    if (prev != null && node.key < prev.key) {
      if (first == null) {
        first = prev;
        middle = node;
      } else {
        last = node;
      }
    }
    prev = node;
    correctBSTUtil(node.right);
  }

  private static void printInorder(Node node) {
    if (node != null) {
      printInorder(node.left);
      System.out.print(node.key + " ");
      printInorder(node.right);
    }
  }
}
