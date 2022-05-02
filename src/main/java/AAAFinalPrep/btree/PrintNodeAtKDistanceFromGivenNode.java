package AAAFinalPrep.btree;

import Arrays.MooreAlgo;
import btree.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PrintNodeAtKDistanceFromGivenNode {

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
    for (int node : printKDistantNodeFromGivenNode(root, root.right, 2)) {
      System.out.print(node + " ");
    }
  }

  private static void printKDistantFromRoot(Node node, int k) {
    if (node == null || k < 0) {
      return;
    }
    if (k == 0) {
      System.out.print(node.key + " ");
    }
    printKDistantFromRoot(node.left, k - 1);
    printKDistantFromRoot(node.right, k - 1);
  }

  private static List<Integer> printKDistantNodeFromGivenNode(Node node, Node srcNode, int k) {
    List<Integer> result = new ArrayList<>();

    Map<Node, Node> parentMap = new HashMap<>();

    findParent(node, parentMap);

    Queue<Node> queue = new LinkedList<>();
    queue.add(srcNode);

    Set<Node> visited = new HashSet<>();

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node tempNode = queue.poll();

        visited.add(tempNode);

        if (k == 0) {
          result.add(tempNode.key);
        }
        if (parentMap.containsKey(tempNode) && !visited.contains(parentMap.get(tempNode))) {
          queue.add(parentMap.get(tempNode));
        }
        if (tempNode.left != null && !visited.contains(tempNode.left)) {
          queue.add(tempNode.left);
        }
        if (tempNode.right != null && !visited.contains(tempNode.right)) {
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

  private static void findParent(Node node, Map<Node, Node> parentMap) {
    if (node == null) {
      return;
    }
    if (node.left != null) {
      parentMap.put(node.left, node);
    }
    if (node.right != null) {
      parentMap.put(node.right, node);
    }
    findParent(node.left, parentMap);
    findParent(node.right, parentMap);
  }

}
