package btree;

public class RootToLeafPaths {

  static int[] path = new int[100];

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    printPathsRecur(root, path, 0);
  }

  private static void printPathsRecur(Node node, int[] path, int pathLen) {
    if (node == null) {
      return;
    }
    path[pathLen++] = node.key;

    if (node.left == null && node.right == null) {
      printArray(path, pathLen);
    }
    printPathsRecur(node.left, path, pathLen);
    printPathsRecur(node.right, path, pathLen);

  }

  private static void printArray(int[] path, int pathLen) {
    for (int i = 0; i < pathLen; i++) {
      System.out.print(path[i] + " ");
    }
    System.out.println();
  }
}
