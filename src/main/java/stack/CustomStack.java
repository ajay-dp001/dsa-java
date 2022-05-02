package stack;

public class CustomStack {

  int top;
  static final int MAX_SIZE = 100;
  int stack[] = new int[MAX_SIZE];

  public CustomStack() {
    top = -1;
  }

  public boolean isEmpty() {
    return (top > 0);
  }

  public boolean push(int x) {
    if (top >= MAX_SIZE - 1) {
      System.out.println("Stack Overflow..");
      return false;
    }
    stack[++top] = x;
    System.out.println(x + " Added to Stack");
    return true;
  }

  public int pop() {
    if (top < 0) {
      System.out.println("Stack UnderFlow..");
      return 0;
    }
    int x = stack[top--];
    return x;
  }

  public int peek() {
    if (top < 0) {
      System.out.println("Stack UnderFlow..");
      return 0;
    }
    int x = stack[top];
    return x;
  }

  public static void main(String[] args) {
    CustomStack customStack = new CustomStack();
    customStack.push(10);
    customStack.push(20);
    System.out.println(customStack.pop());
    System.out.println(customStack.peek());
    System.out.println(customStack.pop());
  }
}
