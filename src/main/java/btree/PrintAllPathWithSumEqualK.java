package btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintAllPathWithSumEqualK {

  static List<Integer> paths = new ArrayList<>();
  static Stack<Node> stack = new Stack<>();
  static int sum = 0;

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(3);
    root.left.left = new Node(2);
    root.left.right = new Node(1);
    root.left.right.left = new Node(1);

    root.right = new Node(-1);
    root.right.left = new Node(4);
    root.right.left.left = new Node(1);
    root.right.left.right = new Node(2);
    root.right.right = new Node(5);
    root.right.right.right = new Node(2);
    int k = 5;
    printKPath(root, k);
  }

  private static void findKPathInorder(Node node, int k) {
    if (node == null) {
      return;
    }
    stack.push(node);
    sum = sum + node.key;
    if (sum == k) {
      for (int i = 0; i < stack.size(); i++) {
        System.out.println(stack.pop());
      }
    }
    findKPathInorder(node.left, k);
    findKPathInorder(node.right, k);
    sum = sum - node.key;
    stack.pop();
  }

  private static void printKPath(Node root, int k) {
    if (root == null) {
      return;
    }
    paths.add(root.key);
    printKPath(root.left, k);
    printKPath(root.right, k);

    int sum = 0;
    for (int j = paths.size() - 1; j >= 0; j--) {
      sum += paths.get(j);
      if (sum == k) {
        printPath(paths, j);
      }
    }
    paths.remove(paths.size() - 1);
  }

  private static void printPath(List<Integer> paths, int j) {
    for (int i = j; i < paths.size(); i++) {
      System.out.print(paths.get(i) + " ");
    }
    System.out.println();
  }
}
