package AAPrep_final_OnlyAmazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestItemAssociation {

  private static class PairString {

    String first;
    String second;

    public PairString(String first, String second) {
      this.first = first;
      this.second = second;
    }
  }

  public static void main(String[] args) {
    PairString ps1 = new PairString("Item1", "Item2");
    PairString ps2 = new PairString("Item3", "Item4");
    PairString ps3 = new PairString("Item4", "Item5");
    PairString ps4 = new PairString("Item2", "Item5");
    List<PairString> list = new ArrayList<>();
    list.add(ps1);
    list.add(ps2);
    list.add(ps3);
    list.add(ps4);
    System.out.println(largestItemAssociation(list));
    System.out.println(largestItemAssociation2(list));
    System.out.println(largestItemAssociation3(list));
    List<String[]> items = Arrays
        .asList(new String[]{"item1", "item2"}, new String[]{"item3", "item4"},
            new String[]{"item4", "item5"}, new String[]{"item2", "item5"});
    System.out.println(findAssociation(items));
    List<String[]> items1 = Arrays
        .asList(
            new String[]{"Item1", "Item2"},
            new String[]{"Item2", "Item8"},
            new String[]{"Item2", "Item10"},
            new String[]{"Item10", "Item12"},
            new String[]{"Item10", "Item4"},
            new String[]{"Item10", "Item3"},
            new String[]{"Item3", "Item4"},
            new String[]{"Item4", "Item5"}
        );
    System.out.println(findAssociation(items1));
   // solveHelper(list);

    System.out.println(largestItemAssociation2(Arrays.asList(
        new PairString("Item1", "Item2"),
        new PairString("Item3", "Item4"),
        new PairString("Item4", "Item5"),
        new PairString("Item2", "Item5")
    )));
    System.out.println(largestItemAssociation(Arrays.asList(
        new PairString("Item1", "Item2"),
        new PairString("Item2", "Item8"),
        new PairString("Item2", "Item10"),
        new PairString("Item10", "Item12"),
        new PairString("Item10", "Item4"),
        new PairString("Item10", "Item3"),
        new PairString("Item3", "Item4"),
        new PairString("Item4", "Item5")
    )));

    solveHelper(Arrays.asList(
        new PairString("Item1", "Item2"),
        new PairString("Item2", "Item8"),
        new PairString("Item2", "Item10"),
        new PairString("Item10", "Item12"),
        new PairString("Item10", "Item4"),
        new PairString("Item10", "Item3"),
        new PairString("Item3", "Item4"),
        new PairString("Item4", "Item5")
    ));

    System.out.println(largestItemAssociation(Arrays.asList(
        new PairString("Item1", "Item2"),
        new PairString("Item2", "Item8"),
        new PairString("Item2", "Item10"),
        new PairString("Item10", "Item12"),
        new PairString("Item10", "Item4"),
        new PairString("Item10", "Item3"),
        new PairString("Item3", "Item4")
    )));

    System.out.println(largestItemAssociation(Arrays.asList(
        new PairString("Item1", "Item2"),
        new PairString("Item3", "Item4"),
        new PairString("Item4", "Item5")
    )));

    System.out.println(largestItemAssociation(Arrays.asList(
        new PairString("A", "B"),
        new PairString("C", "D"),
        new PairString("D", "E")
    )));
    System.out.println(largestItemAssociation(Arrays.asList(
        new PairString("A", "B"),
        new PairString("C", "D"),
        new PairString("D", "E"),
        new PairString("F", "E")
    )));
    System.out.println(largestItemAssociation(Arrays.asList(
        new PairString("A", "B"),
        new PairString("C", "D"),
        new PairString("D", "E"),
        new PairString("F", "E"),
        new PairString("A", "C")
    )));
    System.out.println(largestItemAssociation(Arrays.asList(
        new PairString("A", "B"),
        new PairString("C", "D"),
        new PairString("D", "E"),
        new PairString("F", "E"),
        new PairString("A", "C"),
        new PairString("F", "E"),
        new PairString("X", "G"),
        new PairString("X", "N"),
        new PairString("G", "K"),
        new PairString("K", "L"),
        new PairString("L", "M")

    )));
  }

  //Correct Answer
  static List<String> findAssociation(List<String[]> items) {

    Map<String, String> inputMap = new HashMap<>();
    for (String[] edges : items) {
      inputMap.put(edges[0], edges[1]);
    }

    Map<String, ArrayList<String>> connectedMap = new HashMap<>();

    for (String vertex : inputMap.keySet()) {
      LinkedList<String> queue = new LinkedList<>();
      queue.add(vertex);
      connectedMap.put(vertex, new ArrayList<String>(Collections.singleton(vertex)));
      while (!queue.isEmpty()) {
        String v = queue.poll();
        connectedMap.get(vertex).add(inputMap.get(v));
        if (inputMap.containsKey(inputMap.get(v))) {
          queue.add(inputMap.get(v));
        }
      }

    }
    ArrayList<ArrayList<String>> values = new ArrayList<>(connectedMap.values());
    ArrayList<String> maxList = new ArrayList<>();
    int maxCount = 0;
    for (ArrayList<String> s : values) {
      if (s.size() > maxCount) {
        maxCount = s.size();
        maxList = s;
      } else if (s.size() == maxCount) {
        Collections.sort(maxList);
        Collections.sort(s);
        if (s.get(0).compareTo(maxList.get(0)) < 0) {
          maxCount = s.size();
          maxList = s;
        }
      }
    }
    return maxList;
  }

  private static List<String> largestItemAssociation(List<PairString> list) {
    List<String> res = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    Map<String, String> parents = new HashMap<>();

    for (PairString ps : list) {
      parents.put(ps.first, ps.first);
      parents.put(ps.second, ps.second);
    }

    for (PairString ps : list) {
      union(ps.first, ps.second, parents);
    }
    for (String key : parents.keySet()) {
      String parent = find(parents.get(key), parents);
      map.computeIfAbsent(parent, v -> new ArrayList<>()).add(key);
    }

    int maxSize = 0;
    for (String parent : map.keySet()) {
      if (map.get(parent).size() > maxSize) {
        maxSize = map.get(parent).size();
        res = map.get(parent);
      }
    }

    return res;
  }

  private static void union(String item1, String item2, Map<String, String> parents) {
    String parent1 = find(item1, parents);
    String parent2 = find(item2, parents);
    parents.put(parent1, parent2);
  }

  private static String find(String item, Map<String, String> parents) {
    if (parents.get(item) != item) {
      find(parents.get(item), parents);
    }
    return parents.get(item);
  }


  static List<String> largestItemAssociation2(List<PairString> itemAssociation) {
    LinkedHashMap<String, LinkedHashSet<String>> map = new LinkedHashMap<>();

    for (PairString pairs : itemAssociation) {
      if (pairs.first.equals(pairs.second)) {
        continue;
      }
      map.computeIfAbsent(pairs.first, val -> new LinkedHashSet<>()).add(pairs.second);
      map.computeIfAbsent(pairs.second, val -> new LinkedHashSet<>()).add(pairs.first);
    }

    List<String> result = new ArrayList<>();

    for (String name : map.keySet()) {
      Set<String> visited = new HashSet<>();
      List<String> cur = dfs(name, map, visited);
      if (cur.size() > result.size()) {
        result = cur;
      }
    }
    return result;
  }

  private static List<String> dfs(String name, Map<String, LinkedHashSet<String>> map, Set<String> visited) {
    if (!visited.add(name)) {
      return new ArrayList<>();
    }
    List<String> cur = new ArrayList<>();
    for (String dep : map.get(name)) {
      List<String> next = dfs(dep, map, visited);
      if (next.size() > cur.size()) {
        cur = next;
      }
    }
    visited.remove(name);
    cur.add(0, name);
    return cur;
  }


  private static List<String> largestItemAssociation3(List<PairString> asList) {
    Map<String, LinkedHashSet<String>> graph = new LinkedHashMap<>();

    for (PairString pairString : asList) {
      graph.computeIfAbsent(pairString.first, k -> new LinkedHashSet<String>()).add(pairString.second);
      graph.computeIfAbsent(pairString.second, k -> new LinkedHashSet<String>()).add(pairString.first);

    }

    List<LinkedHashSet<String>> resultList = new ArrayList<LinkedHashSet<String>>();
    HashSet<String> visited = new HashSet<String>();
    for (String node : graph.keySet()) {
      LinkedHashSet<String> connectedNodes = new LinkedHashSet<>();
      dfs(node, graph, connectedNodes, visited);
      if (connectedNodes.size() > 0) {
        resultList.add(connectedNodes);
      }
    }

    Collections.sort(resultList, (entry1, entry2) -> {
      if (entry1.size() == entry2.size()) {
        return (entry1.iterator().next().compareTo(entry2.iterator().next()));
      }
      return entry1.size() < entry2.size() ? 1 : -1;
    });

    return new ArrayList<>(resultList.get(0));
  }

  private static void dfs(String node, Map<String, LinkedHashSet<String>> graph,
      LinkedHashSet<String> connectedNodes,
      HashSet<String> visited) {
    if (visited.add(node)) {
      connectedNodes.add(node);
      for (String adjNode : graph.get(node)) {
        if (!visited.contains(adjNode)) {
          dfs(adjNode, graph, connectedNodes, visited);
        }
      }
    }
  }


  static void solveHelper(List<PairString> data) {

    Map<String, List<String>> map = new HashMap<>();

    for (PairString pair : data) {

      if (!map.containsKey(pair.first)) {
        map.put(pair.first, new ArrayList<>());
      }
      map.get(pair.first).add(pair.second);
    }

    Set<String> set = new HashSet<>();
    int prevSize = 0;
    List<String> res = new ArrayList<>();

    for (String s : map.keySet()) {

      List<String> mid = new ArrayList<>();
      if (!set.contains(s)) {
        mid.add(s);
        dfs(set, map, s, mid);
      }
      if (mid.size() > prevSize) {
        prevSize = mid.size();
        res = new ArrayList<>(mid);
      } else if (mid.size() == res.size()) {
        Collections.sort(res);
        Collections.sort(mid);

        if (res.get(0).compareTo(mid.get(0)) > 0) {
          prevSize = mid.size();
          res = new ArrayList<>(mid);
        }
      }
    }
    System.out.println(res.toString());


  }

  static void dfs(Set<String> set, Map<String, List<String>> map, String s, List<String> mid) {

    set.add(s);

    for (String str : map.getOrDefault(s, new ArrayList<>())) {

      if (!set.contains(str)) {
        mid.add(str);
        dfs(set, map, str, mid);
      }
    }

  }
}
