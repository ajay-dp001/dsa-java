package btree.practice;

import btree.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class PracDiagonalTraversal {

  private static class LevelNode {

    Node node;
    int level;

    public LevelNode(Node node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(8);
    root.left = new Node(3);
    root.right = new Node(10);
    root.left.left = new Node(1);
    root.left.right = new Node(6);
    root.right.right = new Node(14);
    root.right.right.left = new Node(13);
    root.left.right.left = new Node(4);
    root.left.right.right = new Node(7);

    diagonalPrint(root);
  }

  private static void diagonalPrint(Node node) {
    if (node == null) {
      return;
    }
    Map<Integer, List<Integer>> map = new TreeMap<>();
    Queue<LevelNode> qu = new LinkedList<>();
    qu.add(new LevelNode(node, 0));

    while (!qu.isEmpty()) {
      LevelNode lNode = qu.remove();
      map.putIfAbsent(lNode.level, new ArrayList<>());
      map.get(lNode.level).add(lNode.node.key);

      if (lNode.node.right != null) {
        qu.add(new LevelNode(lNode.node.right, lNode.level));
      }

      if (lNode.node.left != null) {
        qu.add(new LevelNode(lNode.node.left, lNode.level + 1));
      }
    }

    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      int key = entry.getKey();
      List<Integer> list = map.get(key);
      int size = list.size();

      for (int i = 0; i < size; i++) {
        System.out.print(list.get(i) + " ");
      }
      System.out.println();
    }
  }

}
