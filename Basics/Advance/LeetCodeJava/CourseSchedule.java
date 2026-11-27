package LeetCodeJava;


import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(
        int numCourses, int[][] prerequisites
    ) {

        List<List<Integer>> graph = new ArrayList<>();

        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {

            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite).add(course);

            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            completed++;

            for (int next : graph.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return completed == numCourses;
    }

    public static void main(String[] args) {

        int numCourses = 2;

        int[][] prerequisites = {
            {1, 0}
        };

        System.out.println(
            canFinish(numCourses, prerequisites)
        );
    }
}
