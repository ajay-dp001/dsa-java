package btree;

public class NodeBWTwoLevelsOfBinaryTree {

  public static void main(String[] args) {
    Node root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(22);
    root.left.left = new Node(4);
    root.left.right = new Node(12);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);

    System.out.print("Level Order traversal between given two levels is ");
    printLevels(root, 1, 2, 3);
  }

  private static void printLevels(Node node, int curlvl, int lvl1, int lvl2) {
    if (node == null) {
      return;
    }
    if (curlvl >= lvl1 && curlvl <= lvl2) {
      System.out.print(node.key + " ");
    }
    printLevels(node.left, curlvl + 1, lvl1, lvl2);
    printLevels(node.right, curlvl + 1, lvl1, lvl2);
  }

}
