package AAAMSPrepare.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinDeletionToMakeFreqUnique {

  public static void main(String[] args) {
    String str = "abbbcccd";
    int len = str.length();
    System.out.println(minCountChrDelete(str.toCharArray(), len));
  }

  public static int minCountChrDelete(char[] chArr, int len) {
    Map<Character, Integer> map = new HashMap<>();
    Queue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

    int cnt = 0;
    for (int i = 0; i < len; i++) {
      map.put(chArr[i], map.getOrDefault(chArr[i], 0) + 1);
    }

    for (Entry<Character, Integer> entry : map.entrySet()) {
      pq.add(entry.getValue());
    }

    while (!pq.isEmpty()) {
      int freq = pq.remove();
      if (pq.isEmpty()) {
        return cnt;
      }
      //If frequent and topmost element of pq are equal.
      if (freq == pq.peek()) {
        if (freq > 1) {
          //Insert the decremented value of frequent
          pq.add(freq - 1);
        }
        cnt++;
      }
    }
    return cnt;
  }

}
