package stringMS;

import java.util.ArrayList;
import java.util.List;

public class MaxLengthConcatenatedString {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("uu");
    list.add("iq");
    list.add("ue");

    int[] result = new int[1];
    maxUnique(list, 0, "", result);
    System.out.println(result[0]);
  }

  public static void maxUnique(List<String> arr, int idx, String curr, int[] res) {
    if (idx == arr.size() && uniqueChar(curr) > res[0]) {
      res[0] = curr.length();
      return;
    }
    if (idx == arr.size()) {
      return;
    }
    maxUnique(arr, idx + 1, curr, res);
    maxUnique(arr, idx + 1, curr + arr.get(idx), res);
  }

  public static int uniqueChar(String str) {
    int[] counts = new int[26];
    for (char ch : str.toCharArray()) {
      if (counts[ch - 'a']++ > 0) {
        return -1;
      }
    }
    return str.length();
  }


}
