package Arrays;

//https://www.youtube.com/watch?v=odrfUCS9sQk
public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
    int ln = arr.length;
    longestIncreasingSubsequence(arr, ln);
    System.out.println(longestIncreasingSubsequenceNLogN(arr, ln));
  }

  private static int longestIncreasingSubsequenceNLogN(int[] arr, int ln) {
    int[] tailTable = new int[ln];
    tailTable[0] = 0;
    int len = 1;
    for (int i = 0; i < ln; i++) {
      if (arr[i] < tailTable[0]) {
        tailTable[0] = arr[i];
      } else if (arr[i] > tailTable[len - 1]) {
        tailTable[len++] = arr[i];
      } else {
        tailTable[ceilIndex(tailTable, -1, len - 1, arr[i])] = arr[i];
      }
    }
    return len;

  }

  //  https://www.youtube.com/watch?v=S9oUiVYEq7E
  private static int ceilIndex(int[] arr, int l, int r, int key) {
    while (r - l > 1) {
      int m = l + (r - l) / 2;
      if (arr[m] >= key) {
        r = m;
      } else {
        l = m;
      }
    }
    return r;
  }

  private static void longestIncreasingSubsequence(int[] arr, int ln) {
    int[] dp = new int[ln];
    int omax = 0;
    for (int i = 1; i < ln; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          if (dp[j] > max) {
            max = dp[j];
          }
        }
      }
      dp[i] = max + 1;
      if (dp[i] > omax) {
        omax = dp[i];
      }
    }
    System.out.println(omax);
  }
}
