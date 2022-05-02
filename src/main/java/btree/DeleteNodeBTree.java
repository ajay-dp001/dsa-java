package btree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeleteNodeBTree {

  static Node root;
  static int preIndex = 0;

  public static void inorder(Node rootNode) {
    if (rootNode != null) {
      inorder(rootNode.left);
      System.out.print(rootNode.key + " ");
      inorder(rootNode.right);
    }
  }

  private static void deleteDeppest(Node rootNode, Node delNode) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(rootNode);
    Node tmpNode;

    while (!queue.isEmpty()) {
      tmpNode = queue.remove();
      if (tmpNode == delNode) {
        tmpNode = null;
        return;
      }
      if (tmpNode.right != null) {
        if (tmpNode.right == delNode) {
          tmpNode.right = null;
          return;
        } else {
          queue.add(tmpNode.right);
        }
      }
      if (tmpNode.left != null) {
        if (tmpNode.left == delNode) {
          tmpNode.left = null;
          return;
        } else {
          queue.add(tmpNode.left);
        }
      }
    }
  }

  public static void delete(Node rootNode, int key) {
    if (rootNode != null) {
      if (rootNode.left == null && rootNode.right == null) {
        if (rootNode.key == key) {
          rootNode = null;
        }
      }
      Queue<Node> queue = new LinkedList<>();
      queue.add(rootNode);

      Node tmpNode = null, keyNode = null;

      while (!queue.isEmpty()) {
        tmpNode = queue.remove();
        if (tmpNode.key == key) {
          keyNode = tmpNode;
        }
        if (tmpNode.left != null) {
          queue.add(tmpNode.left);
        }
        if (tmpNode.right != null) {
          queue.add(tmpNode.right);
        }
      }

      if (keyNode != null) {
        int val = tmpNode.key;
        deleteDeppest(rootNode, tmpNode);
        keyNode.key = val;
      }
    }
  }

  private static void inorderWithoutRecursion(Node root) {
    if (root != null) {
      Stack<Node> stack = new Stack<>();
      Node currNode = root;
      while (currNode != null || !stack.isEmpty()) {
        while (currNode != null) {
          stack.push(currNode);
          currNode = currNode.left;
        }
        currNode = stack.pop();
        System.out.print(currNode.key + " ");
        currNode = currNode.right;
      }
    }
  }

  private static void inorderWithoutStack(Node root) {
    if (root != null) {
      Node currNode = root, pre = null;

      while (currNode != null) {
        if (currNode.left == null) {
          System.out.print(currNode.key + " ");
          currNode = currNode.right;
        } else {
          pre = currNode.left;
          while (pre.right != null && pre.right != currNode) {
            pre = pre.right;
          }
          if (pre.right == null) {
            pre.right = currNode;
            currNode = currNode.left;
          } else {
            pre.right = null;
            System.out.print(currNode.key + " ");
            currNode = currNode.right;
          }
        }
      }
    }
  }

  private static void postOrderFromInOrderPreOrder(int[] in, int[] pre, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return;
    }
    int indx = search(in, inStart, inEnd, pre[preIndex++]);
    postOrderFromInOrderPreOrder(in, pre, inStart, indx - 1);
    postOrderFromInOrderPreOrder(in, pre, indx + 1, inEnd);
    System.out.print(in[indx] + " ");
  }

  private static int search(int[] in, int inStart, int inEnd, int data) {
    int i = 0;
    for (i = inStart; i < inEnd; i++) {
      if (in[i] == data) {
        return i;
      }
    }
    return i;
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

    int key = 11;
    delete(root, key);

    System.out.print("\nInorder traversal After Deletion:");
    inorder(root);

    System.out.println("\nInorderWithoutRecursion using Stack:");
    inorderWithoutRecursion(root);

    System.out.println("\nInorderWithoutRecursion Without Using Stack:");
    inorderWithoutStack(root);

    System.out.println("\nPostorder Using InOrder and PreOrder:");
    int[] in = {4, 2, 5, 1, 3, 6};
    int[] pre = {1, 2, 4, 5, 3, 6};
    int len = in.length;
    postOrderFromInOrderPreOrder(in, pre, 0, len-1);
  }


}
