package AAAFinalPrep.btree;

import btree.Node;

public class BTreeFromInOrderAndLevelOrder {

  static Node startNode;

  public static void main(String[] args) {
    int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
    int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};
    int len = in.length;
    Node node = buildTree(in, level, len);
  }

  private static Node buildTree(int[] in, int[] lvl, int len) {
    return buildTreeUtil(startNode, in, lvl, 0, len - 1);
  }

  private static Node buildTreeUtil(Node startNode, int[] in, int[] lvl, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }
    if (inStart == inEnd) {
      return new Node(in[inStart]);
    }
    boolean found = false;
    int inIndex = 0;

    for (int i = 0; i < lvl.length - 1; i++) {
      int node = lvl[0];
      for (int j = inStart; j < inEnd; j++) {
        if (node == in[j]) {
          startNode = new Node(node);
          inIndex = j;
          found = true;
          break;
        }
      }
      if (found) {
        break;
      }
    }
    startNode.left = buildTreeUtil(startNode, in, lvl, inStart, inIndex - 1);
    startNode.right = buildTreeUtil(startNode, in, lvl, inIndex + 1, inEnd);
    return startNode;
  }
}
