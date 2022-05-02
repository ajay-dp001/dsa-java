package AAAFinalPrep.btree;


public class SumOfAllLeafNodes {

  static int sum = 0;

  public static void main(String[] args) {
    BTNode root = new BTNode(1);
    root.left = new BTNode(2);
    root.left.left = new BTNode(4);
    root.left.right = new BTNode(5);
    root.right = new BTNode(3);
    root.right.right = new BTNode(7);
    root.right.left = new BTNode(6);
    root.right.left.right = new BTNode(8);

    BTleafSum(root);
    System.out.println("Sum is : " + sum);
  }

  private static void BTleafSum(BTNode node) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      sum += node.val;
      return;
    }
    BTleafSum(node.left);
    BTleafSum(node.right);
  }

}
