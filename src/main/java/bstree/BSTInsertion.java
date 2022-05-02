package bstree;

import btree.Node;

public class BSTInsertion {

  static Node root;
  static int ans;
  static int count;
  static int idx=1;

  public static void main(String[] args) {
   insert(50);
    insert(30);
    insert(20);
    insert(40);
    insert(70);
    insert(60);
    insert(80);

    // print inorder traversal of the BST
    inorder(root);

    System.out.println("\nDelete 20");
    deleteKey(20);
    System.out.println("Inorder traversal of the modified tree");
    //inorder(root);

    System.out.println("\nDelete 30");
    deleteKey(30);
    System.out.println("Inorder traversal of the modified tree");
    inorder(root);

    System.out.println("\nDelete 50");
    deleteKey(50);
    System.out.println("Inorder traversal of the modified tree");
    inorder(root);

    int k = 3;
    Node node = printKthSmallest(root, k);
    printKthSmallesInOrdert(root, k);

    System.out.print("Kth Smallest is : " + node.key);
    System.out.print("Kth Smallest is : " + ans);

    System.out.println(
        "Finding K-th largest Node in BST : " + KthLargestUsingMorrisTraversal(root, 2));
  }

  static boolean iterativeSearch(Node root, int key) {
    // Traverse until root reaches to dead end
    while (root != null) {
      // pass right subtree as new tree
      if (key > root.key) {
        root = root.right;
      }

      // pass left subtree as new tree
      else if (key < root.key) {
        root = root.left;
      } else {
        return true; // if the key is found return 1
      }
    }
    return false;
  }

  private static Node KthLargestUsingMorrisTraversal(Node root, int k) {
    Node curr = root;
    Node kLargest = null;
    int cnt = 0;

    while (curr != null) {
      if (curr.right == null) {
        if (++cnt == k) {
          kLargest = curr;
        }
        curr = curr.left;
      } else {
        Node succ = curr.right;
        while (succ.left != null && succ.left != curr) {
          succ = succ.left;
          if (succ.left == null) {
            succ.left = curr;
            curr = curr.right;
          } else {
            succ.left = null;
            if (++cnt == k) {
              kLargest = curr;
            }
            curr = curr.left;
          }
        }
      }
    }
    return kLargest;
  }

  private static Node printKthSmallest(Node root, int k) {
    if (root == null) {
      return null;
    }
    Node left = printKthSmallest(root.left, k);
    if (left != null) {
      return left;
    }
    count++;
    if (count == k) {
      return root;
    }
    return printKthSmallest(root.right, k);
  }

  private static void printKthSmallesInOrdert(Node root, int k) {
    if (root == null) {
      return;
    }
    printKthSmallesInOrdert(root.left, k);
    if (idx == k) {
      ans = root.key;
      idx++;
      return;
    }
    idx++;
    printKthSmallesInOrdert(root.right, k);
  }

  private static void printKthLargestInOrder(Node root, int k) {
    if (root == null) {
      return;
    }
    printKthSmallesInOrdert(root.right, k);
    if (idx == k) {
      ans = root.key;
      idx++;
      return;
    }else {
      idx++;
    }
    printKthSmallesInOrdert(root.left, k);
  }

  private static void deleteKey(int key) {
    deleteNode(root, key);
  }

  private static Node deleteNode(Node node, int key) {
    if (node == null) {
      return root;
    }
    if (key < node.key) {
      node.left = deleteNode(node.left, key);
    } else if (key > node.key) {
      node.right = deleteNode(node.right, key);
    } else {
      if (node.left == null) {
        return node.right;
      } else if (node.right == null) {
        return node.left;
      }

      node.key = minValue(node.right);
      node.right = deleteNode(node.right, node.key);
    }
    return node;
  }

  private static int minValue(Node node) {
    int minv = node.key;
    while (node.left != null) {
      minv = node.left.key;
      node = node.left;
    }
    return minv;
  }

  private static void inorder(Node node) {
    if (node != null) {
      inorder(node.left);
      System.out.println(node.key);
      inorder(node.right);
    }
  }

  private static void insert(int data) {
    root = insertUtil(root, data);
  }

  private static Node insertUtil(Node root, int data) {
    if (root == null) {
      return new Node(data);
    }
    if (data < root.key) {
      root.left = insertUtil(root.left, data);
    } else if (data > root.key) {
      root.right = insertUtil(root.right, data);
    }

    return root;
  }
}
