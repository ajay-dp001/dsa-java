package btree;

import java.util.ArrayList;
import java.util.List;

public class AllBinaryTreeFromInOrderTraversal {

  public static void main(String[] args) {
    int[] in = {4, 5, 7};
    int len = in.length;

    List<Node> trees = getTrees(in, 0, len - 1);

    for (int i= 0; i<trees.size(); i++){
      preOrder(trees.get(i));
      System.out.println();
    }
  }

  private static void preOrder(Node node) {
    if(node!=null){
      System.out.print(node.key+ " ");
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  private static List<Node> getTrees(int[] arr, int start, int end) {
    List<Node> trees = new ArrayList<>();
    if (start > end) {
      trees.add(null);
      return trees;
    }
    for (int i = start; i <= end; i++) {
      List<Node> ltrees = getTrees(arr, start, i - 1);
      List<Node> rtrees = getTrees(arr, i + 1, end);
      for (int j = 0; j < ltrees.size(); j++) {
        for (int k = 0; k < rtrees.size(); k++) {
          Node node = new Node(arr[i]);
          node.left = ltrees.get(j);
          node.right = rtrees.get(k);
          trees.add(node);
        }
      }
    }
    return trees;
  }
}
