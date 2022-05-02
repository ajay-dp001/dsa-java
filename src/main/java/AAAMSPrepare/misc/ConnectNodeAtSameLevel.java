package AAAMSPrepare.misc;

import btree.Node;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodeAtSameLevel {

  public static void main(String[] args) {

        /* Constructed binary tree is
             10
            /  \
          8     2
         /
        3
        */
    Node root = new Node(10);
    root.left = new Node(8);
    root.right = new Node(2);
    root.left.left = new Node(3);

    // Populates nextRight pointer in all nodes
    connect(root);

    int a = root.nextRight != null ? root.nextRight.key : -1;
    System.out.println("nextRight of " + root.key + " is " + a);
    int b = root.left.nextRight != null ? root.left.nextRight.key : -1;
    System.out.println("nextRight of " + root.left.key + " is " + b);
    int c = root.right.nextRight != null ? root.right.nextRight.key : -1;
    System.out.println("nextRight of " + root.right.key + " is " + c);
    int d = root.left.left.nextRight != null ? root.left.left.nextRight.key : -1;
    System.out.println("nextRight of " + root.left.left.key + " is " + d);
  }

  private static void connect(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    Node temp = null;
    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Node prev = temp;
        temp = queue.poll();

        if (i > 0) {
          prev.nextRight = temp;
        }
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
      temp.nextRight = null;
    }
  }

}
