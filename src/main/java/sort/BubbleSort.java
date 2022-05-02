package sort;

public class BubbleSort {

  private static void sort(int[] arr) {
    int len = arr.length;
    for (int i = 0; i < len - 1; i++) {
      for (int j = 0; j < len - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int tmp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = tmp;
        }
      }
    }
  }

  public static void printArray(int arr[]) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6};
    sort(arr);
    System.out.println("Sorted Array is :");
    printArray(arr);
  }
}
