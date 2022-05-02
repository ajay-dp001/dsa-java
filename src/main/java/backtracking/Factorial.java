package backtracking;

public class Factorial {

  public static void main(String[] args) {
    int num = 5;
    System.out.println("Factorial is : " + factorial(num));

    System.out.println("Print ZigZag : ");
    printZigZag(num);

    System.out.println("Display Array");
    int idx = 0;
    int[] arr = {1, 2, 3, 4, 5, 6};
    displayArray(arr, idx);
  }

  private static void displayArray(int[] arr, int idx) {
    if (idx == arr.length) {
      return;
    }
    System.out.print(arr[idx] + " ");
    displayArray(arr, idx + 1);
  }

  private static int factorial(int num) {
    if (num == 1) {
      return num;
    }
    return num * factorial(num - 1);
  }

  public static void printZigZag(int num) {
    if (num == 0) {
      return;
    }
    System.out.println("Pre Out :" + num);
    printZigZag(num - 1);
    System.out.println("Pre IN : " + num);
    printZigZag(num - 1);
    System.out.println("Post Out:" + num);
  }
}
