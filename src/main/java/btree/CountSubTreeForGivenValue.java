package btree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSubTreeForGivenValue {

  static int count;
  static Node ptr;
  static int maxCount = 0;
  static Map<Integer, Integer> cnt = new HashMap<>();


  public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(-10);
    root.right = new Node(3);
    root.left.left = new Node(9);
    root.left.right = new Node(8);
    root.right.left = new Node(-4);
    root.right.right = new Node(7);

    int x = 7;
    ptr = root;
    System.out.println("Count = " + countSubtreesWithSumXUtil(root, x));

  }

  private static int countSubtreesWithSumXUtil(Node node, int x) {
    int left = 0, right = 0;
    if (node == null) {
      return 0;
    }
    left += countSubtreesWithSumXUtil(node.left, x);
    right += countSubtreesWithSumXUtil(node.right, x);

    if (left + right + node.key == x) {
      count++;
    }
    if (ptr != node) {
      return left + right + node.key;
    }
    return count;
  }
}
