package btree;

public class LCADistanceBetweenTwoNodes {

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

    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.left.right = new Node(5);
    root1.left.left.left = new Node(7);

    System.out.println("Ancestor :");
    printAncestor(root1, 7);
  }

  private static boolean printAncestor(Node node, int target) {
    if (node == null) {
      return false;
    }
    if (node.key == target) {
      return true;
    }
    if (printAncestor(node.left, target) || printAncestor(node.right, target)) {
      System.out.print(node.key + " ");
      return true;
    }
    return false;
  }

  private static int findDistance(Node root, int nodeAVal, int nodeBVal) {
    Node lcaNode = findLca(root, nodeAVal, nodeBVal);
    System.out.println("Lca-1 : " + lcaNode.key);

    int d1 = findLevel(lcaNode, nodeAVal, 0);
    int d2 = findLevel(lcaNode, nodeBVal, 0);
    return d1 + d2;
  }

  private static Node lca(Node root, int nodeAVal, int nodeBVal) {
    if (root == null) {
      return null;
    }
    if (root.key == nodeAVal || root.key == nodeBVal) {
      return root;
    }
    Node left = lca(root.left, nodeAVal, nodeBVal);
    Node right = lca(root.right, nodeAVal, nodeBVal);

    if (left != null && right != null) {
      return root;
    }
    if (left == null && right == null) {
      return null;
    }
    if (left != null) {
      return lca(root.left, nodeAVal, nodeBVal);
    } else {
      return lca(root.right, nodeAVal, nodeBVal);
    }
  }

  private static Node lcaNew(Node root, Node nodeA, Node nodeB) {
    if (root == null || root == nodeA || root == nodeB) {
      return root;
    }

    Node left = lcaNew(root.left, nodeA, nodeB);
    Node right = lcaNew(root.right, nodeA, nodeB);

    if (left == null) {
      return right;
    } else if (right == null) {
      return left;
    } else {
      return root;
    }
  }

  private static int findLevel(Node node, int nodeA, int level) {
    if (node == null) {
      return -1;
    }
    if (node.key == nodeA) {
      return level;
    }
    int left = findLevel(node.left, nodeA, level + 1);
    if (left == -1) {
      return findLevel(node.right, nodeA, level + 1);
    }
    return left;
  }

  private static Node findLca(Node node, int nodeA, int nodeB) {
    if (node == null) {
      return null;
    }
    if (node.key == nodeA || node.key == nodeB) {
      return node;
    }
    Node left_lca = findLca(node.left, nodeA, nodeB);
    Node right_lca = findLca(node.right, nodeA, nodeB);

    if (left_lca != null && right_lca != null) {
      return node;
    }
    return (left_lca != null) ? left_lca : right_lca;
  }
}
