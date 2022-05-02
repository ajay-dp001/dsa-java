package AAAFinalPrep.btree;

import btree.Node;

public class RightAndLeftLeavesSum {

  public static int sumLeft = 0, sumRight = 0;

  public static void main(String[] args) {
    //construct binary tree
    Node root = new Node(20);
    root.left = new Node(9);
    root.right = new Node(49);
    root.left.right = new Node(12);
    root.left.left = new Node(5);
    root.right.left = new Node(23);
    root.right.right = new Node(52);
    root.left.right.right = new Node(12);
    root.right.right.left = new Node(50);
    rightLeafSum(root);
    System.out.println(sumLeft);
    System.out.println(sumRight);
  }

  private static void rightLeafSum(Node node) {
    if (node != null) {
      if (node.left != null) {
        if (node.left.left == null && node.left.right == null) {
          sumLeft += node.key;
        }
      }
      if (node.right!=null){
        if (node.left.right == node && node.left.left == null) {
          sumRight += node.key;
        }
      }

    }
    rightLeafSum(node.left);
    rightLeafSum(node.right);
  }

}
