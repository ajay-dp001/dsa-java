package btree.practice;

import btree.Node;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeleteNodeFromBT {

  static Node root;
  static MyLevel myLevel = new MyLevel();

  private static class MyLevel {

    int leafLevel = 0;
  }

  public static void main(String[] args) {
    root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.left.right = new Node(12);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);

    System.out.print("Inorder traversal Before Deletion:");
    inorder(root);
    System.out.println();
    inOrderWithOutRecusrion(root);

    int key = 11;
    delete(root, key);

    System.out.print("\nInorder traversal After Deletion:");
    inorder(root);
  }
  private static void delete(Node rootNode, int key) {
    if (rootNode != null) {
      if (rootNode.left == null && rootNode.right == null) {
        if (rootNode.key == key) {
          rootNode = null;
        }
      }
      Queue<Node> queue = new LinkedList<>();
      queue.add(rootNode);
      Node tempNode, keyNode = null;
      while (!queue.isEmpty()) {
        tempNode = queue.remove();
        if (tempNode.key == key) {
          keyNode = rootNode;
        }
        if (tempNode.left != null) {
          queue.add(tempNode.left);
        }
        if (tempNode.right != null) {
          queue.add(tempNode.left);
        }
        if (keyNode != null) {
          int val = tempNode.key;
          deleteDeepest(rootNode, tempNode);
          keyNode.key = val;
        }
      }
    }
  }

  private static void deleteDeepest(Node root, Node delNode) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    Node tempNode;

    while (!queue.isEmpty()) {
      tempNode = queue.poll();
      if (tempNode == delNode) {
        tempNode = null;
        return;
      }
      if (tempNode.right != null) {
        if (tempNode.right == delNode) {
          tempNode.right = null;
          return;
        } else {
          queue.add(tempNode.right);
        }
      }

      if (tempNode.left != null) {
        if (tempNode.left == delNode) {
          tempNode.left = null;
          return;
        } else {
          queue.add(tempNode.left);
        }
      }
    }
  }

  private static void inOrderWithOutRecusrion(Node root) {
    if (root != null) {
      Stack<Node> stack = new Stack<>();
      Node curr_node = root;
      while (curr_node != null || !stack.isEmpty()) {
        while (curr_node != null) {
          stack.push(curr_node);
          curr_node = curr_node.left;
        }
        curr_node = stack.pop();
        System.out.print(curr_node.key + " ");
        curr_node = curr_node.right;
      }
    }
  }

  private static void inorder(Node root) {
    if (root != null) {
      inorder(root.left);
      System.out.print(root.key + " ");
      inorder(root.right);
    }
  }

}
