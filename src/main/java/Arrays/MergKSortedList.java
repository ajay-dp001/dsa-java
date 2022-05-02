package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergKSortedList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    Comparator<ListNode> cmp = new Comparator<ListNode>() {
      @Override
      public int compare(ListNode ln1, ListNode ln2) {
        return ln1.val - ln2.val;
      }
    };

    Queue<ListNode> queue = new PriorityQueue<>(cmp);

    for (ListNode list : lists) {
      if (list != null) {
        queue.add(list);
      }
    }
    ListNode head = new ListNode(0);
    ListNode point = head;
    while (!queue.isEmpty()) {
      point.next = queue.poll();
      point = point.next;
      ListNode next = point.next;
      if (next != null) {
        queue.add(next);
      }
    }
    return head.next;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(3);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(5);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    ListNode l3 = new ListNode(2);
    l3.next = new ListNode(6);

    ListNode[] listNodes = {l1, l2, l3};
    ListNode newNode = mergeKLists(listNodes);
    while (newNode != null) {
      System.out.print(newNode.val + " ");
      newNode = newNode.next;
    }
  }
}
