package btree;

public class MaxSumLeafToRootPath {

  static int maxSum = 0;
  static int[] path = new int[100];
  static int sum = 0;
  static int max_sum = 0;
  static Node target_leaf = null;

  static int max_no = Integer.MIN_VALUE;

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(-2);
    root.right = new Node(7);
    root.left.left = new Node(8);
    root.left.right = new Node(-4);

    printPathsRecur(root, path, 0);
    System.out.println("Max Sum is : " + max_sum);

    System.out.println("Max sum is : " + maxSumPath(root));

    maxSumFromRoot(root, 0);
    System.out.println(maxSum);
  }

  private static void maxSumFromRoot(Node node, int sum) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null && maxSum < (sum + node.key)) {
      maxSum = (sum + node.key);
      return;
    }
    maxSumFromRoot(node.left, sum + node.key);
    maxSumFromRoot(node.right, sum + node.key);
  }

  private static int maxSumPath(Node root) {
    if (root == null) {
      return 0;
    }
    getTargetNode(root, 0);
    printPath(root, target_leaf);
    return max_no;
  }

  private static void getTargetNode(Node node, int curr_sum) {
    if (node == null) {
      return;
    }
    curr_sum = curr_sum + node.key;
    if (node.left == null && node.right == null) {
      if (curr_sum > max_no) {
        max_no = curr_sum;
        target_leaf = node;
      }
    }
    getTargetNode(node.left, curr_sum);
    getTargetNode(node.right, curr_sum);
  }

  private static boolean printPath(Node node, Node target_leaf) {
    if (node == null) {
      return false;
    }
    if (node == target_leaf || printPath(node.left, target_leaf) || printPath(node.right, target_leaf)) {
      System.out.print(node.key + " ");
      return true;
    }
    return false;
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
      sum = sum + path[i];
      System.out.print(path[i] + " ");

    }
    max_sum = Math.max(max_sum, sum);
    sum = 0;
    System.out.println();
  }
}
