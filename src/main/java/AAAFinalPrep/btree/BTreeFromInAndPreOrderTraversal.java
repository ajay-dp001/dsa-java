package AAAFinalPrep.btree;

import btree.NodeChar;
import com.google.inject.internal.BindingImpl;
import java.util.HashMap;
import java.util.Map;

public class BTreeFromInAndPreOrderTraversal {

  public static int preIndex = 0;
  public static final Map<Character, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    char[] in = {'D', 'B', 'E', 'A', 'F', 'C'};
    char[] pre = {'A', 'B', 'D', 'E', 'C', 'F'};
    int len = in.length;

    NodeChar node = buldTreeWrap(in, pre, len);

    //Let us test the built tree by printing Inorder traversal
    System.out.println("Inorder traversal of the constructed tree is");
  }

  private static NodeChar buldTreeWrap(char[] in, char[] pre, int len) {
    for (int i = 0; i < len; i++) {
      map.put(in[i], i);
    }
    return buldTreeWrapUtil(in, pre, 0, len - 1);
  }

  private static NodeChar buldTreeWrapUtil(char[] in, char[] pre, int inStart, int inEnd) {
    if (inStart > inEnd) {
      return null;
    }

    char ch = pre[preIndex++];
    NodeChar node = new NodeChar(ch);
    if (inStart == inEnd) {
      return node;
    }

    int inIndex = map.get(ch);
    node.left = buldTreeWrapUtil(in, pre, inStart, inIndex - 1);
    node.right = buldTreeWrapUtil(in, pre, inIndex + 1, inEnd);
    return node;
  }

}
