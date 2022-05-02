package AAAFinalPrep.btree;

import btree.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class DiagonalTraversal {

  private static class LevelNode {

    private Node node;
    private int level;

    public LevelNode(int level, Node node) {
      this.level = level;
      this.node = node;
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

    Queue<LevelNode> queue = new LinkedList<>();
    queue.add(new LevelNode(0, node));

    while (!queue.isEmpty()) {
      LevelNode tempLevelNode = queue.poll();
      map.putIfAbsent(tempLevelNode.level, new ArrayList<>());
      map.get(tempLevelNode.level).add(tempLevelNode.node.key);

      if (tempLevelNode.node.left != null) {
        queue.add(new LevelNode(tempLevelNode.level + 1, tempLevelNode.node.left));
      }
      if (tempLevelNode.node.right != null) {
        queue.add(new LevelNode(tempLevelNode.level, tempLevelNode.node.right));
      }
    }

    for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
      int key = entry.getKey();
      List<Integer> list = map.get(key);
      for (int num : list) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }

}
