package btree;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);

    root.left.right = new Node(5);
    root.left.left.left = new Node(7);
    verticalSumUsingHashMap(root);
  }

  private static void verticalSumUsingHashMap(Node root) {
    if (root == null) {
      return;
    }
    Map<Integer, Integer> hMap = new TreeMap<>();
    verticalSumUsingHashMapUtil(root, 0, hMap);
    System.out.println(hMap.entrySet());
  }

  private static void verticalSumUsingHashMapUtil(Node root, int hd, Map<Integer, Integer> hMap) {
    if (root == null) {
      return;
    }
    verticalSumUsingHashMapUtil(root.left, hd - 1, hMap);
    int prvSum = (hMap.get(hd) == null) ? 0 : hMap.get(hd);
    hMap.put(hd, prvSum + root.key);

    verticalSumUsingHashMapUtil(root.right, hd + 1, hMap);
  }
}
