package AAAFinalPrep.linkList;

public class CustomLinkList {

  public static Node head;

  private static class Node {

    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      next = null;
    }
  }

  public static void main(String[] args) {
    CustomLinkList llist = new CustomLinkList();
    llist.head = new CustomLinkList.Node(1);
    llist.head.next = new CustomLinkList.Node(2);
    llist.head.next.next = new CustomLinkList.Node(3);
    llist.head.next.next.next = new CustomLinkList.Node(4);

    llist.head.next.next.next.next = new CustomLinkList.Node(5);
    llist.head.next.next.next.next.next = new CustomLinkList.Node(6);
    //Loop 6-4
    llist.head.next.next.next.next.next.next = llist.head.next.next.next;
    //llist.head.next.next.next.next.next.next = new CustomLinkList.Node(7);
    // llist.head.next.next.next.next.next.next.next = new CustomLinkList.Node(8);
    //llist.head.next.next.next.next.next.next.next.next = new CustomLinkList.Node(9);
    //llist.head.next.next.next.next.next.next.next.next.next = new CustomLinkList.Node(10);
    //llist.head.next.next.next.next.next.next.next.next.next.next = new CustomLinkList.Node(11);
    //llist.head.next.next.next.next.next.next.next.next.next.next.next = new CustomLinkList.Node(12);
    //llist.head.next.next.next.next.next.next.next.next.next.next.next.next = new CustomLinkList.Node(13);
    //llist.head.next.next.next.next.next.next.next.next.next.next.next.next.next = new CustomLinkList.Node(14);
    //llist.head.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new CustomLinkList.Node(15);

    //Create Loop
    //llist.head.next.next.next.next.next.next.next.next.next.next.next.next.next.next = llist.head.next.next.next.next.next;

    //llist.printList();
    //llist.printMiddle();
    //llist.reverseLinkList(head);
    //head = llist.reverseLinkListInGroup(head, 4);
    //head = llist.revNodeInGroupsOfK(head, 4);
    //llist.rotateLinkList(head, 4);
    llist.printList();
    llist.detectLoop();
    //llist.intersectPoint(Node head1, Node head2);

  }

  private static int countNodes(Node node) {
    int cnt = 1;
    Node tempNode = node;
    while (tempNode.next.data != node.data) {
      tempNode = tempNode.next;
      cnt++;
    }
    return cnt;
  }

  private static void removeLoop(int loopNodeCount) {
    Node ptr1 = head;
    Node ptr2 = head;
    for (int i = 0; i < loopNodeCount; i++) {
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

  private static void detectLoop() {
    Node sptr = head;
    Node fptr = head;
    boolean falg = false;
    while (sptr != null && fptr != null && fptr.next != null) {
      sptr = sptr.next;
      fptr = fptr.next.next;
      if (sptr == fptr) {
        System.out.println("Loop Exist");
        System.out.println("Loop Consist Of Nodes " + countNodes(sptr));
        removeLoop(countNodes(sptr));
        falg = true;
        break;
      }
    }

  }

  private static Node intersectPoint(Node head1, Node head2) {
    Node ptr1 = head1;
    Node ptr2 = head2;

    if (ptr1 == null || ptr2 == null) {
      return null;
    }

    while (ptr1 != ptr2) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;

      if (ptr1 == ptr2) {
        return ptr1;
      }

      if (ptr1 == null) {
        ptr1 = head1;
      }
      if (ptr2 == null) {
        ptr2 = head2;
      }
    }

    return ptr1;
  }

  private static Node revNodeInGroupsOfK(Node head, int k) {
    if (k == 0) {
      return head;
    }

    Node curr = head, prev = null, next = null;
    int cnt = 0;
    while (cnt < k && curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      cnt++;
    }

    if (next != null) {
      head.next = revNodeInGroupsOfK(curr, k);
    }
    return head;
  }

  public static Node reverseLinkListInGroup(Node head, int k) {
    if (head == null) {
      return null;
    }
    Node currNode = head;
    Node prev = null, next = null;

    int cnt = 0;
    while (cnt < k && currNode != null) {
      next = currNode.next;
      currNode.next = prev;
      prev = currNode;
      currNode = next;
      cnt++;
    }

    if (next != null) {
      head.next = reverseLinkListInGroup(currNode, k);
    }
    return prev;
  }

  private static void rotLinkList(int k) {
    if (k == 0) {
      return;
    }

    Node currNode = head;
    while (currNode.next != null) {
      currNode = currNode.next;
    }
    currNode.next = head;
    currNode = head;

    for (int i = 0; i < k - 1; i++) {
      currNode = currNode.next;
    }
    head = currNode.next;
    currNode.next = null;
  }

  private static void rotateLinkList(Node currNode, int k) {
    if (k == 0) {
      return;
    }
    Node current = head;

    // Traverse till the end.
    while (current.next != null) {
      current = current.next;
    }
    current.next = head;

    // traverse the linked list to k-1 position which
    // will be last element for rotated array.
    current = head;
    for (int i = 0; i < k - 1; i++) {
      current = current.next;
    }

    // update the head_ref and last element pointer to null
    head = current.next;
    current.next = null;
  }

  private static Node reverseLinkList(Node head) {
    //return reverseLinkListUtil(head, null);
    return revLinkList(head, null);
  }

  private static Node reverseLinkListUtil(Node curr, Node prev) {
    if (head == null) {
      return head;
    }
    if (curr.next == null) {
      head = curr;
      curr.next = prev;
      return head;
    }
    Node tempNode = curr.next;
    curr.next = prev;
    reverseLinkListUtil(tempNode, curr);
    return head;
  }

  private static Node revList(Node node) {
    Node currNode = node;
    Node prev = null, next = null;
    while (currNode != null) {
      next = currNode.next;
      currNode.next = prev;
      prev = currNode;
      currNode = next;
    }
    return prev;
  }


  private static Node revLinkList(Node curr, Node prev) {
    if (curr.next == null) {
      head = curr;
      curr.next = prev;
      return head;
    }
    Node tempNode = curr.next;
    curr.next = prev;
    revLinkList(tempNode, curr);
    return head;
  }

  private static void printList() {
    Node node = head;
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  public static void printMiddle() {
    Node slowPtr = head, fastPtr = head;
    while (fastPtr != null && fastPtr.next != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next.next;
    }
    System.out.println(slowPtr.data);
  }

}
