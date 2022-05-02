package btree;

public class CountNodeInCompleteBinaryTree {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(7);
    root.left.right = new Node(6);
    root.right.left = new Node(5);
    root.right.right = new Node(4);
    System.out.print("Total Node in Complete Binary Tree is :");
    System.out.print(getHeight(root));
  }

  private static int getHeight(Node node) {
    if (node == null) {
      return 0;
    }
    int leftHeight = getLeftHeight(node);
    int rightHeight = getRightHeight(node);

    if (leftHeight == rightHeight) {
      return ((2 << leftHeight) -1);
    }
    return getHeight(node.left) + getHeight(node.right) + 1;

  }

  private static int getRightHeight(Node node) {
    int count = 0;
    while (node.right != null) {
      count++;
      node = node.right;
    }
    return count;
  }

  private static int getLeftHeight(Node node) {
    int count = 0;
    while (node.left != null) {
      count++;
      node = node.left;
    }
    return count;
  }

}
