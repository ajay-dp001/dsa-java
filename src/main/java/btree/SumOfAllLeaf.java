package btree;

public class SumOfAllLeaf {

  static int sum = 0;

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right = new Node(3);
    root.right.right = new Node(7);
    root.right.left = new Node(6);
    root.right.left.right = new Node(8);
    leafSum(root);
    System.out.println("Sum is : " + sum);
    sum = 0;
    leafSumNew(root);
    System.out.println("Sum is : " + sum);
  }

  private static void leafSum(Node node) {
    if (node != null) {
      leafSum(node.left);
      if (node.left == null && node.right == null) {
        sum = sum + node.key;
      }
      leafSum(node.right);
    }
  }

  private static void leafSumNew(Node root) {
    if (root == null) {
      return;
    }
    leafSumNew(root.left);
    if (root.left == null && root.right == null) {
      sum += root.key;
    }
    leafSumNew(root.right);

  }
}
