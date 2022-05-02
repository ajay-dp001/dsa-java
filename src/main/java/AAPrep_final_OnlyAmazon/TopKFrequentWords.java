package AAPrep_final_OnlyAmazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

  public static void main(String[] args) {
    int k = 4;
    String[] str_arr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    List<String> list = topKFrequent(str_arr, k);
    System.out.println("Top K frequent are: " + list);

    String[] str_arr1 = {"i", "love", "leetcode", "i", "love", "coding"};
    List<String> list1 = topKFrequent(str_arr1, 2);
    System.out.println("Top K frequent are: " + list1);
  }

  private static List<String> topKFrequent(String[] words, int k) {
    List<String> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return new ArrayList<>();
    }
    Map<String, Integer> map = new HashMap<>();
    for (String str : words) {
      map.put(str, map.getOrDefault(str, 0) + 1);
    }

    PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k,
        (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue()
            : a.getKey().compareTo(b.getKey()));
    for (Map.Entry<String, Integer> set : map.entrySet()) {
      maxHeap.add(set);
    }
    while (k > 0) {
      result.add(maxHeap.poll().getKey());
      k--;
    }
    return result;
  }

}
