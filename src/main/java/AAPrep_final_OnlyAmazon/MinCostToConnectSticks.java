package AAPrep_final_OnlyAmazon;
//Amazon Fulfillment Builder

import java.util.PriorityQueue;

public class MinCostToConnectSticks {

  public static void main(String[] args) {
    int[] sticks = {2, 4, 3};
    System.out.println("Min Cost to Connect Sticks: " + getMinCost(sticks));
  }

  //O(n log n) , Space O(n)
  private static int getMinCost(int[] sticks) {
    int cost = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int stick : sticks) {
      minHeap.add(stick);
    }
    while (minHeap.size() > 1) {
      int sum = minHeap.remove() + minHeap.remove();
      cost += sum;
      minHeap.add(sum);
    }
    return cost;
  }

}
