package AAAFinalPrep.btree;

import btree.Node;

public class SumLongestRootToLeafPath {

  static int max_sum = Integer.MAX_VALUE;
  static int max_len = 0;

  public static void main(String[] args) {
    BTNode root = new BTNode(4);       /*        4        */
    root.left = new BTNode(2);         /*       /  \       */
    root.right = new BTNode(5);        /*      2    5      */
    root.left.left = new BTNode(7);    /*     / \  / \     */
    root.left.right = new BTNode(1);  /*    7   1 2  3    */
    root.right.left = new BTNode(2);   /*      /          */
    root.right.right = new BTNode(3);  /*     1           */
    root.left.right.left = new BTNode(1);
    System.out.println("Sum = " + sumOfLongRootToLeafPath(root));
  }

  private static int sumOfLongRootToLeafPath(BTNode root) {
    if (root == null) {
      return 0;
    }
    sumOfLongRootToLeafPathUtilBTUtil(root, 0, 0);
    return max_sum;
  }

  private static void sumOfLongRootToLeafPathUtilBTUtil(BTNode node, int sum, int len) {
    if (node == null) {
      if (max_len < len) {
        max_len = len;
        max_sum = sum;
      } else if (max_len == len && max_sum < sum) {
        max_sum = sum;
      }
      return;
    }
    sumOfLongRootToLeafPathUtilBTUtil(node.left, (sum + node.val), len + 1);
    sumOfLongRootToLeafPathUtilBTUtil(node.right, (sum + node.val), len + 1);
  }

}
