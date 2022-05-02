package stringMS;

import java.util.ArrayList;
import java.util.List;

public class IntegerPermutation {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> lists = new ArrayList<>();
    permute(nums, lists, 0);
    for (List<Integer> list : lists) {
      for (int num : list) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }

  private static void permute(int[] arr, List<List<Integer>> llist, int start) {
    if (start == arr.length) {
      List<Integer> list = new ArrayList<>();
      for (int num : arr) {
        list.add(num);
      }
      llist.add(list);
      return;
    }
    for (int i = start; i < arr.length; i++) {
      swap(arr, start, i);
      permute(arr, llist, start + 1);
      swap(arr, start, i);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
