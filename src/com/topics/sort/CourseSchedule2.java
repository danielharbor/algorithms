package com.topics.sort;

import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] courses = { { 1, 0 }, { 0, 2 }, { 1, 3 } };
        int[] order = courseOrder(4, courses);
        System.out.println(Arrays.toString(order));
    }

    static int[] courseOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] map = new ArrayList[numCourses];
        initializeMap(prerequisites, map);
        int[] result = new int[numCourses];
        int[] visited = new int[numCourses];
        int[] resIdx = { 0 };

        for (int[] prereq : prerequisites) {
            if (hasCycle(prereq[0], map, visited, result, resIdx)) {
                return new int[0];
            }
        }
        return result;
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
    static boolean hasCycle(int i, List<Integer>[] map, int[] visited, int[] result, int[] idx) {
        if (visited[i] == 2)
            return false;
        if (visited[i] == 1)
            return true;

        visited[i] = 1;

        for (int x : map[i]) {
            if (hasCycle(x, map, visited, result, idx)) {
                return true;
            }
        }
        visited[i] = 2;
        result[idx[0]] = i;
        idx[0]++;
        return false;
    }
}
