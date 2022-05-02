package AAPrep_final_OnlyAmazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WareHouseCost {

  public static void main(String[] args) {
    int n = 4;
    int[][] connections = {{0, 2}, {1, 2}};
    System.out.println("Total Cost is :" + findCost(n, connections));
  }

  private static int findCost(int n, int[][] connections) {
    if (n < 2) {
      return n;
    }
    List<HashSet<Integer>> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      HashSet<Integer> intHash = new HashSet<>();
      intHash.add(i);
      list.add(intHash);
    }

    for (int[] edge : connections) {
      HashSet<Integer> value = null;
      for (int i = 0; i < list.size(); i++) {
        HashSet<Integer> item = list.get(i);
        if (item.contains(edge[0])) {
          if (value == null) {
            value = item;
          } else {
            value.addAll(item);
            list.remove(item);
          }
        }
        if (item.contains(edge[1])) {
          if (value == null) {
            value = item;
          } else {
            value.addAll(item);
            list.remove(item);
          }
        }
      }
    }
    int result = 0;
    for (HashSet<Integer> item : list) {
      result = (int) (result + Math.ceil(Math.sqrt(item.size())));
    }
    return result;
  }

}
