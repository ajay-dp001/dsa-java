package AAAFinalPrep.btree;

import btree.Node;

public class CheckIfLeafNodeAtSameLevel {

  private static Level level = new Level(0);

  private static class Level {

    int level;

    public Level(int level) {
      this.level = level;
    }
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

  private static boolean check(Node node) {
    return checkUtil(node, 0, level);
  }

  private static boolean checkUtil(Node node, int level, Level myLevel) {
    if (node == null) {
      return true;
    }
    if (node.left == null && node.right == null) {
      if (myLevel.level == 0) {
        myLevel.level = level;
        return true;
      }
      return (level == myLevel.level);
    }
    return checkUtil(node.left, level + 1, myLevel)
        && checkUtil(node.right, level + 1, myLevel);
  }

}
