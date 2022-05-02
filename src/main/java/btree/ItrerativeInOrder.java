package btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ItrerativeInOrder {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.left.left = new Node(7);

    for (Node node : iterativeInOrder(root)) {
      System.out.print(node.key + " ");
    }
  }


  private static List<Node> iterativeInOrder(Node node) {
    Stack<Node> stack = new Stack<>();
    List<Node> inOrderList = new ArrayList<>();
    while (true) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        if (stack.isEmpty()) {
          break;
        }
        node = stack.pop();
        inOrderList.add(node);
        node = node.right;
      }
    }
    return inOrderList;
  }

}
