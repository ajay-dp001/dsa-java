package AAPrep_final_OnlyAmazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

class NumberOfMeetingRoomAndMergeIntervals {

  public static void main(String[] args) {
    int[][] events = {{1, 2}, {2, 3}, {3, 4}};
    int len = events.length;
    System.out.println("Max Event :" + maxEvent(events, len));

    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    System.out.println(Arrays.deepToString(mergeInterval(intervals)));

    int[][] intervals2 = {{1, 2}, {3, 4}, {4, 10}};
    System.out.println(Arrays.deepToString(mergeInterval(intervals2)));
  }

  private static int maxEvent(int[][] events, int len) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    Arrays.sort(events, (a, b) -> a[0] - b[0]);

    int i = 0, max_event = 0, day = 1;
    while (!pq.isEmpty() || i < len) {
      while (!pq.isEmpty() && pq.peek()[1] < day) {
        pq.poll();
      }
      while (i < len && events[i][0] <= day) {
        pq.offer(events[i]);
        i++;
      }
      if (!pq.isEmpty()) {
        max_event++;
        pq.poll();
      }
      day++;
    }
    return max_event;
  }

  private static int[][] mergeInterval(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    LinkedList<int[]> merged = new LinkedList<>();

    for (int[] interval : intervals) {
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      } else {
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }
}
