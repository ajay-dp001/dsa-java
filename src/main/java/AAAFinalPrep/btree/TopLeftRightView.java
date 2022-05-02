package AAAFinalPrep.btree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class TopLeftRightView {

  private static class ObjQueue {

    int hd;
    BTNode node;

    public ObjQueue(int hd, BTNode node) {
      this.hd = hd;
      this.node = node;
    }
  }

  public static void main(String[] args) {
    BTNode root = new BTNode(1);
    root.left = new BTNode(2);
    root.right = new BTNode(3);
    root.left.right = new BTNode(4);
    root.left.right.right = new BTNode(5);
    root.left.right.right.right = new BTNode(6);
    System.out.println("Top view of Binary Tree");
    btTopView(root);

    System.out.println();
    BTNode root2 = new BTNode(10);
    root2.left = new BTNode(2);
    root2.right = new BTNode(3);
    root2.left.left = new BTNode(7);
    root2.left.right = new BTNode(8);
    root2.right.right = new BTNode(15);
    root2.right.left = new BTNode(12);
    root2.right.right.left = new BTNode(14);
    System.out.println("Left View of Binary Tree is :");
    btLeftView(root2);

    System.out.println();
    BTNode root1 = new BTNode(10);
    root1.left = new BTNode(2);
    root1.right = new BTNode(3);
    root1.left.left = new BTNode(7);
    root1.left.right = new BTNode(8);
    root1.right.right = new BTNode(15);
    root1.right.left = new BTNode(12);
    root1.right.right.left = new BTNode(14);
    System.out.println("Right View of Binary Tree is :");
    BTrightView(root1);

  }

  private static void BTrightView(BTNode root) {
    if (root == null) {
      return;
    }
    Queue<BTNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 1; i <= size; i++) {
        BTNode tempNode = queue.poll();
        if (i == size) {
          System.out.print(tempNode.val + " ");
        }
        if (tempNode.left != null) {
          queue.add(tempNode.left);
        }
        if (tempNode.right != null) {
          queue.add(tempNode.right);
        }
      }
    }
  }

  private static void btLeftView(BTNode root) {
    if (root == null) {
      return;
    }
    Queue<BTNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 1; i <= size; i++) {
        BTNode tempNode = queue.poll();
        if (i == size) {
          System.out.print(tempNode.val + " ");
        }
        if (tempNode.right != null) {
          queue.add(tempNode.right);
        }
        if (tempNode.left != null) {
          queue.add(tempNode.left);
        }
      }
    }

  }

  private static void btTopView(BTNode root) {
    Queue<ObjQueue> queue = new LinkedList<>();
    queue.add(new ObjQueue(0, root));

    Map<Integer, BTNode> hmap = new TreeMap<>();

    if (root == null) {
      return;
    }
    System.out.println("TOP View :");
    while (!queue.isEmpty()) {
      ObjQueue tempNode = queue.poll();

      if (!hmap.containsKey(tempNode.hd)) {
        hmap.put(tempNode.hd, tempNode.node);
      }

      if (tempNode.node.left != null) {
        queue.add(new ObjQueue(tempNode.hd - 1, tempNode.node.left));
      }

      if (tempNode.node.right != null) {
        queue.add(new ObjQueue(tempNode.hd + 1, tempNode.node.right));
      }
    }

    for (Entry<Integer, BTNode> entry : hmap.entrySet()) {
      System.out.print(entry.getValue().val + " ");
    }
  }

}
