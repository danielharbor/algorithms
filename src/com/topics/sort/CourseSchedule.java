package com.topics.sort;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] courses = { { 1, 0 }, { 0, 1 } };
        boolean canFinish = canFinish(2, courses);
        System.out.println(canFinish);
    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] map = new ArrayList[numCourses];
        initializeMap(prerequisites, map);
        int[] visited = new int[numCourses];

        for (int[] prereq : prerequisites) {
            if (hasCycle(prereq[0], map, visited)) {
                return false;
            }
        }
        return true;
    }

    static void initializeMap(int[][] prerequisites, List<Integer>[] map) {
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList();
        }
        for (int[] prereq : prerequisites) {
            map[prereq[0]].add(prereq[1]);
        }
    }

    // 1 = the vertex is being visited
    // 2 = the vertex has been visited
    static boolean hasCycle(int i, List<Integer>[] map, int[] visited) {
        if (visited[i] == 2)
            return false;
        if (visited[i] == 1)
            return true;

        visited[i] = 1;

        for (int x : map[i]) {
            if (hasCycle(x, map, visited)) {
                return true;
            }
        }
        visited[i] = 2;
        return false;
    }
}
