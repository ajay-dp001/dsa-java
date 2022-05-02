package bstree;

import btree.Node;
import java.util.Stack;

public class BSTFromPostOrderTraversal {

  public static void main(String[] args) {
    int[] postorder = {8, 12, 10, 16, 25, 20, 15};
    Node root = constructBST(postorder, 0, postorder.length - 1);
    System.out.print("Inorder traversal of BST is ");
    // inorder on the BST always returns a sorted sequence
    inorder(root);

  }

  private static void inorder(Node root) {
    if (root != null) {
      inorder(root.left);
      System.out.print(root.key + " ");
      inorder(root.right);
    }
  }

  private static Node constructBST(int[] postorder, int start, int end) {
    if (start > end) {
      return null;
    }
    Node node = new Node(postorder[end]);
    int i = 0;
    for (i = end-1; i >= start; i--) {
      if (postorder[i] < node.key) {
        break;
      }
    }
    node.left = constructBST(postorder, start, i);
    node.right = constructBST(postorder, i + 1, end - 1);
    return node;
  }
}
