package AAAFinalPrep.btree;

import java.util.ArrayList;
import java.util.List;

public class ReplaceNodeWithSumInOrderPredecessorAndSuccessor {

  private static class INT {

    int data;
  }

  public static void main(String[] args) {
    BTNode root = new BTNode(1);
    root.left = new BTNode(2);
    root.right = new BTNode(3);
    root.left.left = new BTNode(4);
    root.left.right = new BTNode(5);
    root.right.left = new BTNode(6);
    root.right.right = new BTNode(7);

    System.out.println("Preorder Traversal before tree modification:");
    preorderTraversal(root);

    replaceNodeWithSum(root);

    System.out.println("\nPreorder Traversal after tree modification:");
    preorderTraversal(root);
  }

  private static void preorderTraversal(BTNode node) {
    if (node == null) {
      return;
    }
    System.out.print(node.val + " ");
    preorderTraversal(node.left);
    preorderTraversal(node.right);
  }

  private static void replaceNodeWithSum(BTNode node) {
    if (node != null) {
      List<Integer> inOrderTraversal = new ArrayList<>();
      inOrderTraversal.add(0);
      storeInOrderTraversal(node, inOrderTraversal);
      inOrderTraversal.add(0);
      INT integer = new INT();
      integer.data = 1;
      replaceNodeWithSum(node, inOrderTraversal, integer);
    }
  }

  private static void storeInOrderTraversal(BTNode node, List<Integer> arr) {
    if (node != null) {
      storeInOrderTraversal(node.left, arr);
      arr.add(node.val);
      storeInOrderTraversal(node.right, arr);
    }
  }

  private static void replaceNodeWithSum(BTNode node, List<Integer> arr, INT integer) {
    if (node != null) {
      replaceNodeWithSum(node.left, arr, integer);
      node.val = arr.get(integer.data - 1) + arr.get(integer.data + 1);
      integer.data++;
      replaceNodeWithSum(node.right, arr, integer);
    }
  }

}
