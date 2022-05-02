package bstree;

import btree.Node;
import java.util.ArrayList;
import java.util.List;

public class AVLTree {

  private static class NodeAvl {

    int data, height;
    NodeAvl left, right;

    NodeAvl(int data) {
      this.data = data;
      height = 1;
    }
  }

  private static NodeAvl root;

  public static void main(String[] args) {
    root = insert(root, 10);
    insert(root, 20);
    insert(root, 30);
    insert(root, 40);
    insert(root, 50);
    insert(root, 25);
    System.out.println("Preorder traversal of constructed tree is : ");
    preOrder(root);
  }

  private static NodeAvl insert(NodeAvl node, int data) {
    if (node == null) {
      return (new NodeAvl(data));
    }
    if (data < node.data) {
      node.left = insert(node.left, data);
    } else if (data > node.data) {
      node.right = insert(node.right, data);
    } else {
      return node;
    }
    node.height = 1 + Math.max(height(node.left), height(node.right));
    int bf = getBalanceFactor(node);

    //LL
    if (bf > 1 && data < node.left.data) {
      return rightRotate(node);
    }
    //RR
    if (bf < -1 && data > node.right.data) {
      return leftRotate(node);
    }

    if (bf > 1 && data > node.left.data) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }

    if (bf < -1 && data < node.right.data) {
      node.right = rightRotate(node.left);
      return leftRotate(node);
    }
    return node;
  }

  private static NodeAvl leftRotate(NodeAvl node) {
    NodeAvl t1 = node.right;
    NodeAvl t2 = node.left;

    t1.left = node;
    node.right = t2;

    node.height = Math.max(height(node.left), height(node.right)) + 1;
    t1.height = Math.max(height(t1.left), height(t1.right)) + 1;

    return t1;
  }

  private static NodeAvl rightRotate(NodeAvl node) {
    NodeAvl x = node.left;
    NodeAvl t2 = x.right;

    x.right = node;
    node.left = t2;

    node.height = Math.max(height(node.left), height(node.right)) + 1;
    x.height = Math.max(height(x.left), height(x.right)) + 1;

    return x;
  }

  private static int getBalanceFactor(NodeAvl node) {
    if (node == null) {
      return 0;
    }
    return height(node.left) - height(node.right);
  }

  private static int height(NodeAvl node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }

  private static void preOrder(NodeAvl root) {
    if (root != null) {
      System.out.println(root.data + " ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }
}
