package AAPrep_final_OnlyAmazon;

import java.util.HashMap;
import java.util.Map;

public class SongPairDurationDivisibleBy60 {

  public static void main(String[] args) {
    int[] time = {30, 20, 150, 100, 40};
    System.out.println("Num Pair :" + numPairDivisibleBy60(time));
  }

  public static int numPairDivisibleBy60(int[] time) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(60, 0);

    int pair = 0;
    for (int i = 0; i < time.length; i++) {
      time[i] = time[i] % 60;
      if (map.containsKey((60 - time[i]) % 60)) {
        pair += map.get((60 - time[i]) % 60);
      }
      map.put(time[i], map.getOrDefault(time[i], 0) + 1);
    }
    return pair;
  }

}
