package AAPrep_final_OnlyAmazon;

import java.util.PriorityQueue;
import java.util.Stack;

public class TeamWithDIfferentCountryPlayer {

  public static void main(String[] args) {
    int[] countries = {1, 2, 3, 4, 5};
    int k = 4;
    System.out.println(maxNumberOfTeams(countries, k));
  }

  private static int maxNumberOfTeams(int[] countries, int k) {
    if (countries == null || countries.length == 0 || k < 0) {
      return 0;
    }
    PriorityQueue<Integer> candiatePool = new PriorityQueue<>((a, b) -> b - a);
    for (int country : countries) {
      if (country <= 0) {
        return -1;
      }
      candiatePool.offer(country);
    }
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    while (candiatePool.size() >= k) {
      for (int i = 0; i < k; i++) {
        int country = candiatePool.poll();
        if (--country > 0) {
          stack.push(country);
        }
        while (!stack.isEmpty()) {
          candiatePool.offer(stack.pop());
        }
        result++;
      }
    }
    return result;
  }

}
