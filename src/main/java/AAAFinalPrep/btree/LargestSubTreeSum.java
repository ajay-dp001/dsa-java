package AAAFinalPrep.btree;

import btree.Node;

public class LargestSubTreeSum {

  private static class INT {

    int data;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(-2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(-6);
    root.right.right = new Node(2);
    System.out.println(findLargestSubtreeSum(root));
  }

  private static int findLargestSubtreeSum(Node node) {
    INT result = new INT();
    findLargestSubtreeSumUtil(node, result);
    return result.data;
  }

  private static int findLargestSubtreeSumUtil(Node node, INT result) {
    if (node == null) {
      return 0;
    }
    int curSum = node.key + findLargestSubtreeSumUtil(node.left, result)
        + findLargestSubtreeSumUtil(node.right, result);
    result.data = Math.max(result.data, curSum);
    return curSum;
  }

}
