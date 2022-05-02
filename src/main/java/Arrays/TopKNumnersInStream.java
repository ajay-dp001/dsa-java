package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKNumnersInStream {

  public static void main(String[] args) {
    int k = 3;
    int[] arr = {8, 10, 7, 8, 11, 30, 11, 8, 38, 11, 2, 45, 2, 8};

    List<Integer> list = kTopFrequentNumMinHeap(arr, k);
    for (Integer num : list) {
      System.out.print(num + " ");
    }
  }

  private static List<Integer> kTopFrequentNumMinHeap(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
        (n1, n2) -> n2.getValue() - n1.getValue());
    maxHeap.addAll(map.entrySet());

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
      list.add(maxHeap.poll().getKey());
    }
    return list;
  }

}
