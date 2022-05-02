package AAAFinalPrep.btree;

import btree.Node;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(11);
    root.right.left.left = new Node(12);
    root.right.left.right = new Node(13);
    root.right.right.left = new Node(14);
    root.right.right.right = new Node(15);
    Node node = invertBTree(root);
    printLevel(node);
  }

  private static void printLevel(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      Node tempNode = queue.poll();
      System.out.print(tempNode.key + " ");
      if (tempNode.left != null) {
        queue.add(tempNode.left);
      }
      if (tempNode.right != null) {
        queue.add(tempNode.right);
      }
    }
  }

  private static Node invertBTree(Node node) {
    if (node == null) {
      return null;
    }
    Node left = invertBTree(node.left);
    Node right = invertBTree(node.right);

    node.left = right;
    node.right = left;
    return node;
  }

}
