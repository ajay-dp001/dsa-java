package btree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckLeafAtSameLevel {

  static Leaf myLevel = new Leaf();

  static class Leaf {

    int leaflevel = 0;
  }

  public static void main(String[] args) {
    Node root = new Node(12);
    root.left = new Node(5);
    root.left.left = new Node(3);
    root.left.right = new Node(9);
    root.left.left.left = new Node(1);
    root.left.right.left = new Node(1);
    if (check(root)) {
      System.out.println("Leaves are at same level");
    } else {
      System.out.println("Leaves are not at same level");
    }
  }


  private static boolean check(Node root) {
    int level = 0;
    return checkUtil(root, level, myLevel);
  }

  private static boolean checkUtil(Node node, int level, Leaf myLevel) {
    if (node == null) {
      return true;
    }
    if (node.left == null & node.right == null) {
      if (myLevel.leaflevel == 0) {
        myLevel.leaflevel = level;
        return true;
      }
      return (level == myLevel.leaflevel);
    }
    return checkUtil(node.left, level + 1, myLevel) && checkUtil(node.right, level + 1, myLevel);
  }
}
