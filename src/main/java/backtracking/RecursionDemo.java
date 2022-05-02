package backtracking;

public class RecursionDemo {

  public static void main(String[] args) {
    int num = 10;
    printNumDecreasingIncreasing(num);
  }

  private static void printNumDecreasingIncreasing(int num) {
    if (num == 0) {
      return;
    }
    System.out.println(num);
    printNumDecreasingIncreasing(num - 1);
    System.out.println(num);
  }

}
