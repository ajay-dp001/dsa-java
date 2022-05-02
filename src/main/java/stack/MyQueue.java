package stack;

import java.util.Stack;

public class MyQueue {

  Stack<Integer> s1 = new Stack<>();
  Stack<Integer> s2 = new Stack<>();

  public void enQueue(int num) {
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }

    s1.push(num);

    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
  }

  public int deQueue() {
    if (s1.isEmpty()) {
      System.out.println("Queue is Empty..");
      System.exit(0);
    }
    return s1.pop();
  }


  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.enQueue(1);
    queue.enQueue(2);
    queue.enQueue(3);
    queue.enQueue(4);
    queue.enQueue(5);

    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());

  }
}
