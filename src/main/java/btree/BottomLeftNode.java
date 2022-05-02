package btree;

public class BottomLeftNode {

  private static int max_lvl = 0, result;

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.left.left = new Node(7);

    dfs(root, 0);
    System.out.println(result);
  }

  private static void dfs(Node root, int level) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null && max_lvl < level) {
      max_lvl = level;
      result = root.key;
    }
    dfs(root.left, level + 1);
    dfs(root.right, level + 1);
  }

}
