package bstree.practice;

import btree.Node;
import java.util.ArrayList;
import java.util.List;

public class PracMergeTwobST {

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
  }

  private static Node mergeTrees(Node root1, Node root2) {
    List<Integer> list1 = convertInOrderBSTToList(root1);
    List<Integer> list2 = convertInOrderBSTToList(root2);
    List<Integer> list3 = merg(list1, list2);
    System.out.println();
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

  private static List<Integer> merg(List<Integer> list1, List<Integer> list2) {
    List<Integer> list = new ArrayList<>();
    int ln1 = list1.size();
    int ln2 = list2.size();
    int i = 0, j = 0;

    while (i < ln1 && j < ln2) {
      if (list1.get(i) < list2.get(j)) {
        list.add(list1.get(i));
        i++;
      } else {
        list.add(list2.get(j));
        j++;
      }
    }
    while (i < ln1) {
      list.add(list1.get(i));
      i++;
    }
    while (j < ln2) {
      list.add(list2.get(j));
      j++;
    }
    return list;
  }

  private static List<Integer> convertInOrderBSTToList(Node root1) {
    return converUtil(root1, new ArrayList<Integer>());
  }

  private static List<Integer> converUtil(Node node, ArrayList<Integer> list) {
    if (node == null) {
      return null;
    }
    converUtil(node.left, list);
    list.add(node.key);
    converUtil(node.right, list);
    return list;
  }

}
