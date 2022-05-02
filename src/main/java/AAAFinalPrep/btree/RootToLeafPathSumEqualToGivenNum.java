package AAAFinalPrep.btree;

import btree.Node;
import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathSumEqualToGivenNum {

  static List<Integer> pathList = new ArrayList<>();

  public static void main(String[] args) {
    int sum = 21;
    Node root = new Node(10);
    root.left = new Node(8);
    root.right = new Node(2);
    root.left.left = new Node(31);
    root.left.right = new Node(5);
    root.right.left = new Node(9);

    if (hasPathSum(root, sum)) {
      getPath(root, sum);
      System.out.println();
      System.out.println("There is a root to leaf path with sum " + sum);
    } else {
      System.out.println("There is no root to leaf path with sum " + sum);
    }
  }


  private static boolean hasPathSum(Node node, int targetSum) {
    if (node == null) {
      return false;
    }
    return hasPathSumUtil(node, targetSum, 0);
  }

  private static boolean hasPathSumUtil(Node node, int targetSum, int currSum) {
    if (node == null) {
      if (currSum == targetSum) {
        return true;
      }
      return false;
    }
    return hasPathSumUtil(node.left, targetSum, currSum + node.key) ||
        hasPathSumUtil(node.right, targetSum, currSum + node.key);
  }

  private static void getPath(Node node, int target) {
    if (node == null) {
      return;
    }
    pathList.add(node.key);
    getPath(node.left, target);
    getPath(node.right, target);

    int sum = 0;
    for (int i = pathList.size() - 1; i >= 0; i--) {
      sum += pathList.get(i);
      if (sum == target) {
        printPathList(pathList);
      }
    }
    pathList.remove(pathList.size() - 1);
  }

  private static void printPathList(List<Integer> paths) {
    for (int num : paths) {
      System.out.print(num + " ");
    }
  }
}
