package Java_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortByFrequency {

  public static void sortByFreq(int arr[]) {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i]) + 1);
      } else {
        map.put(arr[i], 1);
      }
    }

    List<Integer> list = new ArrayList<>();
    map.entrySet()
        .stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .forEach(entry -> {
          for (int i = 1; i <= entry.getValue(); i++) {
            list.add(entry.getKey());
          }
        });
    System.out.println("Input Arrays is :"+ Arrays.toString(arr));
    System.out.println("Sorted Arrays is :"+ list);
  }

  public static void main(String[] args) {
    int arr[] = {7, 1, 3, 4, 7, 1, 7, 1, 4, 5, 1, 9, 3};
    sortByFreq(arr);
  }
}
