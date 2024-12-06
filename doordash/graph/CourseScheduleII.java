package doordash.graph;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Initialize graph and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Build the graph and compute in-degrees
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            graph.get(prereqCourse).add(course);
            inDegree[course]++;
        }

        // Step 3: Add all courses with in-degree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 4: Perform BFS to determine course order
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            result[index++] = currentCourse;

            for (int neighbor : graph.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 5: Check if all courses have been added to the result
        return index == numCourses ? result : new int[0];
    }
}

