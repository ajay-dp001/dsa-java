package AAAFinalPrep.stack;

import java.util.Stack;

public class ReverseListUsingStack {

  private static NodeList head;

  private static class NodeList {

    int data;
    NodeList next;

    public NodeList(int data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {
    push(5);
    push(4);
    push(3);
    push(2);
    push(1);
    push(0);

    head = reverseList(head);
    printList(head);
  }

  private static void push(int data) {
    NodeList newNode = new NodeList(data);
    newNode.next = null;
    if (head == null) {
      head = newNode;
    } else {
      NodeList ptr = head;
      while (ptr.next != null) {
        ptr = ptr.next;
      }
      ptr.next = newNode;
    }
  }

  private static NodeList reverseList(NodeList node) {
    Stack<NodeList> stack = new Stack<>();
    NodeList ptr = node;

    while (ptr.next != null) {
      stack.push(ptr);
      ptr = ptr.next;
    }

    head = ptr;
    while (!stack.isEmpty()) {
      ptr.next = stack.pop();
      ptr = ptr.next;
    }
    ptr.next = null;
    return head;
  }

  private static void printList(NodeList node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }
}
