package btree;

public class DiameterOfTree {

  public static void main(String[] args) {
    Node root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(22);

    root.left.left = new Node(4);
    root.left.right = new Node(12);

    root.right.right = new Node(25);

    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);

    System.out.println(diamOfTree(root));
    System.out.println(maxPathSum(root));
  }

  private static int diamOfTree(Node root) {
    int[] arr = new int[1];
    diamOfTreeUtil(root, arr);
    return arr[0];
  }

  private static int diamOfTreeUtil(Node node, int[] arr) {
    if (node == null) {
      return 0;
    }
    int lh = diamOfTreeUtil(node.left, arr);
    int rh = diamOfTreeUtil(node.right, arr);
    arr[0] = Math.max(arr[0], lh + rh);
    return Math.max(lh, rh) + 1;
  }

  private static int maxPathSum(Node node) {
    int[] maxPath = new int[1];
    maxPath[0] = Integer.MIN_VALUE;
    maxPathSumUtil(node, maxPath);
    return maxPath[0];
  }

  private static int maxPathSumUtil(Node node, int[] maxPath) {
    if (node == null) {
      return 0;
    }
    int ls = maxPathSumUtil(node.left, maxPath);
    int rs = maxPathSumUtil(node.right, maxPath);
    maxPath[0] = Math.max(maxPath[0], ls + rs + node.key);
    return Math.max(ls, rs) + node.key;
  }

}
