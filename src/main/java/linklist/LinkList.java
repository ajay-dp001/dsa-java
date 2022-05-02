package linklist;

public class LinkList {

  Node head;

  public static class Node {

    public int data;
    public Node next;

    public Node(int data) {
      this.data = data;
      next = null;
    }
  }

  private void printList() {
    Node node = head;
    while (node != null) {
      System.out.println(" Node data is : " + node.data);
      node = node.next;
    }
  }

  private void printMiddle() {
    Node slw_ptr = head;
    Node fst_ptr = head;

    if (head != null) {
      while (fst_ptr != null && fst_ptr.next != null) {
        fst_ptr = fst_ptr.next.next;
        slw_ptr = slw_ptr.next;
      }

      System.out.println("Middle Eelement is: " + slw_ptr.data);
    }
  }

  private int countNodes(Node node) {
    int count = 1;
    Node temp = node;
    while (temp.next.data != node.data) {
      count++;
      temp = temp.next;
    }
    return count;
  }

  private void removeLoop(int count) {
    Node ptr1 = head;
    Node ptr2 = head;
    for (int i = 0; i < count; i++) {
      ptr2 = ptr2.next;
    }
    while (ptr1 != ptr2) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }

    while (ptr2.next != ptr1) {
      ptr2 = ptr2.next;
    }

    ptr2.next = null;
  }

  private void detectLoop() {
    Node slw_ptr = head;
    Node fst_ptr = head;
    boolean flag = false;
    while (slw_ptr != null && fst_ptr != null && fst_ptr.next != null) {
      slw_ptr = slw_ptr.next;
      fst_ptr = fst_ptr.next.next;
      if (slw_ptr == fst_ptr) {
        System.out.println("Loop consist of Nodes: " + countNodes(slw_ptr));
        removeLoop(countNodes(slw_ptr));
        flag = true;
        break;
      }
    }
    if (flag) {
      System.out.println("Loop Exist..!!");
    } else {
      System.out.println("No Loop exist.!");
    }
  }

  public static void main(String[] args) {
    LinkList llist = new LinkList();
    llist.head = new Node(1);
    llist.head.next = new Node(2);
    llist.head.next.next = new Node(3);
    llist.head.next.next.next = new Node(4);
    llist.head.next.next.next.next = new Node(5);
    llist.head.next.next.next.next.next = new Node(6);
    llist.head.next.next.next.next.next.next = new Node(7);
    llist.head.next.next.next.next.next.next.next = new Node(8);
    llist.head.next.next.next.next.next.next.next.next = new Node(9);
    llist.head.next.next.next.next.next.next.next.next.next = new Node(10);
    llist.head.next.next.next.next.next.next.next.next.next.next = new Node(11);
    llist.head.next.next.next.next.next.next.next.next.next.next.next = new Node(12);
    llist.head.next.next.next.next.next.next.next.next.next.next.next.next = new Node(13);
    llist.head.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(14);

    //Create Loop
    llist.head.next.next.next.next.next.next.next.next.next.next.next.next.next.next = llist.head.next.next.next.next.next;

    // llist.printList();
    // llist.printMiddle();
    llist.detectLoop();
    llist.printList();

    LinkList llist11 = new LinkList();
    llist.head = new Node(1);
    llist.head.next = new Node(2);
    llist.head.next.next = new Node(3);
    llist.head.next.next.next = new Node(4);
    llist.head.next.next.next.next = new Node(5);
    llist.head.next.next.next.next.next = new Node(6);

    LinkList llist22 = new LinkList();
    llist.head = new Node(1);
    llist.head.next = new Node(2);
    llist.head.next.next = new Node(3);
    llist.head.next.next.next = new Node(4);
    llist.head.next.next.next.next = new Node(5);
    llist.head.next.next.next.next.next = new Node(6);
    //addTwoNumber(llist11, llist22);
  }
}
