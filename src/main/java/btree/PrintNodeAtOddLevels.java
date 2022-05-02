package btree;

public class PrintNodeAtOddLevels {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    printOddNodes(root, true);
  }

  public static void printOddNodes(Node node, boolean isOdd) {
    if (node == null) {
      return;
    }

    if (isOdd) {
      System.out.print(node.key + " ");
    }

    printOddNodes(node.left, !isOdd);
    printOddNodes(node.right, !isOdd);
  }

}
