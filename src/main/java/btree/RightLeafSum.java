package btree;

public class RightLeafSum {

  static int sumLeft;
  static int sumRight;

  public static void main(String[] args) {
    //construct binary tree
    Node root = new Node(20);
    root.left = new Node(9);
    root.right = new Node(49);
    root.left.right = new Node(12);
    root.left.left = new Node(5);
    root.left.left.right = new Node(15);
    root.right.left = new Node(23);
    root.right.right = new Node(52);
    root.left.right.right = new Node(12);
    root.right.right.left = new Node(50);
    rightLeafSum(root);
    System.out.println(sumLeft);
    System.out.println(sumRight);

  }

  private static void rightLeafSum(Node root) {
    if (root != null) {
      if (root.right != null) {
        if (root.right.left == null && root.right.right == null) {
          sumRight += root.right.key;
        }
      }
      if (root.left != null) {
        if (root.left.left == null && root.left.right == null) {
          sumLeft += root.left.key;
        }
      }
      rightLeafSum(root.left);
      rightLeafSum(root.right);
    }
  }

}
