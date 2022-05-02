package Arrays;

public class MaxSumPathInTwoArray {

  public static void main(String[] args) {
    int ar1[] = {2, 3, 7, 10, 12, 15, 30, 34};
    int ar2[] = {1, 5, 7, 8, 10, 15, 16, 19};
    int ln1 = ar1.length;
    int ln2 = ar2.length;
    System.out.println("Maximum sum path is :" + maxPathSum(ar1, ar2, ln1, ln2));
  }

  private static int maxPathSum(int[] ar1, int[] ar2, int ln1, int ln2) {
    int i = 0, j = 0, result = 0, sum1 = 0, sum2 = 0;
    while (i < ln1 && j < ln2) {
      if (ar1[i] < ar2[j]) {
        sum1 += ar1[i++];
      } else if (ar1[i] > ar2[j]) {
        sum2 += ar2[j++];
      } else {
        result += Math.max(sum1, sum2) + ar1[i];
        sum1 = sum2 = 0;
        i++;
        j++;
      }
    }
    while (i < ln1) {
      sum1 += ar1[i++];
    }
    while (j < ln2) {
      sum2 += ar2[j++];
    }
    result += Math.max(sum1, sum2);
    return result;
  }
}
