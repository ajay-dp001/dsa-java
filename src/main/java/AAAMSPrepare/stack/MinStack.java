package AAAMSPrepare.stack;

import java.util.Stack;

public class MinStack<T> {

  private int min;
  private Stack<Integer> stack;

  public MinStack() {
    this.stack = new Stack<>();
  }

  public void push(int data) {
    if (stack.isEmpty()) {
      stack.push(data);
      min = data;
    } else if (data >= min) {
      stack.push(data);
    } else {
      stack.push(data + (data - min));
      min = data;
    }
  }

  public int pop() {
    if (stack.isEmpty()) {
      System.out.println("Stack UnderFlow");
      return -1;
    } else {
      if (stack.peek() >= min) {
        return stack.pop();
      } else {
        int originalVal = min;
        min = 2 * min - stack.pop();
        return originalVal;
      }
    }
  }

  public int top() {
    if (stack.isEmpty()) {
      System.out.println("Stack UnderFlow");
      return -1;
    } else {
      if (stack.peek() >= min) {
        return stack.peek();
      } else {
        return min;
      }
    }
  }

  public static void main(String[] args) {
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(4);
    minStack.push(3);
    minStack.push(2);
    minStack.push(1);
    minStack.pop();
    minStack.pop();
    minStack.pop();
  }

}
