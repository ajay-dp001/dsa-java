package graph;

//https://www.geeksforgeeks.org/cycles-of-length-n-in-an-undirected-and-connected-graph/
public class CountCycles {

  public static void main(String[] args) {
    int[][] graph = {
        {0, 1, 0, 1, 0},
        {1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1},
        {0, 1, 0, 1, 0}};

    int n = 4;
    System.out.println("Total Cycle of Length: " + n + " are " + countCycle(graph, n));
  }

  private static int countCycle(int[][] graph , int n){
    boolean[] visited = new boolean[6];
    return 0;
  }
}
