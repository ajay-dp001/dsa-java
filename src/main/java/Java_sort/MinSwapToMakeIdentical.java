package Java_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinSwapToMakeIdentical {

  public static int minSwapsToSort(int arr[], int len) {
    List<ArrayList<Integer>> arrPos = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      arrPos.add(new ArrayList<>(Arrays.asList(arr[i], i)));
    }
    Collections.sort(arrPos, new Comparator<ArrayList<Integer>>() {
      @Override
      public int compare(ArrayList<Integer> t1, ArrayList<Integer> t2) {
        return t1.get(0).compareTo(t2.get(0));
      }
    });
    boolean[] vis = new boolean[len];
    int ans = 0;
    for (int i = 0; i < len; i++) {
      if (vis[i] || arrPos.get(i).get(1) == i) {
        continue;
      }

      // find out the number of  node in
      // this cycle and add in ans
      int cycle_size = 0;
      int j = i;
      while (!vis[j]) {
        vis[j] = true;

        // move to next node
        j = arrPos.get(j).get(1);
        cycle_size++;
      }

      // Update answer by adding current cycle.
      ans += (cycle_size - 1);
    }

    // Return result
    return ans;

  }

  public static int minSwap(int[] arr1, int[] arr2, int length) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < length; i++) {
      map.put(arr1[i], i);
    }
    for (int j = 0; j < length; j++) {
      arr2[j] = map.get(arr1[j]);
    }
    return minSwapsToSort(arr2, length);
  }

  public static void main(String[] args) {
    int arr1[] = {3, 6, 4, 8};
    int arr2[] = {4, 6, 8, 3};
    minSwap(arr1, arr2, arr1.length);
  }
}
