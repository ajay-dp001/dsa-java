package btree;

public class CheckIfMirrorAndIdentical {

  public static void main(String[] args) {
    Node rootA = new Node(1);
    rootA.left = new Node(2);
    rootA.right = new Node(3);
    rootA.left.left = new Node(4);
    rootA.left.right = new Node(5);

    Node rootB = new Node(1);

    rootB.left = new Node(3);
    rootB.right = new Node(2);
    rootB.right.left = new Node(5);
    rootB.right.right = new Node(4);

    if (checkMirror(rootA, rootB)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    Node rootA1 = new Node(1);
    rootA1.left = new Node(2);
    rootA1.right = new Node(3);
    rootA1.left.left = new Node(4);
    rootA1.left.right = new Node(5);

    Node rootA2 = new Node(1);
    rootA2.left = new Node(2);
    rootA2.right = new Node(3);
    rootA2.left.left = new Node(4);
    rootA2.left.right = new Node(5);

    if (identicalTrees(rootA1, rootA2)) {
      System.out.println("Both trees are identical");
    } else {
      System.out.println("Trees are not identical");
    }
  }

  private static boolean checkMirror(Node rootA, Node rootB) {
    if (rootA == null && rootB == null) {
      return true;
    }
    if (rootA == null || rootB == null) {
      return false;
    }
    return rootA.key == rootB.key && checkMirror(rootA.left, rootB.right) && checkMirror(
        rootA.right, rootB.left);
  }

  private static boolean identicalTrees(Node rootA1, Node rootA2) {
    if (rootA1 == null && rootA2 == null) {
      return true;
    }
    if (rootA1 != null && rootA2 != null) {
      return rootA1.key == rootA2.key && identicalTrees(rootA1.left, rootA2.left) && identicalTrees(
          rootA1.right, rootA2.right);
    }
    return false;
  }
}
