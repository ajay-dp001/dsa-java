package btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class DiagonalTraversal {

  static class TNode {

    Node node;
    int level;

    public TNode(Node node, int level) {
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

  private static void diagonalPrint(Node root) {
    if (root == null) {
      return;
    }
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();

    Queue<TNode> queue = new LinkedList<>();
    queue.add(new TNode(root, 0));

    while (!queue.isEmpty()) {
      TNode node = queue.remove();
      map.putIfAbsent(node.level, new ArrayList<>());
      map.get(node.level).add(node.node.key);

      if (node.node.left != null) {
        queue.add(new TNode(node.node.left, node.level + 1));
      }
      if (node.node.right != null) {
        queue.add(new TNode(node.node.right, node.level));
      }
    }

    for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
      List<Integer> list = map.get(entry.getKey());
      int size = list.size();

      for (int i = 0; i < size; i++) {
        System.out.print(list.get(i) + " ");
      }
      System.out.println(" ");
    }
  }
}
