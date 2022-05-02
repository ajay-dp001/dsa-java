package AAAMSPrepare.misc;

public class CloneLinkListWithRandomPointer {

  private static class Node {

    int data;
    Node next, random;

    public Node(int data) {
      this.data = data;
      this.next = this.random = null;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    // 1's random points to 3
    head.random = head.next.next;

    // 2's random points to 1
    head.next.random = head;

    // 3's and 4's random points to 5
    head.next.next.random = head.next.next.next.next;
    head.next.next.next.random = head.next.next.next.next;

    // 5's random points to 2
    head.next.next.next.next.random = head.next;

    System.out.println("Original list : ");
    print(head);

    System.out.println("Cloned list : ");
    Node cloned_list = clone(head);
    print(cloned_list);
  }

  private static Node clone(Node node) {
    Node curr = node, temp = null;

    while (curr != null) {
      temp = curr.next;
      curr.next = new Node(curr.data);
      curr.next.next = temp;
      curr = temp;
    }

    //Link Random Pointers
    curr = node;
    while (curr != null) {
      if (curr.next != null) {
        curr.next.random = (curr.random != null) ? curr.random.next : null;
      }
      curr = curr.next.next;
    }

    Node original = node, copy = node.next;
    temp = copy;

    // Separate Original and Copy list
    while (original != null) {
      original.next = original.next.next;
      copy.next = (copy.next != null) ? copy.next.next : null;
      original = original.next;
      copy = copy.next;
    }
    return temp;
  }

  private static void print(Node node) {
    Node tempNode = node;
    while (tempNode != null) {
      System.out.println("Data = " + tempNode.data + " Random Pointer: " + tempNode.random.data);
      tempNode = tempNode.next;
    }
  }

}
