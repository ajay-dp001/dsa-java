package queue;

public class PrintKMax {

  private static void printKMax(int[] arr, int sizek) {
    int max;
    for (int i = 0; i < arr.length -sizek; i++) {
      max = arr[i];
      for (int j = 1; j < sizek; j++) {
        if (arr[i + j] > max) {
          max = arr[i + j];
        }
      }
      System.out.println("Max is :"+ max);
    }
  }

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int k = 3;
    printKMax(arr, k);
  }
}
