package btree;

public class BTreeFromInOrderAndLevelOrder {

  static Node startNode;

  public static void main(String[] args) {
    int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
    int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};
    int len = in.length;
    Node node = buildTree(in, level, len);
    System.out.print("Inorder traversal of the constructed tree is ");
    printInorder(node);
  }

  private static Node buildTree(int[] inOrder, int[] levelOrder, int len) {
    return constructTree(startNode, levelOrder, inOrder, 0, len - 1);
  }

  private static Node constructTree(Node startNode, int[] levelOrder, int[] inOrder, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }
    if (inStart == inEnd) {
      return new Node(inOrder[inStart]);
    }
    boolean found = false;
    int index = 0;

    for (int i = 0; i < levelOrder.length - 1; i++) {
      int data = levelOrder[i];
      for (int j = inStart; j < inEnd; j++) {
        if (data == inOrder[j]) {
          startNode = new Node(data);
          index = j;
          found = true;
          break;
        }
      }
      if (found) {
        break;
      }
    }

    startNode.left = constructTree(startNode, inOrder, levelOrder, inStart, index - 1);
    startNode.right = constructTree(startNode, inOrder, levelOrder, index + 1, inEnd);
    return startNode;
  }

  private static void printInorder(Node node) {
    if (node != null) {
      printInorder(node.left);
      System.out.print(node.key + " ");
      printInorder(node.right);
    }
  }
}
