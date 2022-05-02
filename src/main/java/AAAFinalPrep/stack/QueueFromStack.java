package AAAFinalPrep.stack;

import java.util.Stack;

public class QueueFromStack {

  Stack<Integer> stk1 = new Stack<>();
  Stack<Integer> stk2 = new Stack<>();

  public void enQueue(int num) {
    while (!stk1.isEmpty()) {
      stk2.push(stk1.pop());
    }
    stk1.push(num);
    while (!stk2.isEmpty()) {
      stk1.push(stk2.pop());
    }
  }

  public int deQueue() {
    if (stk1.isEmpty()) {
      System.out.println("Queue is Empty");
    }
    return stk1.pop();
  }


  public static void main(String[] args) {
    QueueFromStack queue = new QueueFromStack();
    queue.enQueue(10);
    queue.enQueue(20);
    queue.enQueue(30);
    queue.deQueue();
    queue.enQueue(40);
    queue.enQueue(50);
  }

}
