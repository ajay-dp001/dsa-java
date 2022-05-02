package btree;

public class LargestSumSubTree {

  static class INT {

    int val;

    INT(int data) {
      this.val = data;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(-2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(-6);
    root.right.right = new Node(2);

    System.out.println(findLargestSumSubtree(root));
  }

  private static int findLargestSumSubtree(Node root) {
    INT result = new INT(Integer.MIN_VALUE);
    findLargestSumSubtreeUtil(root, result);
    return result.val;
  }

  private static int findLargestSumSubtreeUtil(Node root, INT result) {
    if (root == null) {
      return 0;
    }
    int currSum = root.key + findLargestSumSubtreeUtil(root.left, result)
        + findLargestSumSubtreeUtil(root.right, result);

    result.val = Math.max(result.val, currSum);
    return currSum;
  }
}
