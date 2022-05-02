package AAPrep_final_OnlyAmazon;

import java.util.HashMap;
import java.util.Map;

public class ItemAssociation {

  public static void main(String[] args) {
    String[][] items = {{"itemA", "itemB"}, {"itemB", "itemC"},
        {"itemD", "itemE"}, {"itemE", "itemF"}, {"itemG", "itemD"}};

    ItemAssociation ia = new ItemAssociation();
    String[] res = ia.count(items);
  }

  public String[] count(String[][] items) {
    int n = items.length;

    int index = 0;
    Map<String, Integer> hash = new HashMap<String, Integer>();
    for (int i = 0; i < n; i++) {
      if (!hash.containsKey(items[i][0])) {
        hash.put(items[i][0], index++);
      }
      if (!hash.containsKey(items[i][1])) {
        hash.put(items[i][1], index++);
      }
    }

    UnionFind un = new UnionFind(hash.size());

    for (int i = 0; i < n; i++) {
      un.union(hash.get(items[i][0]), hash.get(items[i][1]));
    }

    int maxIndex = un.findMaxSize();
    System.out.println(maxIndex);
    for (Map.Entry<String, Integer> entry : hash.entrySet()) {
      String key = entry.getKey();
      Integer ind = entry.getValue();
//            System.out.println(key + un.find(ind));
      if (un.find(ind) == maxIndex) {
        System.out.println(key);
      }
    }
    return null;
  }

  class UnionFind {

    int[] father = null;
    int[] size = null;

    UnionFind(int n) {
      father = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        father[i] = i; //father is itself
        size[i] = 1;
      }
    }

    void union(int a, int b) {
      int root_a = find(a);
      int root_b = find(b);
      if (root_a != root_b) {
        father[root_b] = root_a; //father merge
        size[root_a] += size[root_b];
      }
    }

    int find(int x) {
      if (father[x] == x) {
        return x;
      }

      return father[x] = find(father[x]);
    }

    int findMaxSize() {
      int max = 0;
      int index = 0;
      for (int i = 0; i < size.length; i++) {
//                System.out.println("father["+i+"]"+father[i]+" size[" +i +"]"+ size[i]);
        if (size[i] > max) {
          max = size[i];
          index = i;
        }
      }
      return index;
    }
  }
}
