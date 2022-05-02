package stack;

import java.util.Stack;

/*
Created Queue Using Stack
 */
public class QueueFromStack {

  private final Stack<Integer> s1 = new Stack<>();
  private final Stack<Integer> s2 = new Stack<>();

  public void enQueue(int x) {
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    s1.push(x);
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
  }

  public int deQueue() {
    if (s1.isEmpty()) {
      System.out.println("Queue is Empty");
      System.exit(0);
    }
    return s1.pop();
  }

  public static void main(String[] args) {
    QueueFromStack queueStack = new QueueFromStack();
    queueStack.enQueue(109);
    queueStack.enQueue(110);
    queueStack.enQueue(111);
    System.out.println(queueStack.deQueue());
  }
}
