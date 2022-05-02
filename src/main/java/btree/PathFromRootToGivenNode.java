package btree;

import java.util.ArrayList;
import java.util.List;

public class PathFromRootToGivenNode {

  static List<Integer> paths= new ArrayList<>();

  public static void main(String[] args) {
    Node root=new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    int x=5;
    printPathToNode(root, x);
  }

  private static void printPathToNode(Node node, int key) {
    if (node == null) {
      return;
    }
    paths.add(node.key);

    printPathToNode(node.left, key);
    printPathToNode(node.right, key);

    for (int j = paths.size() - 1; j >= 0; j--) {
      if (node.key == key) {
        printPaths(paths, j);
        break;
      }
    }
    paths.remove(paths.size() - 1);
  }

  private static void printPaths(List<Integer> paths, int len) {
    for (int i = 0; i <= len; i++) {
      System.out.print(paths.get(i) + " ");
    }
    System.out.println();
  }
}
