package Arrays;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// O(NK log K)
public class MergeKsortedArray {

  public static class Pair implements Comparable<Pair> {

    int list_index;
    int data_index;
    int val;

    public Pair(int list_index, int data_index, int val) {
      this.list_index = list_index;
      this.data_index = data_index;
      this.val = val;
    }

    @Override
    public int compareTo(Pair pair) {
      return this.val - pair.val;
    }
  }

  public static List<Integer> mergeKSortedArray(List<List<Integer>> listList) {
    List<Integer> mergList = new ArrayList<>();

    PriorityQueue<Pair> pq = new PriorityQueue<>();

    for (int i = 0; i < listList.size(); i++) {
      Pair pair_min = new Pair(i, 0, listList.get(i).get(0));
      pq.add(pair_min);
    }

    while (pq.size() > 0) {
      Pair pair = pq.remove();
      mergList.add(pair.val);
      pair.data_index++;

      if (pair.data_index < listList.get(pair.list_index).size()) {
        pair.val = listList.get(pair.list_index).get(pair.data_index);
        pq.add(pair);
      }
    }
    return mergList;
  }

  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList();
    Integer[][] arr = {{2, 6, 12, 34}, {1, 9, 20, 1000}, {23, 34, 90, 2000}};

    for (Integer[] ints : arr) {
      list.add(Arrays.asList(ints));
    }

    List<Integer> nwList = mergeKSortedArray(list);
    for (int li : nwList) {
      System.out.println(li);
    }
  }
}
