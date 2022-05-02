package btree;

public class RootToLeafPathEqualToGivenSum {

  static int pathSum = 21;
  static int reqSum = 21;

  public static void main(String[] args) {
    int sum = 21;
    Node root = new Node(10);
    root.left = new Node(8);
    root.right = new Node(2);
    root.left.left = new Node(3);
    root.left.right = new Node(5);
    root.right.left = new Node(2);

    if (hasPathSum(root, sum)) {
      System.out.println("There is a root to leaf path with sum " + sum);
    } else {
      System.out.println("There is no root to leaf path with sum " + sum);
    }
    System.out.println(hasPathNew(root, 0));
  }

  private static boolean hasPathSum(Node node, int sum) {
    boolean result = false;
    int subSum = sum - node.key;
    if (subSum == 0 & node.left == null && node.right == null) {
      return true;
    }
    if (node.left != null) {
      result = result || hasPathSum(node.left, subSum);
    }
    if (node.right != null) {
      result = result || hasPathSum(node.right, subSum);
    }
    return result;
  }

  private static boolean hasPathNew(Node node, int sum) {
    if (node == null) {
      if (reqSum == sum) {
        return true;
      }
      return false;
    }
    return hasPathNew(node.left, sum + node.key) || hasPathNew(node.right, sum + node.key);
  }
}
