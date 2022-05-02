package linklist;

public class DoublyLinkList {

  private int size;
  private Node head;
  private Node tail;

  private static class Node {

    private int data;
    private Node next;
    private Node prev;

    public Node(int data) {
      this.data = data;
    }

    public void displayNode() {
      System.out.println("{ " + data + " }");
    }
  }

  public boolean isEmpty() {
    return (head == null);
  }

  public void insertFirst(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    newNode.prev = null;
    if (head != null) {
      head.prev = newNode;
    }
    head = newNode;
    if (tail == null) {
      tail = newNode;
    }
    size++;
  }

  public void insertLast(int data) {
    Node newNode = new Node(data);
    newNode.next = null;
    newNode.prev = tail;
    if (tail != null) {
      tail.next = newNode;
    }
    tail = newNode;
    if (head == null) {
      head = newNode;
    }
    size++;
  }

  public Node deleteFirst() {
    if (size == 0) {
      throw new RuntimeException("DoublyLinkedList is already Empty");
    }
    Node temp = head;
    head = head.next;
    head.prev = null;
    size--;
    return temp;
  }

  public Node deleteLast() {
    if (size == 0) {
      throw new RuntimeException("DoublyLinkedList is already Empty");
    }
    Node temp = tail;
    tail = tail.prev;
    tail.next = null;
    size--;
    return temp;
  }

  public void deleteAfter(Node node) {
    Node temp = head;
    while (temp != null || temp.data != node.data) {
      temp = temp.next;
    }
    if (temp.next != null) {

    }
  }

  public void printLinkedListForward() {
    System.out.println("Printing LinkedList Head --> Tail");
    Node curr = head;
    while (curr != null) {
      curr.displayNode();
      curr = curr.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    DoublyLinkList dll = new DoublyLinkList();
    dll.insertFirst(10);
    dll.insertFirst(20);
    dll.insertFirst(30);
    dll.insertFirst(40);
    dll.insertFirst(50);
    dll.insertFirst(60);
    dll.insertFirst(70);
    dll.printLinkedListForward();
    Node node = new Node(50);
    dll.deleteAfter(node);
    dll.printLinkedListForward();
    dll.printLinkedListBackward();
    // After deleting node after 1,doubly Linked list will be
    // 2 -> 1 -> 6 -> 5
    System.out.println("================");
    dll.deleteFirst();
    dll.deleteLast();

    // After performing above operation, doubly Linked list will be
    //  6 -> 5
    dll.printLinkedListForward();
    dll.printLinkedListBackward();

  }

  private void printLinkedListBackward() {
  }
}
