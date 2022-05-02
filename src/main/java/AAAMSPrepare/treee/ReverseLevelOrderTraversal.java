package AAAMSPrepare.treee;

import btree.Node;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.left.left = new Node(6);
    root.left.left.right = new Node(7);
    System.out.println();
    revLvlOrderTraversal(root);
    System.out.println();
    revLvlOrderTraversalInReverserOrder(root);
  }

  public static void revLvlOrderTraversal(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    Stack<Integer> stack = new Stack<>();

    while (!queue.isEmpty()) {
      Node tempNode = queue.poll();
      stack.push(tempNode.key);

      if (tempNode.right != null) {
        queue.add(tempNode.right);
      }
      if (tempNode.left != null) {
        queue.add(tempNode.left);
      }
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }

  public static void revLvlOrderTraversalInReverserOrder(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    Stack<Integer> stack = new Stack<>();

    while (!queue.isEmpty()) {
      Node tempNode = queue.poll();
      stack.push(tempNode.key);
      if (tempNode.left != null) {
        queue.add(tempNode.left);
      }
      if (tempNode.right != null) {
        queue.add(tempNode.right);
      }

    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }
}
