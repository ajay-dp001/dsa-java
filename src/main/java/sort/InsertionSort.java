package sort;

public class InsertionSort {

  public static void sort(int arr[]) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
    }
  }

  public static void selectionSort(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int min_idx = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min_idx]) {
          min_idx = j;
        }
        int tmp = arr[min_idx];
        arr[min_idx] = arr[i];
        arr[i] = tmp;
      }
    }
  }


  public static void printArray(int arr[]) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int len = arr.length;
   // sort(arr);
    selectionSort(arr);

    System.out.println("Sorted Array is :");
    printArray(arr);
  }
}
