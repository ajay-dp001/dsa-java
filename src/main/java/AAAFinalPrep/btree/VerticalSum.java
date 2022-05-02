package AAAFinalPrep.btree;

import btree.Node;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {

  public static void main(String[] args) {
    BTNode root = new BTNode(1);
    root.left = new BTNode(2);
    root.right = new BTNode(3);
    root.left.left = new BTNode(4);
    root.left.right = new BTNode(5);
    root.left.left.left = new BTNode(7);
    verticalSum(root);
  }

  private static void verticalSum(BTNode node) {
    final Map<Integer, Integer> map = new TreeMap<>();
    verticalSumUtil(node, map, 0);
    System.out.println(map.entrySet());
  }

  private static void verticalSumUtil(BTNode node, Map<Integer, Integer> hmap, int hd) {
    if (node == null) {
      return;
    }
    int prevSum = hmap.get(hd) == null ? 0 : hmap.get(hd);
    hmap.put(hd, prevSum + node.val);

    verticalSumUtil(node.left, hmap, hd - 1);
    verticalSumUtil(node.right, hmap, hd + 1);
  }

}
