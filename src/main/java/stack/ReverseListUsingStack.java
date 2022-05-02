package stack;

import java.util.Stack;

public class ReverseListUsingStack {

  private static class NodeList {

    int data;
    NodeList next;

    NodeList(int data) {
      this.data = data;
    }
  }

  private static NodeList head;

  public static void main(String[] args) {
    push(5);
    push(4);
    push(3);
    push(2);
    push(1);

    head = reverseList(head);
    printList(head);
  }

  private static NodeList reverseList(NodeList head) {
    Stack<NodeList> stk = new Stack<>();
    NodeList ptr = head;
    while (ptr.next != null) {
      stk.push(ptr);
      ptr = ptr.next;
    }
    head = ptr;
    while (!stk.isEmpty()) {
      ptr.next = stk.peek();
      ptr = ptr.next;
      stk.pop();
    }
    ptr.next = null;
    return head;
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

  private static void printList(NodeList node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }
}
