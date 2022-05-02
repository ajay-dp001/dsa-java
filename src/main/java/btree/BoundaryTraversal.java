package btree;

public class BoundaryTraversal {

  public static void main(String[] args) {
    Node root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(22);

    root.left.left = new Node(4);
    root.left.right = new Node(12);

    root.right.right = new Node(25);

    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);

    printBoundary(root);
  }

  private static void printBoundary(Node node) {
    if (node != null) {
      System.out.print(node.key + " ");

      System.out.println("\nLeft Side of BTree..");

      printBoundaryLeft(node.left);

      System.out.println("\nLeaves of Btree.. ");
      printLeaves(node.left);
      printLeaves(node.right);
      System.out.println("\nRight Side of BTree..");
      printBoundaryRight(node.right);

    }
  }

  private static void printLeaves(Node node) {
    if (node != null) {
      printLeaves(node.left);
      if (node.left == null && node.right == null) {
        System.out.print(node.key + " ");
      }
      printLeaves(node.right);
    }
  }

  private static void printBoundaryRight(Node node) {
    if (node != null) {
      if (node.right != null) {
        printBoundaryRight(node.right);
        System.out.print(node.key + " ");
      } else if (node.left != null) {
        printBoundaryRight(node.left);
        System.out.print(node.key + " ");
      }
    }
  }

  private static void printBoundaryLeft(Node node) {
    if (node != null) {
      if (node.left != null) {
        System.out.print(node.key + " ");
        printBoundaryLeft(node.left);
      } else if (node.right != null) {
        System.out.print(node.key + " ");
        printBoundaryLeft(node.right);
      }
    }
  }
}
