package AAAFinalPrep.btree;

import btree.Node;

public class DistanceBtwTwoNodes {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);
    System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));
    System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));
    System.out.println("Dist(3, 4) = " + findDistance(root, 3, 4));
    System.out.println("Dist(2, 4) = " + findDistance(root, 2, 4));
    System.out.println("Dist(8, 5) = " + findDistance(root, 8, 5));
  }

  private static int findDistance(Node node, int nodeAVal, int nodeBVal) {
    Node lcNode = lca(node, nodeAVal, nodeBVal);
    System.out.println("LCA of Node is:" + lcNode.key);

    int rl = findLevel(lcNode, nodeAVal, 0);
    int ll = findLevel(lcNode, nodeBVal, 0);
    return rl + ll;
  }

  private static Node lca(Node node, int nodeA, int nodeB) {
    if (node == null) {
      return null;
    }
    if (node.key == nodeA || node.key == nodeB) {
      return node;
    }
    Node leftNode = lca(node.left, nodeA, nodeB);
    Node rightNode = lca(node.right, nodeA, nodeB);

    if (leftNode != null && rightNode != null) {
      return node;
    }
    return leftNode != null ? leftNode : rightNode;
  }

  private static int findLevel(Node node, int nodeVal, int level) {
    if (node == null) {
      return 0;
    }
    if (node.key == nodeVal) {
      return level;
    }
    int llvl = findLevel(node.left, nodeVal, level + 1);
    int rlvl = findLevel(node.right, nodeVal, level + 1);
    return Math.max(llvl, rlvl);
  }

}
