package AAPrep_final_OnlyAmazon;

//https://www.youtube.com/watch?v=tRpkluGqINc&t=132s
public class FindAllCombination {

  public static void main(String[] args) {
    int target = 10;
    int[] subSet = {4, 2, 7, 1, 3};
    printTargetSubSet(subSet, 0, "", 0, target);

    boolean[][] dp = new boolean[subSet.length + 1][target + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (i == 0) {
          dp[i][j] = false;
        } else if (j == 0) {
          dp[i][j] = true;
        } else {
          if (dp[i - 1][j]) {
            dp[i][j] = dp[i - 1][j];
          } else {
            int val = subSet[i - 1];
            if (j >= val) {
              if (dp[i - 1][j - val]) {
                dp[i][j] = true;
              }
            }
          }
        }
      }
    }
    System.out.println(dp[subSet.length][target]);
  }

  private static void printTargetSubSet(int[] arr, int idx, String set, int sos, int target) {
    if (idx == arr.length) {
      if (sos == target) {
        System.out.println(set);
      }
      return;
    }

    printTargetSubSet(arr, idx + 1, set + arr[idx] + ",", sos + arr[idx], target);
    printTargetSubSet(arr, idx + 1, set, sos, target);
  }

}
