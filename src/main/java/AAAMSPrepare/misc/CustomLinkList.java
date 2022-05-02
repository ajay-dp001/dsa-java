package AAAMSPrepare.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomLinkList {

  static Node head;
  static Node head1;
  static Node head2;
  static Node head3;
  static Node head4;

  private static class Node {

    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static void main(String[] args) {
    CustomLinkList linkList = new CustomLinkList();
    linkList.head = new Node(1);
    linkList.head.next = new Node(2);
    linkList.head.next.next = new Node(3);
    linkList.head.next.next.next = new Node(4);
    linkList.head.next.next.next.next = new Node(5);
    linkList.head.next.next.next.next.next = new Node(6);
    linkList.head.next.next.next.next.next.next = new Node(7);
    linkList.head.next.next.next.next.next.next.next = new Node(8);

    //Loop
    //linkList.head.next.next.next.next.next.next.next.next = linkList.head.next.next.next.next;

    CustomLinkList linkList1 = new CustomLinkList();
    linkList1.head1 = new Node(1);
    linkList1.head1.next = new Node(2);
    linkList1.head1.next.next = new Node(3);
    linkList1.head1.next.next.next = new Node(4);
    linkList1.head1.next.next.next.next = new Node(5);
    linkList1.head1.next.next.next.next.next = new Node(6);
    linkList1.head1.next.next.next.next.next.next = new Node(7);

    //printLinkList(linkList);
    //System.out.println();
    //printMiddle(linkList);

    //printLinkList(linkList1);
    //System.out.println();
    //printMiddle(linkList1);

    //System.out.println("Loop Exist :" + detectLoop(linkList));
    //Intersection of LinkList

    Node headPK = new Node(10);
    headPK.next = new Node(20);
    headPK.next.next = new Node(10);
    headPK.next.next.next = new Node(30);
    headPK.next.next.next.next = new Node(40);
    headPK.next.next.next.next.next = new Node(10);
    headPK.next.next.next.next.next.next = new Node(60);

    System.out.printf("Before moveToEnd(), the Linked list is\n");
    printLinkList2(headPK);

    int key = 10;
    moveToEnd(headPK, key);

    System.out.printf("\nAfter moveToEnd(), the Linked list is\n");
    printLinkList2(headPK);

    /*
    //Node newNode  = reverseLinkList(linkList1);
    //reverseLinkList(newNode);

    System.out.println("********");

    Node head2 = new Node(9);
    head2.next = new Node(5);
    head2.next.next = new Node(9);
    head2.next.next.next = new Node(3);
    head2.next.next.next.next = new Node(2);
    head2.next.next.next.next.next = new Node(9);

    Node head3 = new Node(9);
    head3.next = new Node(5);
    head3.next.next = new Node(9);
    head3.next.next.next = new Node(3);
    head3.next.next.next.next = new Node(2);
    head3.next.next.next.next.next = new Node(9);

    //Node new_node = addTwoNumbers(head2, head3);
    //Node revlst = revLinkList(new_node);
    //printLinkList2(revlst);

    //int kth = 3;
    //int nthNode = nthNodeFromEnd(head1, kth);
    //System.out.println("Nth Node :" + nthNode);

    // printLinkList2(head1);
    // System.out.println();
    // Node revListSizeK = reverseListInSizeK(head1, 2);
    // printLinkList2(revListSizeK);

    // printLinkList2(head1);
    // System.out.println();
    // Node revAlternateListSizeK = reverseAlternateListInSizeK(head1, 2);
    // printLinkList2(revAlternateListSizeK);

    Node head21 = new Node(11);
    head21.next = new Node(16);
    head21.next.next = new Node(19);

    Node head31 = new Node(4);
    head31.next = new Node(12);
    head31.next.next = new Node(13);
    head31.next.next.next = new Node(15);
    head31.next.next.next.next = new Node(20);

    Node mergeNode = mergeSortedList(head21, head31);
    //printLinkList2(mergeNode);

    Node head33 = new Node(11);
    head33.next = new Node(10);
    head33.next.next = new Node(8);
    head33.next.next.next = new Node(7);
    head33.next.next.next.next = new Node(4);
    head33.next.next.next.next.next = new Node(9);
    head33.next.next.next.next.next.next = new Node(0);
    //System.out.println("Original Linked List");
    //printLinkList2(head33);
    //Node node = segregateOddEven(head33);
    //System.out.println("Modified Linked List");
    //printLinkList2(node);

    //Intersection of LinkList

    // list 1
    Node n1 = new Node(1);
    n1.next = new Node(2);
    n1.next.next = new Node(3);
    n1.next.next.next = new Node(4);
    n1.next.next.next.next = new Node(5);
    n1.next.next.next.next.next = new Node(6);
    n1.next.next.next.next.next.next = new Node(7);
    // list 2
    Node n2 = new Node(10);
    n2.next = new Node(9);
    n2.next.next = new Node(8);
    n2.next.next.next = n1.next.next.next;
    //printLinkList2(n1);
    //System.out.println();
    //printLinkList2(n2);
    //System.out.println(intersectPoint(n1, n2).data);

    Node headPK = new Node(10);
    headPK.next = new Node(20);
    headPK.next.next = new Node(10);
    headPK.next.next.next = new Node(30);
    headPK.next.next.next.next = new Node(40);
    headPK.next.next.next.next.next = new Node(10);
    headPK.next.next.next.next.next.next = new Node(60);

    //System.out.printf("Before moveToEnd(), the Linked list is\n");
    //printLinkList2(headPK);

    //int key = 10;
    //moveToEnd(headPK, key);

    //System.out.printf("\nAfter moveToEnd(), the Linked list is\n");
    // printLinkList2(headPK);

    System.out.println();
    Node headRmDup = new Node(23);
    headRmDup.next = new Node(28);
    headRmDup.next.next = new Node(28);
    headRmDup.next.next.next = new Node(35);
    headRmDup.next.next.next.next = new Node(49);
    headRmDup.next.next.next.next.next = new Node(49);
    headRmDup.next.next.next.next.next.next = new Node(53);
    headRmDup.next.next.next.next.next.next.next = new Node(53);
    System.out.printf("Before removeDuplicate(), the Linked list is\n");
    printLinkList2(headRmDup);

    removeDup(headRmDup);

    System.out.printf("\nAfter removeDuplicate(), the Linked list is\n");
    printLinkList2(headRmDup);
     */
  }

  private static void removeDup(Node node) {
    Node dummy = new Node(0);
    dummy.next = node;
    Node prev = dummy;
    Node curr = node;

    while (curr != null) {
      while (curr.next != null && prev.next.data == curr.next.data) {
        curr = curr.next;
      }
      if (prev.next == curr) {
        prev = prev.next;
      } else {
        prev.next = curr.next;
      }
      curr = curr.next;
    }
    head = dummy.next;
  }

  public static void removeDuplicatesKeepOneElementOfDupNodes(Node node) {
    Node currNode = node, prev = node;
    while (currNode != null) {
      if (currNode.data != prev.data) {
        prev.next = currNode;
        prev = currNode;
      }
      currNode = currNode.next;
    }
    if (prev != currNode) {
      prev.next = null;
    }
  }

  public static void unSortedList(Node node) {
    Set<Integer> set = new HashSet<>();
    Node currNode = node, prevNode = null;
    while (currNode != null) {
      int currVal = currNode.data;
      if (set.contains(currVal)) {
        prevNode.next = currNode.next;
      } else {
        set.add(currVal);
        prevNode = currNode;
      }
      currNode = currNode.next;
    }
  }

  private static void moveToEnd(Node head, int key) {
    Node keyNode = head;
    Node node = head;

    while (node != null) {
      if (node != keyNode && node.data != key) {
        keyNode.data = node.data;
        node.data = key;
        keyNode = keyNode.next;
      }

      if (keyNode.data != key) {
        keyNode = keyNode.next;
      }
      node = node.next;
    }
  }

  //IntersectionPoint
  private static Node intersectPoint(Node n1, Node n2) {
    Node ptr1 = n1;
    Node ptr2 = n2;

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
        ptr1 = n1;
      }
      if (ptr2 == null) {
        ptr2 = n2;
      }
    }
    return ptr1;
  }


  //Segregate Odd & Even
  private static Node segregateOddEven(Node node) {
    Node even = null, odd = null, oddTail = null, evenTail = null;
    while (node != null) {
      if (node.data % 2 == 0) {
        if (even == null) {
          even = node;
          evenTail = node;
        } else {
          evenTail.next = node;
          evenTail= evenTail.next;
        }
      } else {
        if (odd == null) {
          odd = node;
          oddTail = node;
        } else {
          oddTail.next = node;
          oddTail = oddTail.next;
        }
      }
      node = node.next;
    }
    if (evenTail != null) {
      evenTail.next = odd;
    }
    if (oddTail != null) {
      oddTail.next = null;
    }
    if (even != null) {
      return even;
    }
    return odd;
  }

  //InPLace
  private static Node mergeSortedList(Node n1, Node n2) {
    Node new_node = null, sort_ptr = null;
    if (n1 == null) {
      return n2;
    }
    if (n2 == null) {
      return n1;
    }
    if (n1.data <= n2.data) {
      sort_ptr = n1;
      n1 = sort_ptr.next;
    } else {
      sort_ptr = n2;
      n2 = sort_ptr.next;
    }
    new_node = sort_ptr;

    while (n1 != null && n2 != null) {
      if (n1.data <= n2.data) {
        sort_ptr.next = n1;
        sort_ptr = n1;
        n1 = sort_ptr.next;
      } else {
        sort_ptr.next = n2;
        sort_ptr = n2;
        n2 = sort_ptr.next;
      }
    }
    if (n1 == null) {
      sort_ptr.next = n2;
    }
    if (n2 == null) {
      sort_ptr.next = n1;
    }
    return new_node;
  }

  private static Node reverseAlternateListInSizeK(Node node, int k) {
    Node prevNode = null, nextNode = null, curr_node = node;
    int cnt = 0;

    while (curr_node != null && cnt < k) {
      nextNode = curr_node.next;
      curr_node.next = prevNode;
      prevNode = curr_node;
      curr_node = nextNode;
      cnt++;
    }

    if (node != null) {
      node.next = curr_node;
    }

    cnt = 0;
    while (cnt < k - 1 && curr_node != null) {
      curr_node = curr_node.next;
      cnt++;
    }

    if (curr_node != null) {
      curr_node.next = reverseAlternateListInSizeK(curr_node.next, k);
    }
    return prevNode;
  }

  private static Node reverseListInSizeK(Node node, int k) {
    if (node == null) {
      return null;
    }
    Node cur_node = node, pre_node = null, next_node = null;
    int cnt = 0;

    while (cur_node != null && cnt < k) {
      next_node = cur_node.next;
      cur_node.next = pre_node;
      pre_node = cur_node;
      cur_node = next_node;
      cnt++;
    }

    if (next_node != null) {
      node.next = reverseListInSizeK(next_node, k);
    }
    return pre_node;
  }

  private static int nthNodeFromEnd(Node node, int kth) {
    Node temp = node;
    int len = 0;

    while (temp != null) {
      temp = temp.next;
      len++;
    }

    if (len < kth) {
      return -1;
    }

    temp = node;

    for (int i = 1; i < len - kth + 1; i++) {
      temp = temp.next;
    }
    return temp.data;
  }

  public static Node addTwoNumbers(Node l1, Node l2) {
    Node dummyHead = new Node(0);
    Node p = l1, q = l2, curr = dummyHead;

    int carry = 0;
    while (p != null || q != null) {
      int x = (p != null) ? p.data : 0;
      int y = (q != null) ? q.data : 0;

      int sum = carry + x + y;
      carry = sum / 10;

      curr.next = new Node(sum % 10);
      curr = curr.next;
      if (p != null) {
        p = p.next;
      }
      if (q != null) {
        q = q.next;
      }
    }
    if (carry > 0) {
      curr.next = new Node(carry);
    }
    return dummyHead.next;
  }

  private static Node addTwoList(Node l1, Node l2) {
    Node dummy_head = new Node(0);
    Node l3 = dummy_head;

    int carry = 0;

    while (l1 != null || l2 != null) {
      int l1_val = (l1 != null) ? l1.data : 0;
      int l2_val = (l2 != null) ? l2.data : 0;

      int cur_sum = l1_val + l2_val + carry;
      carry = cur_sum / 10;
      int last_digit = cur_sum % 10;

      l3.next = new Node(last_digit);

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
      l3 = l3.next;
    }

    if (carry > 0) {
      l3.next = new Node(carry);
    }
    return dummy_head.next;
  }

  private static Node reverseLinkList(CustomLinkList linkList) {
    Node prevNode = null, nextNode = null;
    Node currNode = CustomLinkList.head1;
    while (currNode != null) {
      nextNode = currNode.next;
      currNode.next = prevNode;
      prevNode = currNode;
      currNode = nextNode;
    }
    return prevNode;
  }

  private static Node revLinkList(Node node) {
    Node prevNode = null, nextNode = null;
    Node curNode = node;
    while (curNode != null) {
      nextNode = curNode.next;
      curNode.next = prevNode;
      prevNode = curNode;
      curNode = nextNode;
    }
    return prevNode;
  }

  private static void removeLoop(int count) {
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

  private static boolean detectLoop(CustomLinkList linkList) {
    Node slow_ptr = head;
    Node fst_ptr = head;
    boolean flag = false;
    while (slow_ptr != null && fst_ptr != null && fst_ptr.next != null) {
      slow_ptr = slow_ptr.next;
      fst_ptr = fst_ptr.next.next;
      if (slow_ptr == fst_ptr) {
        System.out.println("Nodes in Loop :" + countNodes(slow_ptr));
        removeLoop(countNodes(slow_ptr));
        flag = true;
        break;
      }
    }
    return flag;
  }

  //Count Nodes in Loop
  private static int countNodes(Node slowPtr) {
    Node tempNode = slowPtr;
    int cnt = 1;
    while (slowPtr.data != tempNode.next.data) {
      cnt++;
      tempNode = tempNode.next;
    }
    return cnt;
  }

  private static void printMiddle(CustomLinkList linkList) {
    Node slow_ptr = head;
    Node fst_ptr = head;

    if (head != null) {
      while (fst_ptr != null && fst_ptr.next != null) {
        slow_ptr = slow_ptr.next;
        fst_ptr = fst_ptr.next.next;
      }
      System.out.println("Middle : " + slow_ptr.data);
    }
  }

  private static void printLinkList(CustomLinkList linkList) {
    Node node = linkList.head1;
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  private static void printLinkList2(Node revNode) {
    Node node = revNode;
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

}
