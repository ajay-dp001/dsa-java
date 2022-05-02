package AAAFinalPrep.btree;

import btree.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterative {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.left.left = new Node(7);

    for (int node : postOrderIterative(root)) {
      System.out.print(node + " ");
    }
  }

  private static List<Integer> postOrderIterative(Node root) {
    Stack<Node> stk1 = new Stack<>();
    Stack<Node> stk2 = new Stack<>();
    List<Integer> postOrderList = new ArrayList<>();
    if (root == null) {
      return postOrderList;
    }
    stk1.push(root);
    while (!stk1.isEmpty()) {
      Node tempNode = stk1.pop();
      stk2.push(tempNode);

      if (tempNode.left != null) {
        stk1.push(tempNode.left);
      }

      if (tempNode.right != null) {
        stk1.push(tempNode.right);
      }
    }
    while (!stk2.isEmpty()) {
      postOrderList.add(stk2.pop().key);
    }
    return postOrderList;
  }

}
