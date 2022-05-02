package btree;

public class MaxDepthAndDiameterOfBinaryTree {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    System.out.println("Height of tree is : " + maxDepth(root));
    System.out.println("Height of tree is : " + maxDepthSecondMethod(root));
    System.out.println("The diameter of given binary tree is : " + diameter(root));
  }

  private static int diameter(Node node) {
    int[] diameter = new int[1];
    heightUtil(node, diameter);
    return diameter[0];
  }
  private static int heightUtil(Node node, int[] diameter) {
    if (node == null) {
      return 0;
    }
    int lh = heightUtil(node.left, diameter);
    int rh = heightUtil(node.right, diameter);
    diameter[0] = Math.max(diameter[0], lh + rh);
    return 1 + Math.max(lh, rh);
  }

  private static int maxDepth(Node node) {
    if (node == null) {
      return 0;
    } else {
      int lDepth = maxDepth(node.left);
      int rDepth = maxDepth(node.right);

      if (lDepth > rDepth) {
        return lDepth + 1;
      } else {
        return rDepth + 1;
      }
    }
  }

  private static int maxDepthSecondMethod(Node node) {
    if (node == null) {
      return 0;
    }
    int leftHeight = maxDepthSecondMethod(node.left);
    int rightHeight = maxDepthSecondMethod(node.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  private static int checkBalancedBinaryTree(Node node) {
    if (node == null) {
      return 0;
    }
    int leftHeight = maxDepthSecondMethod(node.left);
    if (leftHeight == -1) {
      return -1;
    }
    int rightHeight = maxDepthSecondMethod(node.right);
    if (rightHeight == -1) {
      return -1;
    }
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
