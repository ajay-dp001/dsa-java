package btree.practice;

import java.util.HashMap;
import java.util.Map;

public class pracBTreeFromInAndPreOrder {

  private static class NodeChar<V> {

    V val;
    NodeChar left, right;

    public NodeChar(V ch) {
      this.val = ch;
      left = right = null;
    }

  }

  static int preIdx, lvlIdx;
  static Map<Character, Integer> map = new HashMap<>();
  static Map<Integer, Integer> map2 = new HashMap<>();

  public static void main(String[] args) {
    char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
    char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
    int len = in.length;
    NodeChar node = buidTree(in, pre, len);
    System.out.println("Inorder traversal of the constructed tree is");
    printInorder(node);

    //Tree from Level Order
    int inn[] = new int[]{4, 8, 10, 12, 14, 20, 22};
    int levell[] = new int[]{20, 8, 22, 4, 12, 10, 14};
    int ln = inn.length;
    System.out.println();
    NodeChar nodee = constructTree(inn, levell, ln);
    printInorder(nodee);

  }

  private static NodeChar<Integer> constructTree(int[] inn, int[] levell, int ln) {
    for (int i = 0; i < ln; i++) {
      map2.put(levell[i], i);
    }
    return contructFromLevel(inn, levell, 0, ln - 1);
  }

  private static NodeChar<Integer> contructFromLevel(int[] in, int[] lvl, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }
    int in_idx = inStart;

    for (int j = inStart + 1; j < inEnd; j++) {
      if (map.get(in[j]) < map.get(in[in_idx])) {
        in_idx = j;
      }
    }

    int elem = in[in_idx++];
    NodeChar<Integer> node = new NodeChar<Integer>(elem);

    if (inStart == inEnd) {
      return node;
    }
    node.left = contructFromLevel(in, lvl, inStart, in_idx - 1);
    node.right = contructFromLevel(in, lvl, in_idx + 1, inEnd);
    return node;
  }

  private static void printInorder(NodeChar node) {
    if (node != null) {
      printInorder(node.left);
      System.out.print(node.val + " ");
      printInorder(node.right);
    }
  }

  private static NodeChar buidTree(char[] in, char[] pre, int len) {
    for (int i = 0; i < len; i++) {
      map.put(in[i], i);
    }
    return buildTreeUtil(in, pre, 0, len - 1);
  }

  private static NodeChar buildTreeUtil(char[] in, char[] pre, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }

    char ch = pre[preIdx++];
    NodeChar node = new NodeChar(ch);

    if (inStart == inEnd) {
      return node;
    }
    int idx = map.get(ch);
    node.left = buildTreeUtil(in, pre, inStart, idx - 1);
    node.right = buildTreeUtil(in, pre, idx + 1, inEnd);
    return node;
  }

}
