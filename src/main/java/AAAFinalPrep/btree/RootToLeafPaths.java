package AAAFinalPrep.btree;

import btree.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RootToLeafPaths {

  private static int[] path = new int[100];

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    printPathsRecur(root, path, 0);

    System.out.println();
    printPathsUsingList(root, new ArrayList<>(), 0);
  }

  private static void printPathsRecur(Node node, int[] path, int pathLen) {
    if (node == null) {
      return;
    }
    path[pathLen] = node.key;
    pathLen++;

    if (node.left == null && node.right == null) {
      printArr(path, pathLen);
      System.out.println();
    }
    printPathsRecur(node.left, path, pathLen);
    printPathsRecur(node.right, path, pathLen);
  }


  private static void printArr(int[] arr, int pathlen) {
    for (int i = 0; i < pathlen; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void printPathsUsingList(Node node, List<Integer> paths, int pathLen) {
    if (node == null) {
      return;
    }
    paths.add(pathLen, node.key);
    pathLen++;

    if (node.left == null && node.right == null) {
      printList(paths, pathLen);
      System.out.println();
    }
    printPathsUsingList(node.left, paths, pathLen);
    printPathsUsingList(node.right, paths, pathLen);
  }


  private static void printList(List<Integer> list, int pathlen) {
    for (int i = 0; i < pathlen; i++) {
      System.out.print(list.get(i) + " ");
    }
  }
}
