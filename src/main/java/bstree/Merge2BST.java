package bstree;

import bstree.BSTFromPreOrderTraversal.Index;
import btree.Node;
import java.util.ArrayList;
import java.util.List;

public class Merge2BST {

  static Node root;

  public static void main(String[] args) {
    Node root1 = new Node(100);
    root1.left = new Node(50);
    root1.right = new Node(300);
    root1.left.left = new Node(20);
    root1.left.right = new Node(70);

    Node root2 = new Node(80);
    root2.left = new Node(40);
    root2.right = new Node(120);

    root = mergeTrees(root1, root2);
    System.out.println("The Inorder traversal of the merged BST is: ");
    inorder(root);
  }


  private static Node mergeTrees(Node root1, Node root2) {
    List<Integer> list1 = storeInOrder(root1);
    List<Integer> list2 = storeInOrder(root2);
    List<Integer> list3 = merge(list1, list2);

    Node node = listToBST(list3, 0, list3.size() - 1);
    return node;
  }

  private static Node listToBST(List<Integer> list3, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    Node node = new Node(list3.get(mid));
    node.left = listToBST(list3, start, mid - 1);
    node.right = listToBST(list3, mid + 1, end);
    return node;
  }

  private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
    List<Integer> list = new ArrayList<>();
    int list1Len = list1.size();
    int list2Len = list2.size();
    int i = 0, j = 0;

    while (i < list1Len && j < list2Len) {
      if (list1.get(i) < list2.get(j)) {
        list.add(list1.get(i));
        i++;
      } else {
        list.add(list2.get(j));
        j++;
      }
    }

    while (i < list1Len) {
      list.add(list1.get(i));
      i++;
    }
    while (j < list2Len) {
      list.add(list2.get(j));
      j++;
    }
    return list;
  }

  private static List<Integer> storeInOrder(Node node) {
    return storeInOrderUtil(node, new ArrayList<>());
  }

  private static List<Integer> storeInOrderUtil(Node node, List<Integer> list) {
    if (node == null) {
      return list;
    }
    storeInOrderUtil(node.left, list);
    list.add(node.key);
    storeInOrderUtil(node.right, list);
    return list;
  }

  private static void inorder(Node node) {
    if (node != null) {
      inorder(node.left);
      System.out.print(node.key + " ");
      inorder(node.right);
    }
  }
}
