package bstree.practice;

import btree.Node;

public class MxDepthOfBinaryTree {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    System.out.println("Height of tree is : " + maxDepth(root));
  }

  private static int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    int ldepth = maxDepth(root.left);
    int rdepth = maxDepth(root.right);

    if (ldepth > rdepth){
       return ldepth+1;
    }else
      return rdepth+1;
  }

}
