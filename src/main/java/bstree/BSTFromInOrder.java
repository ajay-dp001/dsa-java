package bstree;

import btree.Node;

public class BSTFromInOrder {

  public static void main(String[] args) {
    int[] inOrder = {1, 2, 3, 4, 5, 6, 7};
    int len = inOrder.length;
    Node node = constructBSTFromINOrder(inOrder, 0, len - 1);
    preorder(node);
  }

  private static Node constructBSTFromINOrder(int[] arr, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    Node node = new Node(arr[mid]);
    node.left = constructBSTFromINOrder(arr, start, mid - 1);
    node.right = constructBSTFromINOrder(arr, mid + 1, end);
    return node;
  }

  public static void preorder(Node node) {
    if (node != null) {
      System.out.print(node.key + " ");
      preorder(node.left);
      preorder(node.right);
    }
  }

}
