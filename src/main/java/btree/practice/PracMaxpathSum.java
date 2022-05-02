package btree.practice;

import btree.Node;


public class PracMaxpathSum {

  static int sum = 0;
  static int max_sum = 0;
  static int max_sum_new = 0;
  static int[] pathList = new int[100];

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(-2);
    root.right = new Node(7);
    root.left.left = new Node(8);
    root.left.right = new Node(-4);
    int pathlen = 0;
    printPaths(root, pathList, pathlen);
    System.out.println("Max Sum is : " + max_sum);

    maxSumFromRoot(root, sum);
    System.out.println("Max Sum is : " + max_sum_new);
  }

  private static void maxSumFromRoot(Node node, int sum) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null && (sum + node.key > max_sum_new)) {
      max_sum_new = sum + node.key;
    }
    maxSumFromRoot(node.left, sum + node.key);
    maxSumFromRoot(node.right, sum + node.key);
  }

  private static void printPaths(Node node, int[] pathList, int pathLen) {
    if (node == null) {
      return;
    }
    pathList[pathLen++] = node.key;
    if (node.left == null && node.right == null) {
      printArray(pathList, pathLen);
    } else {
      printPaths(node.left, pathList, pathLen);
      printPaths(node.right, pathList, pathLen);
    }
  }

  private static void printArray(int[] arr, int ln) {
    int sum = 0;
    for (int i = 0; i < ln; i++) {
      sum += arr[i];
      System.out.print(arr[i] + " ");
    }
    max_sum = Math.max(max_sum, sum);
    System.out.println();
  }

}
