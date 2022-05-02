package misc;

public class Fibonacci {

  public static void main(String[] args) {
    System.out.println(fib(9));
  }

  private static int fib(int num) {
    if (num <= 1) {
      return num;
    }
    return fib(num - 1) + fib(num - 2);
  }
}
