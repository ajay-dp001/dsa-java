package AAAMSPrepare.misc;

import btree.Node;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import linklist.LinkList;

public class SerializeDeserializeBinaryTree {

  public static void main(String[] args) {
    Node root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(22);
    root.left.left = new Node(4);
    root.left.right = new Node(12);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);

    String serialized = serialize(root);
    System.out.println("Serialized view of the tree:");
    System.out.println(serialized);
    System.out.println();

    // Let us deserialize the stored tree into root1
    Node node = deserialize(serialized);

    System.out.println("Inorder Traversal of the tree constructed from serialized String:");
    inorder(node);
  }

  private static void inorder(Node node) {
    if (node != null) {
      inorder(node.left);
      System.out.print(node.key + " ");
      inorder(node.right);
    }
  }

  private static String serialize(Node node) {
    if (node == null) {
      return null;
    }
    List<String> resultList = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      Node temp = stack.pop();
      if (temp == null) {
        resultList.add("#");
      } else {
        resultList.add("" + temp.key);
        stack.push(temp.right);
        stack.push(temp.left);
      }
    }
    return String.join(",", resultList);
  }

  static int cnt = 0;

  private static Node deserialize(String data) {
    if (data == null) {
      return null;
    }
    String[] strArr = data.split(",");
    return helper(strArr);
  }

  private static Node helper(String[] strArr) {
    if (strArr[cnt].equals("#")) {
      return null;
    }
    Node node = new Node(Integer.parseInt(strArr[cnt]));
    cnt++;
    node.left = helper(strArr);
    cnt++;
    node.right = helper(strArr);
    return node;
  }

}
