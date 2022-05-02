package AAAFinalPrep.linkList;


public class CheckIfPalindrome {

  static Node tempNodeHead;

  private static class Node {

    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      next = null;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(3);
    head.next.next.next.next.next = new Node(2);
    head.next.next.next.next.next.next = new Node(1);
    //System.out.println(isPalindrome(head));


    Node head1 = new Node(1);
    head1.next = new Node(2);
    head1.next.next = new Node(2);
    head1.next.next.next = new Node(1);
    System.out.println(isPalindrome(head1));
  }

  private static boolean isPalindrome(Node head) {
    Node slow_ptr = head;
    Node fast_ptr = head;

    Node prev_slow_ptr = null, mind_node = null, sec_half = null;

    boolean result = false;

    if (head != null && head.next != null) {

      while (fast_ptr != null && fast_ptr.next != null) {
        prev_slow_ptr = slow_ptr;
        slow_ptr = slow_ptr.next;
        fast_ptr = fast_ptr.next.next;
      }

      if (fast_ptr != null) {
        mind_node = slow_ptr;
        slow_ptr = slow_ptr.next;
      }

      sec_half = slow_ptr;
      prev_slow_ptr.next = null;
      sec_half = reverse(sec_half);
      result = checkIfEqual(head, sec_half);
      sec_half = reverse(sec_half);

      if (mind_node != null) {
        prev_slow_ptr.next = mind_node;
        mind_node.next = sec_half;
      } else {
        prev_slow_ptr.next = sec_half;
      }
    }
    return result;
  }

  private static Node reverse(Node node) {

    Node prev_node = null;
    Node curr_node = node;
    Node next_node = null;

    while (curr_node != null) {
      next_node = curr_node.next;
      curr_node.next = prev_node;
      prev_node = curr_node;
      curr_node = next_node;
    }
    return prev_node;
  }

  private static boolean checkIfEqual(Node node1, Node node2) {
    while (node1.next != null && node2.next != null) {
      if (node1.data != node2.data) {
        return false;
      }
      node1 = node1.next;
      node2 = node2.next;
    }
    return true;
  }
}
