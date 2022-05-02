package stack;

import java.util.Stack;

public class MinStack {

  int min;
  private Stack<Integer> stk;

  public int size() {
    return stk.size();
  }

  public MinStack() {
    stk = new Stack<>();
  }

  public void push(int val) {
    if (stk.size() == 0) {
      stk.push(val);
      min = val;
    } else if (val >= min) {
      stk.push(val);
    } else {
      stk.push(val + (val - min));
      min = val;
    }
  }

  public int pop() {
    if (stk.size() == 0) {
      System.out.println("Stack UnderFlow");
      return -1;
    } else {
      if (stk.peek() >= min) {
        return stk.pop();
      } else {
        int oval = min;
        min = 2 * min - stk.pop();
        return oval;
      }
    }
  }

  public int top() {
    if (stk.size() == 0) {
      System.out.println("Stack UnderFlow");
      return -1;
    } else {
      if (stk.peek() >= min) {
        return stk.peek();
      } else {
        return min;
      }
    }
  }

  public int getMin() {
    if (stk.size() == 0) {
      System.out.println("Stack UnderFlow");
      return -1;
    }
    return min;
  }

  public static void main(String[] args) {
    MinStack minStk = new MinStack();
    minStk.push(40);
    minStk.push(20);
    minStk.push(-30);
    minStk.push(50);
    System.out.println(minStk.top());
    System.out.println(minStk.pop());
    minStk.push(19);
    System.out.println(minStk.getMin());
    minStk.push(32);
    minStk.push(17);
    System.out.println(minStk.pop());
    System.out.println(minStk.getMin());
    System.out.println(minStk.top());
  }
}
