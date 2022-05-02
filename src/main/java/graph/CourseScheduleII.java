package graph;
//https://leetcode.com/problems/course-schedule-ii/solution/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class CourseScheduleII {

  public static void main(String[] args) {
    int numOfCourses = 3;
    int[][] prerequisites = {{1, 0}, {0, 1},{0,2}};

    for (int num : findOrder1(numOfCourses, prerequisites)) {
      System.out.print(num + " ");
    }
    System.out.println();
    for (int num : Objects.requireNonNull(findOrder(numOfCourses, prerequisites))) {
      System.out.print(num + " ");
    }
    System.out.println();
    for (int num : Objects.requireNonNull(findOrderNew(numOfCourses, prerequisites))) {
      System.out.print(num + " ");
    }
  }

  private static int[] findOrderNew(int numOfCourses, int[][] preRequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numOfCourses; i++) {
      graph.add(new ArrayList<>());
    }

    int[] inDegree = new int[numOfCourses];
    for (int[] edge : preRequisites) {
      graph.get(edge[0]).add(edge[1]);
      inDegree[edge[1]]++;
    }

    int index = numOfCourses - 1;
    int[] order = new int[numOfCourses];

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numOfCourses; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
        order[index--] = i;
      }
    }

    while (!queue.isEmpty()) {
      int curr = queue.poll();
      for (int course : graph.get(curr)) {
        inDegree[course]--;
        if (inDegree[course] == 0) {
          queue.add(course);
          order[index--] = course;
        }
      }
    }
    return index < 0 ? order : new int[0];
  }

  public static int[] findOrder1(int numOfCourses, int[][] preRequisites) {
    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < numOfCourses; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : preRequisites) {
      graph.get(edge[0]).add(edge[1]);
    }

    List<Integer> topologicalOrder = new ArrayList<>();
    int[] visited = new int[numOfCourses];

    for (int i = 0; i < numOfCourses; i++) {
      if (visited[i] == 0) {
        if (!isTopologicalSortPossible(graph, i, visited, topologicalOrder)) {
          return new int[]{};
        }
      }
    }
    int[] result = new int[topologicalOrder.size()];
    int i = 0;
    for (int num : topologicalOrder) {
      result[i++] = num;
    }
    return result;
  }

  private static boolean isTopologicalSortPossible(List<List<Integer>> graph, int src, int[] visited,
      List<Integer> topologicalOrder) {

    if (visited[src] != 0) {
      return visited[src] == 1;
    }
    visited[src] = -1;
    for (int i : graph.get(src)) {
      if (!isTopologicalSortPossible(graph, i, visited, topologicalOrder)) {
        return false;
      }
    }
    visited[src] = 1;
    topologicalOrder.add(src);
    return true;
  }


  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses == 0) {
      return null;
    }
    // Convert graph presentation from edges to indegree of adjacent list.
    int indegree[] = new int[numCourses];
    int order[] = new int[numCourses];
    int index = 0;

    for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
    {
      indegree[prerequisites[i][0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        // Add the course to the order because it has no prerequisites.
        order[index++] = i;
        queue.offer(i);
      }
    }

    // How many courses don't need prerequisites.
    while (!queue.isEmpty()) {
      int prerequisite = queue.poll(); // Already finished this prerequisite course.
      for (int i = 0; i < prerequisites.length; i++) {
        if (prerequisites[i][1] == prerequisite) {
          indegree[prerequisites[i][0]]--;
          if (indegree[prerequisites[i][0]] == 0) {
            // If indegree is zero, then add the course to the order.
            order[index++] = prerequisites[i][0];
            queue.offer(prerequisites[i][0]);
          }
        }
      }
    }

    return (index == numCourses) ? order : new int[0];
  }

}
