package btree;

public class SymmetricTree {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(2);

    root.left.left = new Node(3);
    root.left.right = new Node(4);
    root.right.left = new Node(4);
    root.right.right = new Node(3);
      System.out.println("Tree is Symmetric: " + isSymmetric(root));
  }

  private static boolean isSymmetric(Node root) {
    return root == null || isSymmetricUtil(root.left, root.right);
  }

  private static boolean isSymmetricUtil(Node left, Node right) {
    if (left == null || right == null) {
      return (left == right);
    }

    if (left.key != right.key) {
      return false;
    }
    return isSymmetricUtil(left.left, right.right) && isSymmetricUtil(left.right, right.left);
  }

}
