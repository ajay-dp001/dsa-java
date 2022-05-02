package AAAFinalPrep.btree;

import btree.Node;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

  private static class ObjectHelper {

    public int hd = 0;
    public Node node;

    public ObjectHelper(int hd, Node node) {
      this.hd = hd;
      this.node = node;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(20);
    root.left = new Node(8);
    root.left.left = new Node(5);
    root.left.right = new Node(3);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);

    root.right = new Node(22);
    root.right.left = new Node(4);
    root.right.right = new Node(25);

    System.out.println("Bottom view of the given binary tree:");
    bottomView(root);
    System.out.println();
    topview(root);
  }

  private static void topview(Node node) {
    if (node == null) {
      return;
    }
    Map<Integer, Node> map = new TreeMap<>();

    Queue<ObjectHelper> queue = new LinkedList<>();
    queue.add(new ObjectHelper(0, node));

    while (!queue.isEmpty()) {
      ObjectHelper tempNode = queue.poll();
      int hd = tempNode.hd;

      if (!map.containsKey(hd)) {
        map.put(hd, tempNode.node);
      }

      if (tempNode.node.left != null) {
        queue.add(new ObjectHelper(hd - 1, tempNode.node.left));
      }
      if (tempNode.node.right != null) {
        queue.add(new ObjectHelper(hd + 1, tempNode.node.right));
      }
    }

    for (Entry<Integer, Node> entry : map.entrySet()) {
      System.out.print(entry.getValue().key + " ");
    }

  }

  private static void bottomView(Node node) {
    if (node == null) {
      return;
    }
    Map<Integer, Node> map = new TreeMap<>();

    Queue<ObjectHelper> queue = new LinkedList<>();
    queue.add(new ObjectHelper(0, node));

    while (!queue.isEmpty()) {
      ObjectHelper tempNode = queue.poll();

      map.put(tempNode.hd, tempNode.node);

      if (tempNode.node.left != null) {
        queue.add(new ObjectHelper(tempNode.hd - 1, tempNode.node.left));
      }
      if (tempNode.node.right != null) {
        queue.add(new ObjectHelper(tempNode.hd + 1, tempNode.node.right));
      }
    }

    for (Entry<Integer, Node> entry : map.entrySet()) {
      System.out.print(entry.getValue().key + " ");
    }
  }

}
