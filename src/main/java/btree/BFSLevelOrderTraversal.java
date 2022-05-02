package btree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSLevelOrderTraversal {

  public static void main(String[] args) {
    Node root = new Node(1);

    root.left = new Node(2);
    root.left.left = new Node(7);
    root.left.right = new Node(6);

    root.right = new Node(3);
    root.right.left = new Node(5);
    root.right.right = new Node(4);

    System.out.println("Level order traversal of binary tree is ");
    printLevelOrder(root);
    System.out.println("Level order traversal of binary tree is ");
    printLevelOrder_2(root);

    System.out.println("Spiral Order traversal of Binary Tree is ");
    printSpiral(root);
  }

  private static void printSpiral(Node root) {
    if (root != null) {
      Stack<Node> s1 = new Stack<>();
      Stack<Node> s2 = new Stack<>();
      s1.push(root);
      while (!s1.isEmpty() || !s2.isEmpty()) {
        while (!s1.isEmpty()) {
          Node tmp = s1.pop();
          System.out.print(tmp.key + " ");

          if (tmp.right != null) {
            s2.push(tmp.right);
          }

          if (tmp.left != null) {
            s2.push(tmp.left);
          }
        }

        while (!s2.isEmpty()) {
          Node tmp = s2.pop();
          System.out.print(tmp.key + " ");

          if (tmp.left != null) {
            s1.push(tmp.left);
          }

          if (tmp.right != null) {
            s1.push(tmp.right);
          }
        }
      }

    }
  }

  private static void printLevelOrder_2(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node tmp = queue.remove();
      System.out.print(tmp.key + " ");
      if (tmp.left != null) {
        queue.add(tmp.left);
      }
      if (tmp.right != null) {
        queue.add(tmp.right);
      }
    }
  }

  private static int treeHeight(Node node) {
    if (node == null) {
      return 0;
    }
    int lHeight = treeHeight(node.left);
    int rHeight = treeHeight(node.right);

    return Math.max(lHeight, rHeight) + 1;
  }

  private static void printLevelOrder(Node node) {
    int height = treeHeight(node);
    for (int i = 0; i <= height; i++) {
      printCurrentlevel(node, i);
    }
  }

  private static void printCurrentlevel(Node node, int level) {
    if (node != null) {
      if (level == 1) {
        System.out.print(node.key + " ");
      } else if (level > 1) {
        printCurrentlevel(node.left, level - 1);
        printCurrentlevel(node.right, level - 1);
      }
    }
  }
}
