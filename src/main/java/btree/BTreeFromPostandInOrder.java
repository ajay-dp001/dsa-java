package btree;

import java.util.HashMap;
import java.util.Map;

public class BTreeFromPostandInOrder {

  static int postIdx;
  static Map<Integer, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    int in[] = {4, 8, 2, 5, 1, 6, 3, 7};
    int post[] = {8, 4, 5, 2, 6, 7, 3, 1};
    int n = in.length;
    Node root = buildTree(in, post, n);
    System.out.print("Preorder of the constructed tree : \n");
    preOrder(root);
  }

  private static void preOrder(Node root) {
    if (root != null) {
      System.out.print(root.key + " ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  private static Node buildTree(int[] in, int[] post, int len) {
    for (int i = 0; i < len; i++) {
      map.put(in[i], i);
    }
    postIdx = len - 1;
    return buildUtil(in, post, 0, len - 1);
  }

  private static Node buildUtil(int[] in, int[] post, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }
    int curr_node = post[postIdx--];
    Node node = new Node(curr_node);

    if (inStart == inEnd) {
      return node;
    }
    int iIndex = map.get(curr_node);
    node.left = buildUtil(in, post, inStart, iIndex - 1);
    node.right = buildUtil(in, post, iIndex + 1, inEnd);
    return node;
  }

}
