package bstree;

import btree.Node;
import java.util.Stack;

public class BSTFromPreOrderTraversal {

  static class Index {

    int index = 0;
  }

  static Index index = new Index();

  public static void main(String[] args) {
    int pre[] = new int[]{10, 5, 1, 7, 40, 50};
    int size = pre.length;
    Node root = constructTree(pre, size);
    System.out.println("Inorder traversal of the constructed tree is ");
    printInorder(root);

    //Stack based Soluton in O(n) time
    int pre1[] = new int[]{10, 5, 1, 7, 40, 50};
    int size2 = pre.length;
    Node root2 = constructTreeStackSol(pre1, size2);
    System.out.println("Inorder traversal of the constructed tree is ");
    printInorder(root2);


  }

  private static Node constructTreeStackSol(int[] pre, int size) {
    Node root = new Node(pre[0]);
    Stack<Node> stack = new Stack<>();
    stack.push(root);

    for (int i = 1; i < size; ++i) {
      Node tmp = null;

      while (!stack.isEmpty() && pre[i] > stack.peek().key) {
        tmp = stack.pop();
      }

      if (tmp != null) {
        tmp.right = new Node(pre[i]);
        stack.push(tmp.right);
      } else {
        tmp = stack.peek();
        tmp.left = new Node(pre[i]);
        stack.push(tmp.left);
      }
    }
    return root;
  }

  private static void printInorder(Node root) {
    if (root != null) {
      printInorder(root.left);
      System.out.println(root.key);
      printInorder(root.right);
    }
  }

  private static Node constructTree(int[] pre, int size) {
    int preIndex = 0;
    return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
  }

  private static Node constructTreeUtil(int[] pre, Index preIndex, int key, int min, int max,
      int size) {
    if (preIndex.index >= size) {
      return null;
    }
    Node root = null;
    if (key > min && key < max) {
      root = new Node(key);
      preIndex.index = preIndex.index + 1;
      if (preIndex.index < size) {
        root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);
      }
      if (preIndex.index < size) {
        root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);
      }
    }
    return root;
  }
}
