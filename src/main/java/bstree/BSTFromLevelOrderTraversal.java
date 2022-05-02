package bstree;

import btree.Node;

//O(n2)
public class BSTFromLevelOrderTraversal {

  public static void main(String[] args) {
    int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
    int n = arr.length;
    Node root = constructBst(arr, n);

    System.out.print("Inorder Traversal: ");
    inorderTraversal(root);
  }

  private static Node constructBst(int[] arr, int len) {
    if (len == 0) {
      return null;
    }
    Node root = null;
    for (int i = 0; i < len; i++) {
      root = levelorder(root, arr[i]);
    }
    return root;
  }

  private static Node levelorder(Node root, int data) {
    if (root == null) {
      root = getNode(data);
      return root;
    }
    if (data <= root.key) {
      root.left = levelorder(root.left, data);
    } else {
      root.right = levelorder(root.right, data);
    }
    return root;
  }

  private static Node getNode(int data) {
    Node newNode = new Node(data);
    newNode.left = newNode.right = null;
    return newNode;
  }

  private static void inorderTraversal(Node root) {
    if (root != null) {
      inorderTraversal(root.left);
      System.out.print(root.key + " ");
      inorderTraversal(root.right);
    }
  }
}
