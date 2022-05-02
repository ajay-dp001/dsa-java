package bstree;

import btree.Node;

public class KthSmallestElement {

  public static void main(String[] args) {
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(5);
    root.left.left = new Node(1);
    root.left.right = new Node(3);

    System.out.println(kthSmallestElem(root, 3));
  }

  private static int kthSmallestElem(Node node, int k) {
    int[] nums = new int[2];
    inOrder(node, nums, k);
    return nums[1];
  }

  private static void inOrder(Node node, int[] nums, int k) {
    if (node == null) {
      return;
    }
    inOrder(node.left, nums, k);
    if (++nums[0] == k) {
      nums[1] = node.key;
      return;
    }
    inOrder(node.right, nums, k);
  }

}
