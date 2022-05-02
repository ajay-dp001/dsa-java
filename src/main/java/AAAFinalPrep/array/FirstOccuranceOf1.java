package AAAFinalPrep.array;

public class FirstOccuranceOf1 {

  public static void main(String[] args) {
    int[] arr1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1};
    int[] arr = {0, 0, 0, 0,1,1,1};
    System.out.println(findFirstOccr(arr));
  }

  private static int findFirstOccr(int[] arr) {
    int left = 0, right = arr.length - 1, result = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == 1) {
        result = mid;
        right = mid - 1;
      } else if (arr[mid] < 1) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }
}
