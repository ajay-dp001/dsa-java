package queue;

import java.util.Stack;

public class QueueFromStack {
  static Stack<Integer> s1 = new Stack<>();
  static Stack<Integer> s2 = new Stack<>();

  private int deQueue() {
    if (s1.isEmpty()){
      System.out.println("Queue is Empty");
      System.exit(0);
    }
    return s1.pop();
  }

  private void enQueue(int num) {
    while (!s1.isEmpty()){
      s2.push(s1.pop());
    }
    s1.push(num);
    while (!s2.isEmpty()){
      s1.push(s2.pop());
    }
  }

  public static void main(String[] args) {
    QueueFromStack queue = new QueueFromStack();
    queue.enQueue(10);
    queue.enQueue(20);
    queue.enQueue(30);
    queue.enQueue(40);
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
  }
}
