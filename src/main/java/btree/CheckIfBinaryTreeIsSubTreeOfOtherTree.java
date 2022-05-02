package btree;

import java.util.HashSet;
import java.util.Set;

public class CheckIfBinaryTreeIsSubTreeOfOtherTree {

  public static void main(String[] args) {
    // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

    Node root1 = new Node(26);
    root1.right = new Node(3);
    root1.right.right = new Node(3);
    root1.left = new Node(10);
    root1.left.left = new Node(4);
    root1.left.left.right = new Node(30);
    root1.left.right = new Node(6);

    // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

    Node root2 = new Node(10);
    root2.right = new Node(6);
    root2.left = new Node(4);
    root2.left.right = new Node(30);

    if (isSubtree(root1, root2)) {
      System.out.println("Tree 2 is subtree of Tree 1 ");
    } else {
      System.out.println("Tree 2 is not a subtree of Tree 1");
    }
  }

  private static boolean isSubtree(Node n1T, Node n2S) {
    if (n1T == null) {
      return false;
    }
    if (n2S == null) {
      return true;
    }
    if (areIdentical(n1T, n2S)) {
      return true;
    }
    return isSubtree(n1T.left, n2S) || isSubtree(n1T.right, n2S);
  }

  private static boolean areIdentical(Node n1, Node n2) {
    if (n1 == null && n2 == null) {
      return true;
    }
    if (n1 == null || n2 == null) {
      return false;
    }
    return (n1.key == n2.key && areIdentical(n1.left, n2.left) && areIdentical(n1.right, n2.right));
  }

  private static boolean hasDuplicate(Node node) {
    Set<Integer> set = new HashSet<>();
    return hasDuplicateUtil(node, set);
  }

  private static boolean hasDuplicateUtil(Node node, Set<Integer> set) {
    if (node == null) {
      return false;
    }
    if (set.contains(node.key)) {
      return true;
    }
    set.add(node.key);
    return hasDuplicateUtil(node.left, set) || hasDuplicateUtil(node.right, set);
  }
}
