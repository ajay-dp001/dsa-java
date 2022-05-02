package btree;

import java.util.ArrayList;
import java.util.List;

public class SumInOrderPredecessorNSuccessor {

  static class INT {

    int data;
  }

  private static void preorderTraversal(Node root) {
    if (root != null) {
      System.out.print(root.key + " ");
      preorderTraversal(root.left);
      preorderTraversal(root.right);
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

    System.out.println("Preorder Traversal before tree modification:");
    preorderTraversal(root);

    replaceNodeWithSum(root);

    System.out.println("\nPreorder Traversal after tree modification:");
    preorderTraversal(root);
  }

  private static void storeInOrderTraversal(Node root, List<Integer> arr) {
    if (root != null) {
      storeInOrderTraversal(root.left, arr);
      arr.add(root.key);
      storeInOrderTraversal(root.right, arr);
    }
  }

  private static void replaceNodeWithSum(Node root) {
    if (root != null) {
      List<Integer> list = new ArrayList<>();
      list.add(0);
      storeInOrderTraversal(root, list);
      list.add(0);
      INT integer = new INT();
      integer.data = 1;
      replaceNodeSum(root, list, integer);
    }
  }

  private static void replaceNodeSum(Node node, List<Integer> arr, INT intType) {
    if (node != null) {
      replaceNodeSum(node.left, arr, intType);
      node.key = arr.get(intType.data - 1) + arr.get(intType.data + 1);
      intType.data++;
      replaceNodeSum(node.right, arr, intType);
    }
  }
}
