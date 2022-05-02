package bstree;

import btree.Node;

public class CheckBinaryTreeIfBSTOrNot {

  public static void main(String[] args) {
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(5);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    preOrder(root);
    if (isBST(root)) {
      System.out.println("IS BST");
    } else {
      System.out.println("Not a BST");
    }

    Node root1 = new Node(5);
    root1.left = new Node(1);
    root1.right = new Node(6);

    root1.right.left = new Node(4);
    root1.right.right = new Node(8);
    System.out.println("Check is BST : " + isValidBSTCheck(root1));
  }

  private static void preOrder(Node node) {
    if (node != null) {
      System.out.print(node.key + " ");
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  private static boolean isBST(Node root) {
    return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean isBSTUtil(Node node, int min, int max) {
    if (node == null) {
      return true;
    }
    if (node.key < min || node.key > max) {
      return false;
    }
    return isBSTUtil(node.left, min, node.key - 1) && isBSTUtil(node.right, node.key + 1, max);
  }


  private static boolean isValidBSTCheck(Node node) {
    return validateBST(node, null, null);
  }

  private static boolean validateBST(Node node, Integer low, Integer high) {
    if (node == null) {
      return true;
    }
    if ((low != null && node.key <= low) || (high != null && node.key >= high)) {
      return false;
    }
    return validateBST(node.left, low, node.val) && validateBST(node.right, node.val, high);
  }

}
