package AAAMSPrepare.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/430981/
public class PartitionArrayInNSubSetWithBalancedSum {

  public static void main(String[] args) {
    List<List<Integer>> result = part(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
    System.out.println(result);
  }

  private static List<List<Integer>> part(int[] arr, int k) {
    int[] sum = new int[3];
    Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> sum[o1.intValue()] - sum[o2.intValue()]);

    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      result.add(new ArrayList<>());
      pq.add(i);
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      int c = pq.poll();
      result.get(c).add(arr[i]);
      sum[c] += arr[i];
      pq.add(c);
    }
    return result;
  }

}
