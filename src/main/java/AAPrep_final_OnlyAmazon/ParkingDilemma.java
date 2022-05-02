package AAPrep_final_OnlyAmazon;

import java.util.Arrays;

public class ParkingDilemma {

  public static void main(String[] args) {
    int[] cars = {12, 6, 5, 2};
    int k = 3;
    System.out.println(solution(cars, k)); // 5
    int[] cars1 = {2, 5, 6, 9, 12};
    int k1 = 4;
    System.out.println(solution(cars1, k1)); // 8
  }

  private static int solution(int[] cars, int k) {
    if (cars.length == 0 || k == 0) {
      return 0;
    }
    if (k > cars.length) {
      return Integer.MAX_VALUE;
    }
    //Time Complexity: O(N log N) - because I sorting the array.
    Arrays.sort(cars);
    //Space Complexity: O(1) No extra space has been used.
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < cars.length - k; i++) {
      ans = Math.min(ans, cars[i + k - 1] - cars[i] + 1);
    }
    return ans;
  }

}
