package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackFromQueue {

  static int curr_size = 0;
  static Queue<Integer> q1 = new LinkedList<>();
  static Queue<Integer> q2 = new LinkedList<>();

  private int peek() {
    if (q1.isEmpty()) {
      return -1;
    }
    return q1.peek();
  }

  private void pop() {
    if (q1.isEmpty()) {
      return;
    }
    q1.remove();
    curr_size--;
  }

  private void push(int num) {
    curr_size++;
    q2.add(num);
    while (!q1.isEmpty()) {
      q2.add(q1.remove());
    }
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
  }

  private int size() {
    return curr_size;
  }

  public static void main(String[] args) {
    StackFromQueue stack = new StackFromQueue();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    System.out.println("current size: " + stack.size());
    System.out.println(stack.peek());
    stack.pop();
    System.out.println(stack.peek());
    stack.pop();
    System.out.println(stack.peek());

    System.out.println("current size: " + stack.size());
  }
}
