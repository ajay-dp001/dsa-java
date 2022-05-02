package Arrays;

public class MaxSumNonAdjecent {

  public static void main(String[] args) {
    int[] arr = {5,5,10, 100, 10, 5};
    int len = arr.length;
    nonAdjMaxSum(arr, len);
  }

  private static void nonAdjMaxSum(int[] arr, int len) {
    int inc = arr[0];
    int exc = 0;
    for (int i = 1; i < len; i++) {
      int new_inc = exc + arr[i];
      int new_exc = Math.max(inc, exc);

      inc = new_inc;
      exc = new_exc;
    }

    int ans = Math.max(inc, exc);
    System.out.println(ans);
  }

}
