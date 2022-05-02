package Arrays;

import java.util.Arrays;

public class MinSwapToSort {

  private static class Pair implements Comparable<Pair> {

    int val, idx;

    public Pair(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }

    @Override
    public int compareTo(Pair pair) {
      return this.val - pair.val;
    }
  }

  public static void main(String[] args) {
    int[] arr = {101, 758, 315, 730, 472, 619, 460, 479};
    int len = arr.length;
    System.out.println("Min Swap required is :" + minSwap(arr, len));
  }

  private static Object minSwap(int[] arr, int len) {
    Pair[] pair = new Pair[len];
    for (int i = 0; i < len; i++) {
      pair[i] = new Pair(arr[i], i);
    }
    int ans = 0;
    Arrays.sort(pair);
    boolean[] visited = new boolean[len];
    for (int i = 0; i < len; i++) {
      if (visited[i] || pair[i].idx == i) {
        continue;
      }
      int cycle_len = 0;
      int j = i;
      while (!visited[j]) {
        visited[j] = true;
        cycle_len++;
        j = pair[j].idx;
      }
      ans += cycle_len - 1;
    }
    return ans;
  }

}
