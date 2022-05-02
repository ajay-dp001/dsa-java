package AAAMSPrepare.array;

import java.util.PriorityQueue;
import java.util.Queue;

public class FileMerge {

  public static void main(String[] args) {
    int size = 6;
    // 6 files with their sizes
    int[] files = new int[]{2, 3, 4, 5, 6, 7};

    // total no of computations do be done final answer
    System.out.println("Minimum Computations = " + minComputation(size, files));
  }

  private static int minComputation(int size, int[] files) {
    Queue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < size; i++) {
      pq.add(files[i]);
    }
    int cnt = 0;
    while (pq.size() > 1) {
      int temp = pq.poll() + pq.poll();
      cnt += temp;
      pq.add(temp);
    }
    return cnt;
  }

}
