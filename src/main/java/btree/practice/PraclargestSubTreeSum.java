package btree.practice;

import btree.Node;

public class PraclargestSubTreeSum {

  static int max_sum = 0;

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
    if (node == null) {
      return 0;
    }
    int curr_sum = node.key + findLargestSubtreeSum(node.left) + findLargestSubtreeSum(node.right);
    max_sum = Math.max(max_sum, curr_sum);
    return curr_sum;
  }
}
