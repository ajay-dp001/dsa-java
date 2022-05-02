package btree;

import java.util.HashMap;
import java.util.Map;

public class BTreeFromPreOrderandInOrder {

  static int preIndex;
  static Map<Character, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
    char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
    int len = in.length;

    NodeChar node = buldTreeWrap(in, pre, len);

    //Let us test the built tree by printing Inorder traversal
    System.out.println("Inorder traversal of the constructed tree is");
    printInorder(node);
  }

  private static void printInorder(NodeChar node) {
    if (node != null) {
      printInorder(node.left);
      System.out.print(node.key + " ");
      printInorder(node.right);
    }
  }

  private static NodeChar buldTreeWrap(char[] in, char[] pre, int len) {
    for (int i = 0; i < len; i++) {
      map.put(in[i], i);
    }
    return buldTreeUtil(in, pre, 0, len - 1);
  }

  private static NodeChar buldTreeUtil(char[] in, char[] pre, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }
    char ch = pre[preIndex++];
    NodeChar node = new NodeChar(ch);

    if (inStart == inEnd) {
      return node;
    }

    int inIndex = map.get(ch);
    node.left = buldTreeUtil(in, pre, inStart, inIndex - 1);
    node.right = buldTreeUtil(in, pre, inIndex + 1, inEnd);
    return node;
  }
}
