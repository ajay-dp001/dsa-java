package Arrays;

public class SubArrayProductLessThanK {

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4};
    int k = 10;
    int ln = arr.length;

    System.out.print(countsubarray(arr, ln, k));
    System.out.println("\n****");
    int arr1[] = {10, 5, 2, 6};
    int k1 = 100;
    int ln1 = arr.length;
    System.out.print(countsubarraySlidingWindow(arr1, ln1, k1));
  }

  //O(n^2)
  private static int countsubarray(int[] arr, int ln, int k) {
    int cnt = 0, prod;
    for (int i = 0; i < ln; i++) {
      if (arr[i] < k) {
        cnt++;
      }
      prod = arr[i];
      for (int j = i + 1; j < ln; j++) {
        prod *= arr[j];
        if (prod < k) {
          cnt++;
        } else {
          break;
        }
      }
    }
    return cnt;
  }

  //O(n)
  private static int countsubarraySlidingWindow(int[] arr, int ln, int k) {
    int j = 0, ans = 0, prod = 1;
    for (int i = 0; i < ln; i++) {
      prod *= arr[i];
      while (i>=j && prod >= k) {
        prod /= arr[j++];
      }
      ans += (i - j) + 1;
    }
    return ans;
  }
}
