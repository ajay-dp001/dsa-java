package btree.practice;

import btree.Node;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PracLevelOrderTraversal {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(7);
    root.left.right = new Node(6);
    root.right.left = new Node(5);
    root.right.right = new Node(4);
    System.out.println("Level order traversal of binary tree is ");
    printLevelOrder(root);
    printSpiral(root);
  }

  private static void printSpiral(Node root) {
    if (root != null) {
      Stack<Node> s1 = new Stack<>();
      Stack<Node> s2 = new Stack<>();
      s1.push(root);
      while (!s1.isEmpty() || !s2.isEmpty()) {
        while (!s1.isEmpty()) {
          Node node = s1.pop();
          System.out.print(node.key + " ");
          if (node.right!=null){
            s2.push(node.right);
          }
          if (node.left!=null){
            s2.push(node.left);
          }
        }
      }
    }
  }

  private static void printLevelOrder(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      System.out.print(temp.key + " ");
      if (temp.left != null) {
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
  }

}
