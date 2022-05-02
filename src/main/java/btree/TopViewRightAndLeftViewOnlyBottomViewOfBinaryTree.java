package btree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class TopViewRightAndLeftViewOnlyBottomViewOfBinaryTree {

  private static int maxlevel = 0;

  private static class ObjQueueHelper {

    private int hd; //horizontalDistance
    private Node node;

    public ObjQueueHelper(int hd, Node node) {
      this.node = node;
      this.hd = hd;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.right = new Node(4);
    root.left.right.right = new Node(5);
    root.left.right.right.right = new Node(6);
    System.out.println("Following are nodes in top view of Binary Tree");
    topView(root);

    System.out.println();
    Node root1 = new Node(10);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(7);
    root1.left.right = new Node(8);
    root1.right.right = new Node(15);
    root1.right.left = new Node(12);
    root1.right.right.left = new Node(14);
    System.out.println("Right View of Binary Tree is :");
    rightViewOnly(root1);
    List<Integer> list = new ArrayList<>();
    rightViewDFS(root1, 1, list);
    System.out.println(Arrays.toString(list.toArray()));

    System.out.println();
    Node root2 = new Node(10);
    root2.left = new Node(2);
    root2.right = new Node(3);
    root2.left.left = new Node(7);
    root2.left.right = new Node(8);
    root2.right.right = new Node(15);
    root2.right.left = new Node(12);
    root2.right.right.left = new Node(14);
    System.out.println("Left View of Binary Tree is :");
    leftViewOnly(root2);
    maxlevel=0;
    List<Integer> leftView = new ArrayList<>();
    leftViewDFS(root2, 1, leftView);
    System.out.println(Arrays.toString(leftView.toArray()));


    Node root11 = new Node(20);
    root11.left = new Node(8);
    root11.right = new Node(22);
    root11.left.left = new Node(5);
    root11.left.right = new Node(3);
    root11.right.left = new Node(4);
    root11.right.right = new Node(25);
    root11.left.right.left = new Node(10);
    root11.left.right.right = new Node(14);

    System.out.println("Bottom view of the given binary tree:");
    topView(root11);
  }

  private static void topView(Node root) {
    if (root == null) {
      return;
    }
    Map<Integer, Node> topViewMap = new HashMap<>();
    Queue<ObjQueueHelper> queue = new LinkedList<>();
    queue.offer(new ObjQueueHelper(0, root));

    System.out.println("Top View of Binary Tree is :");
    while (!queue.isEmpty()) {
      ObjQueueHelper tempNode = queue.poll();

      if (!topViewMap.containsKey(tempNode.hd)) {
        topViewMap.put(tempNode.hd, tempNode.node);
      }

      if (tempNode.node.left != null) {
        queue.add(new ObjQueueHelper(tempNode.hd - 1, tempNode.node.left));
      }
      if (tempNode.node.right != null) {
        queue.add(new ObjQueueHelper(tempNode.hd + 1, tempNode.node.right));
      }
    }
    for (Entry<Integer, Node> entry : topViewMap.entrySet()) {
      System.out.print(entry.getValue().key + " ");
    }
  }

  private static List<Integer> rightViewDFS(Node node, int level, List<Integer> rightViewList) {
    if (node == null) {
      return null;
    }
    if (maxlevel < level) {
      maxlevel = level;
      rightViewList.add(node.key);
    }
    rightViewDFS(node.right, level + 1, rightViewList);
    rightViewDFS(node.left, level + 1, rightViewList);
    return rightViewList;
  }

  private static void rightViewOnly(Node node) {
    if (node == null) {
      return;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      int n = queue.size();
      for (int i = 1; i <= n; i++) {
        Node tempNode = queue.poll();
        if (i == n) {
          System.out.print(tempNode.key + " ");
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

  private static void leftViewOnly(Node node) {
    if (node == null) {
      return;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      int n = queue.size();
      for (int i = 1; i <= n; i++) {
        Node tempNode = queue.poll();
        if (i == n) {
          System.out.print(tempNode.key + " ");
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

  private static List<Integer> leftViewDFS(Node node, int level, List<Integer> leftViewList) {
    if (node == null) {
      return null;
    }
    if (maxlevel < level) {
      maxlevel = level;
      leftViewList.add(node.key);
    }
    leftViewDFS(node.left, level + 1, leftViewList);
    leftViewDFS(node.right, level + 1, leftViewList);
    return leftViewList;
  }
}
