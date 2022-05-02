package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/discuss/interview-question/358669/given-two-strings-a-and-b-find-number-of-cocatenations-of-subsequences-of-b-to-create-a
public class ShortestWayToFormString {

  public static void main(String[] args) {
    String str1 = "allan";
    String str2 = "lan";

    System.out.println(shortestWay(str1, str2));
  }
  public static int shortestWay(String source, String target) {
    char[] cs = source.toCharArray();
    char[] ts = target.toCharArray();
    int res = 1;
    List<Integer>[] idx = new List[26];
    for (int i = 0; i < 26; i++) idx[i] = new ArrayList<>();
    for (int i = 0; i < cs.length; i++) idx[cs[i] - 'a'].add(i);
    int j = 0;
    for (int i = 0; i < ts.length; ) {
      List<Integer> tar = idx[ts[i] - 'a'];
      if (tar.isEmpty()) return -1;
      int k = Collections.binarySearch(tar, j);
      if (k < 0) k = -k - 1;
      if (k == tar.size()) {
        res++;
        j = 0;
      } else {
        j = tar.get(k) + 1;
        i++;
      }

    }
    return res;
  }

  private static int shortestWay2(String s1, String s2) {
    char[] src1 = s1.toCharArray();
    char[] trgt = s2.toCharArray();

    int res = 0;
    for (int i = 0; i < trgt.length; ) {
      int origI = i;
      for (char ch : src1) {
        if (i < trgt.length && ch == trgt[i]) {
          i++;
        }
      }
      if (i == origI) {
        return -1;
      }
      res++;


    }
    return res;
  }

}
