package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.checkerframework.checker.units.qual.A;

public class CourseSchedule {

  public static void main(String[] args) {
    int numOfCourse = 2;
    int[][] arr = {{1, 0}};

    int[][] arr1 = {{1, 0}, {0, 1}};

    int numOfCourse1 = 100;
    int[][] arr100 = {{1, 0}, {2, 0}, {2, 1}, {3, 1}, {3, 2}, {4, 2}, {4, 3}, {5, 3}, {5, 4}, {6, 4}, {6, 5},
        {7, 5}, {7, 6}, {8, 6}, {8, 7}, {9, 7}, {9, 8}, {10, 8}, {10, 9}, {11, 9}, {11, 10}, {12, 10},
        {12, 11}, {13, 11}, {13, 12}, {14, 12}, {14, 13}, {15, 13}, {15, 14}, {16, 14}, {16, 15}, {17, 15},
        {17, 16}, {18, 16}, {18, 17}, {19, 17}, {19, 18}, {20, 18}, {20, 19}, {21, 19}, {21, 20}, {22, 20},
        {22, 21}, {23, 21}, {23, 22}, {24, 22}, {24, 23}, {25, 23}, {25, 24}, {26, 24}, {26, 25}, {27, 25},
        {27, 26}, {28, 26}, {28, 27}, {29, 27}, {29, 28}, {30, 28}, {30, 29}, {31, 29}, {31, 30}, {32, 30},
        {32, 31}, {33, 31}, {33, 32}, {34, 32}, {34, 33}, {35, 33}, {35, 34}, {36, 34}, {36, 35}, {37, 35},
        {37, 36}, {38, 36}, {38, 37}, {39, 37}, {39, 38}, {40, 38}, {40, 39}, {41, 39}, {41, 40}, {42, 40},
        {42, 41}, {43, 41}, {43, 42}, {44, 42}, {44, 43}, {45, 43}, {45, 44}, {46, 44}, {46, 45}, {47, 45},
        {47, 46}, {48, 46}, {48, 47}, {49, 47}, {49, 48}, {50, 48}, {50, 49}, {51, 49}, {51, 50}, {52, 50},
        {52, 51}, {53, 51}, {53, 52}, {54, 52}, {54, 53}, {55, 53}, {55, 54}, {56, 54}, {56, 55}, {57, 55},
        {57, 56}, {58, 56}, {58, 57}, {59, 57}, {59, 58}, {60, 58}, {60, 59}, {61, 59}, {61, 60}, {62, 60},
        {62, 61}, {63, 61}, {63, 62}, {64, 62}, {64, 63}, {65, 63}, {65, 64}, {66, 64}, {66, 65}, {67, 65},
        {67, 66}, {68, 66}, {68, 67}, {69, 67}, {69, 68}, {70, 68}, {70, 69}, {71, 69}, {71, 70}, {72, 70},
        {72, 71}, {73, 71}, {73, 72}, {74, 72}, {74, 73}, {75, 73}, {75, 74}, {76, 74}, {76, 75}, {77, 75},
        {77, 76}, {78, 76}, {78, 77}, {79, 77}, {79, 78}, {80, 78}, {80, 79}, {81, 79}, {81, 80}, {82, 80},
        {82, 81}, {83, 81}, {83, 82}, {84, 82}, {84, 83}, {85, 83}, {85, 84}, {86, 84}, {86, 85}, {87, 85},
        {87, 86}, {88, 86}, {88, 87}, {89, 87}, {89, 88}, {90, 88}, {90, 89}, {91, 89}, {91, 90}, {92, 90},
        {92, 91}, {93, 91}, {93, 92}, {94, 92}, {94, 93}, {95, 93}, {95, 94}, {96, 94}, {96, 95}, {97, 95},
        {97, 96}, {98, 96}, {98, 97}, {99, 97}};

    int numOfCourse2 = 5;
    int[][] arr2 = {{1, 4},{2,4},{3,1},{3,2}};

    System.out.println(canFinishLatest(numOfCourse1, arr100));
    System.out.println(canFinishN(numOfCourse, arr));
    System.out.println(canFinishN(numOfCourse2, arr2));
  }

  private static boolean canFinishN(int numOfCourse, int[][] preReq) {
    List<List<Integer>> graph = new ArrayList<>(numOfCourse);

    for (int i = 0; i < numOfCourse; i++) {
      graph.add(new ArrayList<>());
    }

    int[] inDegree = new int[numOfCourse];

    for (int[] row : preReq) {
      graph.get(row[0]).add(row[1]);
      inDegree[row[1]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numOfCourse; i++) {
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
      numOfCourse--;
    }

    return numOfCourse == 0;
  }

  public static boolean canFinishLatest(int n, int[][] prerequisites) {
    ArrayList<Integer>[] G = new ArrayList[n];
    int[] degree = new int[n];

    ArrayList<Integer> bfs = new ArrayList();
    for (int i = 0; i < n; ++i) {
      G[i] = new ArrayList<Integer>();
    }

    for (int[] e : prerequisites) {
      G[e[1]].add(e[0]);
      degree[e[0]]++;
    }

    for (int i = 0; i < n; ++i) {
      if (degree[i] == 0) {
        bfs.add(i);
      }
    }

    for (int i = 0; i < bfs.size(); ++i) {
      for (int j : G[bfs.get(i)]) {
        if (--degree[j] == 0) {
          bfs.add(j);
        }
      }
    }
    return bfs.size() == n;
  }

  private static boolean canFinishNew(int numOfCourse, int[][] arr) {
    if (arr == null || arr.length == 0 || arr[0].length == 0) {
      return true;
    }
    List<List<Integer>> graph = new ArrayList<>(numOfCourse);
    for (int i = 0; i < numOfCourse; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] row : arr) {
      int r = row[0];
      int c = row[1];
      graph.get(r).add(c);
    }

    boolean[] visited = new boolean[numOfCourse];
    for (int i = 0; i < numOfCourse; i++) {
      if (!dfsNew(graph, visited, i)) {
        return false;
      }
    }
    return true;
  }

  private static boolean dfsNew(List<List<Integer>> graph, boolean[] visited, int v) {
    if (visited[v]) {
      return false;
    }
    visited[v] = true;
    for (int vertex : graph.get(v)) {
      if (!dfsNew(graph, visited, vertex)) {
        return false;
      }
    }
    visited[v] = false;
    return true;
  }

  private static boolean canFinish(int numOfCourse, int[][] arr) {
    List[] graph = new ArrayList[numOfCourse];
    for (int i = 0; i < numOfCourse; i++) {
      graph[i] = new ArrayList<>();
    }

    boolean[] visited = new boolean[numOfCourse];

    for (int i = 0; i < arr.length; i++) {
      graph[arr[i][1]].add(arr[i][0]);
    }

    for (int i = 0; i < numOfCourse; i++) {
      if (!dfs(graph, visited, i)) {
        return false;
      }
    }
    return true;
  }

  private static boolean dfs(List[] graph, boolean[] visited, int course) {
    if (visited[course]) {
      return false;
    } else {
      visited[course] = true;
    }
    for (int i = 0; i < graph[course].size(); i++) {
      if (!dfs(graph, visited, (int) graph[course].get(i))) {
        return false;
      }
    }
    visited[course] = false;
    return true;
  }

}
