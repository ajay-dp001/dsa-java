package btree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PrintNodeAtKDistance {

  public static void main(String[] args) {
    /* Constructed binary tree is
            1
          /   \
         2     3
        /  \   /
       4    5 8
    */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(8);
    printKDistantFromRoot(root, 2);

    System.out.println("***************************");
    for (Integer node : printKDistantNodeFromGivenNode(root, root.right, 2)) {
      System.out.print(node + " ");
    }

    System.out.println("***************************");
    for (Integer node : printKDistantNodeFromGivenNode(root, root.left.left, 2)) {
      System.out.print(node + " ");
    }
  }

  private static List<Integer> printKDistantNodeFromGivenNode(Node root, Node target, int k) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Map<Node, Node> parentMap = new HashMap<>();
    findParent(root, parentMap);

    Queue<Node> queue = new LinkedList<>();
    Set<Node> visitedSet = new HashSet<>();

    queue.add(target);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node tempNode = queue.poll();
        visitedSet.add(tempNode);

        if (k == 0) {
          result.add(tempNode.key);
        }

        if (parentMap.containsKey(tempNode) && !visitedSet.contains(parentMap.get(tempNode))) {
          queue.add(parentMap.get(tempNode));
        }

        if (tempNode.left != null && !visitedSet.contains(tempNode.left)) {
          queue.add(tempNode.left);
        }
        if (tempNode.right != null && !visitedSet.contains(tempNode.right)) {
          queue.add(tempNode.right);
        }
      }
      k--;
      if (k < 0) {
        break;
      }
    }
    return result;
  }

  private static void findParent(Node root, Map<Node, Node> parentMap) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      parentMap.put(root.left, root);
    }
    if (root.right != null) {
      parentMap.put(root.right, root);
    }
    findParent(root.left, parentMap);
    findParent(root.right, parentMap);
  }

  private static void printKDistantFromRoot(Node node, int k) {
    if (node == null || k < 0) {
      return;
    }
    if (k == 0) {
      System.out.print(node.key + " ");
      return;
    }
    printKDistantFromRoot(node.left, k - 1);
    printKDistantFromRoot(node.right, k - 1);
  }

}
