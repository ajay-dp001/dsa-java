package AAAFinalPrep.btree;

import btree.Node;

public class MaxDepth {

  private static int maxDepth = Integer.MIN_VALUE;

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    System.out.println("Height of tree is : " + maxDepth(root));
    System.out.println("Height of tree is : " + diameterOfTree(root));
  }

  private static int maxDepth(Node node) {
    if (node == null) {
      return 0;
    }
    int ld = maxDepth(node.left);
    int rd = maxDepth(node.right);
    return Math.max(ld, rd) + 1;
  }

  private static int diameterOfTree(Node node) {
    int[] dia = new int[1];
    diaUtil(node, dia);
    return dia[0];
  }

  private static int diaUtil(Node node, int[] dia) {
    if (node == null) {
      return 0;
    }
    int lh = diaUtil(node.left, dia);
    int rh = diaUtil(node.right, dia);
    dia[0] = Math.max(dia[0], lh + rh);
    return Math.max(lh, rh) + 1;
  }
}
