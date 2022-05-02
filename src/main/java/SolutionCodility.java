import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class SolutionCodility {

  public static int solution(int[] V, int[] A, int[] B) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < V.length; i++) {
      graph.add(new ArrayList<>());
    }

    int[] inDegree = new int[V.length];

    for (int i = 0; i < A.length; i++) {
      graph.get(A[i]).add(B[i]);
      inDegree[A[i]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < V.length; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int curr = queue.poll();
      for (int course : graph.get(curr)) {
        inDegree[course]--;
        if (inDegree[course] == 0) {
          queue.add(course);
        }
      }
    }

    int max1 = 0, max2 = 0;
    for (int i = 0; i < V.length; i++) {
      if(inDegree[i] ==0){
        int tempval = V[i];
        if (tempval > 0) {
          if (tempval >= max1) {
            max2 = max1;
            max1 = tempval;
          } else if (tempval >= max2) {
            max2 = tempval;
          }
        }
      }
    }

    return max1 + max2;
  }


  public static void main(String[] args) {
    int[] V = {-3, 5, 7, 2, 3};
    int[] A = {3, 1};
    int[] B = {2, 4};
    System.out.println(solution(V, A, B));

    //int[] V1 = {5, 6, 6, 7, -10};
    //int[] A1 = {0, 0, 0, 1, 2, 3};
    //int[] B1 = {1, 2, 3, 3, 1, 2};
    //System.out.println(solution(V1, A1, B1));
  }

}
