package bstree;

import btree.Node;

// Time Complexity O(h) where h is height of tree
public class InOrderSuccessor {

  static Node root;
  static Node preee = null, succc = null;

  public static void main(String[] args) {
    insert(20);
    insert(8);
    insert(24);
    insert(21);
    insert(22);
    insert(4);
    insert(12);
    insert(10);
    insert(14);
    //Node temp = root.left.right.right;
    Node temp = root.right.left;

    Node succ = inOrderSuccessor(root, temp);
    if (succ != null) {
      System.out.printf("Inorder Successor of %d is %d ", temp.key, succ.key);
    } else {
      System.out.printf("Inorder Successor doesn't exit");
    }

    findPredecessorSuccessor(root, temp.key);
    System.out.printf("Inorder Predecessor & Successor of %d is %d ", preee.key, succ.key);
  }

  private static Node inorderPredecessorNew(Node node) {
    Node preNode = node.left;
    while (preNode.right != null) {
      preNode = preNode.right;
    }
    return preNode;
  }

  private static Node inOrderSuccessorNew(Node node) {
    Node succNode = node.right;
    while (succNode.left != null) {
      succNode = succNode.left;
    }
    return succNode;
  }

  private static void findPredecessorSuccessor(Node node, int key) {
    if (node == null) {
      return;
    }
    if (node.key == key) {
      if (node.left != null) {
        preee = inorderPredecessorNew(node);
      }
      if (node.right != null) {
        succc = inOrderSuccessorNew(node);
      }
      return;
    }
    if (key > node.key) {
      preee = node;
      findPredecessorSuccessor(node.right, key);
    } else {
      succc = node;
      findPredecessorSuccessor(node.left, key);
    }
  }

  private static Node inOrderSuccessor(Node root, Node tmpNode) {
    if (tmpNode.right != null) {
      return minValue(tmpNode.right);
    }
    Node succ = null;
    while (root != null) {
      if (tmpNode.key < root.key) {
        succ = root;
        root = root.left;
      } else if (tmpNode.key > root.key) {
        root = root.right;
      } else {
        break;
      }
    }
    return succ;
  }

  private static Node minValue(Node node) {
    Node curr = node;
    while (curr.left != null) {
      curr = curr.left;
    }
    return curr;
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
