package btree;

import java.util.List;

public class AncestorOfNode {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.left.left = new Node(7);

    printAncestors(root, 7);
  }

  private static boolean printAncestors(Node node, int target) {
    if (node == null) {
      return false;
    }
    if (node.key == target) {
      return true;
    }
    if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
      System.out.print(node.key + " ");
      return true;
    }
    return false;
  }

}
