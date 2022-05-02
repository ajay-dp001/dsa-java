package btree;

import AAAFinalPrep.btree.BTNode;

public class SumLongestRootToLeafPath {

  private static int max_len = 0;
  private static int max_sum = Integer.MAX_VALUE;

  public static void main(String[] args) {
    BTNode root = new BTNode(4);       /*        4        */
    root.left = new BTNode(2);         /*       / \       */
    root.right = new BTNode(5);        /*      2   5      */
    root.left.left = new BTNode(7);    /*     / \ / \     */
    root.left.right = new BTNode(1);   /*    7  1 2  3    */
    root.right.left = new BTNode(2);   /*      /          */
    root.right.right = new BTNode(3);  /*     6           */
    root.left.right.left = new BTNode(6);
    System.out.println("Sum = " + sumOfLongRootToLeafPathUtil(root));
  }

  private static int sumOfLongRootToLeafPathUtil(BTNode node) {
    if (node == null) {
      return 0;
    }
    sumOfLongRootToLeafPathBTUtil(node, 0, 0);
    return max_sum;
  }

  private static void sumOfLongRootToLeafPathBTUtil(BTNode node, int sum, int len) {
    if (node == null) {
      if (max_len < len) {
        max_len = len;
        max_sum = sum;
      } else if (max_len == len && max_sum < sum) {
        max_sum = sum;
      }
      return;
    }
    sumOfLongRootToLeafPathBTUtil(node.left, sum + node.val, len + 1);
    sumOfLongRootToLeafPathBTUtil(node.right, sum + node.val, len + 1);
  }
}
