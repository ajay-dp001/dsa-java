package AAAFinalPrep.array;

public class SortArrayOf012 {

  public static void main(String[] args) {
    int arr[] = {0, 2, 1, 2, 0};
    dutchNationalFlagAlgo(arr);
  }

  private static void dutchNationalFlagAlgo(int[] arr) {
    int low = 0, mid = 0, high = arr.length - 1;
    int temp;
    while (mid < high) {
      switch (arr[mid]) {
        case 0:
          temp = arr[low];
          arr[low] = arr[mid];
          arr[mid] = temp;
          low++;
          mid++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          temp = arr[mid];
          arr[mid] = arr[high];
          arr[high] = temp;
          mid++;
          high--;
          break;
      }
    }
  }
}
