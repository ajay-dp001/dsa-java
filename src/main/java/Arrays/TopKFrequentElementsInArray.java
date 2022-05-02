package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElementsInArray {

  public static void main(String[] args) {
    int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
    int len = arr.length;
    int k = 2;
    print_N_mostFrequentNumber(arr, len, k);
  }

  private static void print_N_mostFrequentNumber(int[] arr, int len, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < len; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        (a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey()) :
            Integer.compare(b.getValue(), a.getValue()));

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      pq.offer(entry);
    }

    for (int i = 0; i < k; i++) {
      System.out.println(pq.poll().getKey());
    }
  }

}
