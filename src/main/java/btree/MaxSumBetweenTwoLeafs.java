package btree;

public class MaxSumBetweenTwoLeafs {

  static int maxSumBtwTwoLeaf = 0;

  public static void main(String[] args) {
    Node root = new Node(-15);
    root.left = new Node(5);
    root.right = new Node(6);
    root.left.left = new Node(-8);
    root.left.right = new Node(1);
    root.left.left.left = new Node(2);
    root.left.left.right = new Node(6);
    root.right.left = new Node(3);
    root.right.right = new Node(9);
    root.right.right.right = new Node(0);
    root.right.right.right.left = new Node(4);
    root.right.right.right.right = new Node(-1);
    root.right.right.right.right.left = new Node(10);
    maxPathSumBtwLeafs(root);
    System.out.println("Max pathSum of the given binary tree is " + maxSumBtwTwoLeaf);
  }

  private static int maxPathSumBtwLeafs(Node node) {
    if (node == null) {
      return 0;
    }
    if (node.left == null && node.right == null) {
      return node.key;
    }

    int left = maxPathSumBtwLeafs(node.left);
    int right = maxPathSumBtwLeafs(node.right);

    if (node.left != null && node.right != null) {
      maxSumBtwTwoLeaf = Math.max(maxSumBtwTwoLeaf, left + right + node.key);
      return (Math.max(left, right) + node.key);
    }

    return node.left != null ? left + node.key : right + node.key;
  }
}
