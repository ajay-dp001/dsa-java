package leetcodeTopInterview.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionOfArrays {

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 2, 1};
    int[] arr2 = {2, 2};

    int[] result = intersection(arr1, arr2);
    int[] result1 = intersectionEffVer2(arr1, arr2);
    for (int num : result1) {
      System.out.print(num + " ");
    }
    System.out.println();

    int[] arr3 = {9, 4, 9, 8, 4};
    int[] arr4 = {4, 9, 5};
    int[] result2 = intersection(arr3, arr4);
    int[] res = intersectionEff(arr3, arr4);

    for (int num : res) {
      System.out.print(num + " ");
    }
  }

  private static int[] intersectionEff(int[] arr1, int[] arr2) {
    Set<Integer> set1 = new HashSet<>();
    int[] result = new int[arr1.length];
    int idx = 0;

    for (int num : arr1) {
      set1.add(num);
    }

    for (int num : arr2) {
      if (set1.contains(num)) {
        result[idx++] = num;
        set1.remove(num);
      }
    }
    return Arrays.copyOf(result, idx);
  }

  private static int[] intersectionEffVer2(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] result = new int[arr1.length];
    int idx = 0;

    for (int i = 0; i < arr1.length; i++) {
      map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
    }

    for (int i = 0; i < arr2.length; i++) {
      if (map.containsKey(arr2[i])) {
        result[idx++] = arr2[i];
        if (map.get(arr2[i]) == 1) {
          map.remove(arr2[i]);
        } else {
          map.put(arr2[i], map.get(arr2[i]) - 1);
        }
      }
    }
    return Arrays.copyOf(result, idx);
  }


  private static int[] intersection(int[] arr1, int[] arr2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();

    for (int i : arr1) {
      set1.add(i);
    }

    for (int j : arr2) {
      set2.add(j);
    }

    if (set1.size() < set2.size()) {
      return intersectionUtil(set1, set2);
    } else {
      return intersectionUtil(set2, set1);
    }
  }

  // O(M+N)
  private static int[] intersectionUtil(Set<Integer> set1, Set<Integer> set2) {
    int[] result = new int[set1.size()];
    int idx = 0;
    for (int num : set1) {
      if (set2.contains(num)) {
        result[idx++] = num;
      }
    }
    return Arrays.copyOf(result, idx);
  }

}
