package AAPrep_final_OnlyAmazon;

import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=L2QnHPJQkZk
//https://www.youtube.com/watch?v=vZwgYBpe92A
public class MaxAveragePassFiveStarSeller {

  private static class Pair {

    double effect;
    int idx;

    public Pair(double effect, int idx) {
      this.effect = effect;
      this.idx = idx;

    }
  }

  public static void main(String[] args) {
    int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
    int extra_student = 2;
    System.out.println(maxAverageRatio(classes, extra_student));
  }

  private static double maxAverageRatio(int[][] classes, int extra_student) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Double.compare(y.effect, x.effect));

    for (int i = 0; i < classes.length; i++) {
      if (classes[i][0] == classes[i][1]) {
        continue;
      }

      double effect = -(double) (classes[i][0]) / (classes[i][1])
          + (double) (classes[i][0] + 1) / (classes[i][1] + 1);

      pq.add(new Pair(effect, i));
    }

    while (pq.size() > 0 && extra_student-- > 0) {
      Pair pair = pq.remove();
      int i = pair.idx;
      ++classes[i][0];
      ++classes[i][1];

      double effect = -(double) (classes[i][0]) / (classes[i][1])
          + (double) (classes[i][0] + 1) / (classes[i][1] + 1);

      pq.add(new Pair(effect, i));
    }

    double ans = 0;

    for (int[] a : classes) {
      double val = (double) (a[0]) / (double) (a[1]);
      ans += val;
    }
    return ans / (double) (classes.length);
  }

}
