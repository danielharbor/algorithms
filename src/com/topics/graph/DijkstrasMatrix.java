package com.topics.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasMatrix {
    public static void main(String[] args) {
        int[][] input = {{1,2,1},{4,3,2}};
        System.out.println(Arrays.deepToString(input).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        System.out.println("Shortest path: " + getShortestPath(input));
    }

    static int getShortestPath(int[][] input) {
        int m = input.length, n = input[0].length;
        boolean v[][] = new boolean[m][n]; // tracks visited
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int dir[] = {-1, 0, 1, 0, -1}, res[][] = new int[m][n];
        Arrays.stream(res).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE));

        heap.offer(new int[]{0, 0, input[0][0]});

        while (!heap.isEmpty()) {
            int[] min = heap.poll();
            int r = min[0], c = min[1], d = min[2];

            for (int i = 0; i < 4; ++i) {
                int nr = r + dir[i], nc = c + dir[i+1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !v[nr][nc]) {
                    int dist = d + input[nr][nc];
                    if (dist < res[nr][nc]) {
                        res[nr][nc] = dist;
                        heap.offer(new int[]{nr, nc, dist});
                    }
                }
            }

            v[r][c] = true;
        }

        return res[m-1][n-1];
    }
}
