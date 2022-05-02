package sort;

import prac.MyUtil;

public class QuickSort {

  public static int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        MyUtil.swap(arr, i, j);
      }
    }
    MyUtil.swap(arr, i + 1, high);
    return (i + 1);
  }

  public static void quickSort(int arr[], int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  public static void main(String[] args) {
    int arr[] = {2, 3, 6, 9, 1, 5};
    int len = arr.length;

    quickSort(arr, 0, len - 1);
    System.out.println("Sorted Array is");
    MyUtil.printArray(arr);
  }
}
