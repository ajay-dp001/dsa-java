package btree;

public class NthNodeInOrderTraversal {

  static int count = 0;

  public static void main(String[] args) {
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(50);
    root.right.left = new Node(60);
    root.right.right = new Node(70);

    int n = 4;
    nthNodeInorder(root, n);
  }

  private static void nthNodeInorder(Node node, int nthNode) {
    if (node != null) {
      if (count <= nthNode) {
        nthNodeInorder(node.left, nthNode);
        count++;
        if (count == nthNode) {
          System.out.print(node.key + " ");
        }
        nthNodeInorder(node.right, nthNode);
      }
    }
  }
}
