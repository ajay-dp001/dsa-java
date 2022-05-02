package AAPrep_final_OnlyAmazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Get two Sum Closest
public class InFlightMedia {

  public static void main(String[] args) {
    int gap = 30;
    int flightDuration = 250;
    int[] movieDurations = {90, 85, 75, 60, 120, 150, 125};
    System.out.println(Arrays.toString(getTwoSumClosest(movieDurations, flightDuration - gap)));

    int[] movie_duration1 = {90, 85, 75, 60, 120, 150, 125};
    int d1 = 250;
    int[] movie_duration2 = {90, 85, 75, 60, 155, 150, 125};
    int d2 = 250;
    int[] movie_duration3 = {90, 85, 75, 60, 120, 110, 110, 150, 125};
    int d3 = 250;
    System.out.println(Arrays.toString(getTwoSumClosest(movie_duration1, d1 - 30)));
    System.out.println(Arrays.toString(getTwoSumClosest(movie_duration2, d2 - 30)));
    System.out.println(Arrays.toString(getTwoSumClosest(movie_duration3, d3 - 30)));
  }

  private static int[] getTwoSumClosest(int[] movieDurations, int flightDuration) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < movieDurations.length; i++) {
      map.putIfAbsent(movieDurations[i], new ArrayList<>());
      map.get(movieDurations[i]).add(i);
    }

    Arrays.sort(movieDurations);
    int left = 0, right = movieDurations.length - 1;
    int max = 0;
    int[] result = new int[]{-1, -1};
    while (left < right) {
      int sum = movieDurations[left] + movieDurations[right];
      if (sum > max ||
          (sum == max && Math.max(movieDurations[left], movieDurations[right]) > Math.max(result[0],
              result[1])) && (sum <= flightDuration)) {
        max = sum;
        result[0] = movieDurations[left];
        result[1] = movieDurations[right];
      }
      if (sum > flightDuration) {
        right--;
      } else {
        left++;
      }
    }

    if (map.get(result[0]) == map.get(result[1])) {
      result[0] = map.get(result[0]).get(0);
      result[1] = map.get(result[1]).get(1);
    } else {
      result[0] = map.get(result[0]).get(0);
      result[1] = map.get(result[1]).get(0);
    }
    return result;
  }

}
