package dp;

public class Fibonacci {

  public static void main(String[] args) {
    int num = 8;
    int num2 = 80;
    long[] fibDp = new long[200];
    System.out.println("Result of Fib 8: " + fibonacci(num));
    System.out.println("Result of Fib 8: " + fibonacciIterative(num));
    System.out.println("Result of Fib 80: " + fibonacciDp(num2, fibDp));

  }

  //O(2^N)
  private static int fibonacci(int num) {
    if (num <= 1) {
      return 1;
    }
    return fibonacci(num - 1) + fibonacci(num - 2);
  }

  /*Dp
  1. Top-Down approach is where the cache is filled on fly as a recursive request and
  final solution is build backup on recursive chain.

  2. Bottom-Up approach is where the complete cache is constructed in Phase-one and
  final solution is build in phase-two. Better Examples: 0/1Knapsack Problem
  */
  private static long fibonacciDp(int num, long[] fibDp) {
    if (num <= 1) {
      fibDp[num] = 1;
    }
    if (fibDp[num] == 0) {
      fibDp[num] = fibonacciDp(num - 1, fibDp) + fibonacciDp(num - 2, fibDp);
    }
    return fibDp[num];
  }

  //O(N)
  private static int fibonacciIterative(int num) {
    int low = 0;
    int high = 1;
    for (int i = 0; i < num; i++) {
      System.out.print(low);
      int newHigh = low + high;
      low = high;
      high = newHigh;
    }
    System.out.println();
    return high;
  }

}
