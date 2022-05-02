package AAAMSPrepare.array;

public class SearchPosition {

  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 7};
    int n = arr.length;
    int K = 6;

    System.out.println(find_index(arr, n, K));
  }

  private static int find_index(int[] arr, int len, int k) {
    int start = 0, end = len - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (arr[mid] == k) {
        return mid;
      } else if (arr[mid] < k) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return end+1;
  }


}
