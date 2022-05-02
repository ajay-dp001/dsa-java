package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackFromQueue {

  static int currSize;
  static private Queue<Integer> q1 = new LinkedList<>();
  static private Queue<Integer> q2 = new LinkedList<>();

  public StackFromQueue() {
    currSize = 0;
  }

  public void push(int data) {
    currSize++;
    q2.add(data);
    while (!q1.isEmpty()) {
      q2.add(q1.remove());
    }
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;
  }

  public void pop() {
    if (q1.isEmpty()) {
      return;
    }
    q1.remove();
    currSize--;
  }

  public void pushSingleQueue(int data) {
    int size = q1.size();
    q1.add(data);
    currSize++;
    for (int i = 0; i < size; i++) {
      q1.add(q1.remove());
    }
  }

  public int popSingleQueue() {
    if (q1.isEmpty()) {
      System.out.println("No Element");
      return -1;
    }
    currSize--;
    return q1.remove();
  }

  public static void main(String[] args) {
    StackFromQueue stack = new StackFromQueue();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.pop();
    System.out.println(StackFromQueue.currSize);
    stack.pop();
    stack.pop();

    stack.pushSingleQueue(10);
    stack.pushSingleQueue(20);
    stack.pushSingleQueue(100);
    stack.popSingleQueue();
    System.out.println(StackFromQueue.currSize);


  }

}
