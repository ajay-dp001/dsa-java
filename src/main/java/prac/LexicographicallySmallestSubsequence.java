package prac;

import java.util.Stack;

public class LexicographicallySmallestSubsequence {

  public static void main(String[] args) {
    int k = 2;
    int[] arr = {5, 4, 5, 1, 4, 3, 6, 9, 5};
    int[] ans = smallest(arr, k);
    for (int num : ans) {
      System.out.print(num + " ");
    }
  }

  private static int[] smallest(int[] nums, int k) {
    int len = nums.length;
    Stack<Integer> stk = new Stack<>();
    for (int i = 0; i < len; i++) {
      int val = nums[i];

      while (!stk.isEmpty() && nums[i] < stk.peek() && (len - i - 1) > k - stk.size()) {
        stk.pop();
      }
      if (stk.size() < k) {
        stk.push(val);
      }
    }
    int[] ans = new int[k];
    int i = k - 1;
    while (i >= 0) {
      ans[i--] = stk.pop();
    }
    return ans;
  }

}
