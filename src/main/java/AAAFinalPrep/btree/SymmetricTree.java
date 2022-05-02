package AAAFinalPrep.btree;

public class SymmetricTree {

  public static void main(String[] args) {
    BTNode root = new BTNode(1);

    root.left = new BTNode(2);
    root.left.left = new BTNode(3);
    root.left.right = new BTNode(4);

    root.right = new BTNode(2);
    root.right.left = new BTNode(4);
    root.right.right = new BTNode(3);

    System.out.println("Tree is Symmetric: " + BTIsSymmetric(root));
  }

  private static boolean BTIsSymmetric(BTNode root) {
    return root == null || isSymmetricUtil(root.left, root.right);
  }

  private static boolean isSymmetricUtil(BTNode btNodeLeft, BTNode btNodeRight) {
    if (btNodeLeft == null || btNodeRight == null) {
      return (btNodeLeft == btNodeRight);
    }
    if (btNodeLeft.val != btNodeRight.val) {
      return false;
    }

    return isSymmetricUtil(btNodeLeft.left, btNodeRight.right) && isSymmetricUtil(btNodeLeft.right,
        btNodeRight.left);
  }

}
