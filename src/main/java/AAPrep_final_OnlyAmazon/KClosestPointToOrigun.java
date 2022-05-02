package AAPrep_final_OnlyAmazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointToOrigun {

  public static void main(String[] args) {
    int k = 1;
    int[][] points = {{1, 3}, {-2, 2}};
    System.out.println(Arrays.deepToString(kClosest(points, k)));
  }

  public static int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> dist(p2) - dist(p1));
    for (int[] point : points) {
      pq.offer(point);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    int[][] res = new int[k][2];
    while (k > 0) {
      res[--k] = pq.poll();
    }
    return res;
  }

  // distance between 2 points is sqrt((y2 - y1)^2 + (x2 - x1)^2), here (x1, y1) == (0,0)
  private static int dist(int[] p) {
    return p[1] * p[1] + p[0] * p[0];
  }

}
