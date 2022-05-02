package AAAFinalPrep.stack;

public class CustomStack {

  private int top;
  private static final int MAX_SIZE = 100;
  private static final int[] stack = new int[MAX_SIZE];

  public CustomStack() {
    top = -1;
  }

  public boolean isEmpty() {
    return top > 0;
  }

  public boolean push(int num) {
    if (top >= MAX_SIZE - 1) {
      System.out.println("Stack is Full");
      return false;
    }
    stack[++top] = num;
    System.out.println("Added to Stack");
    return true;
  }

  public int pop() {
    if (top < 0) {
      System.out.println("Stack is Empty");
      return 0;
    }
    int num = stack[top--];
    return num;
  }

  public int peek() {
    if (top < 0) {
      System.out.println("Stack is Empty");
      return 0;
    }
    int num = stack[top];
    return num;
  }

}
