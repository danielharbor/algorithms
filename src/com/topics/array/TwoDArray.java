package com.topics.array;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class TwoDArray {
    public static void main(String... args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};

        print4Neighbors(arr);
        printAllNeighbors(arr);
    }

    static void print4Neighbors(int[][] arr) {
        int m = arr.length, n = arr[0].length, dir[] = {-1, 0, 1, 0, -1};

        System.out.println("Input array:");
        System.out.println(Arrays.deepToString(arr).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Set<Integer> set = new HashSet<>();
                for (int x = 0; x < 4; ++x) {
                    int r = i + dir[x], c = j + dir[x+1];
                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        set.add(arr[r][c]);
                    }
                }
                System.out.println("Neighbors of " + arr[i][j] + ": " + set);
            }
        }
    }

    static void printAllNeighbors(int[][] arr) {
        int m = arr.length-1, n = arr[0].length-1;

        System.out.println(Arrays.deepToString(arr).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                Set<Integer> set = new HashSet<>();
                for (int x = Math.max(0, i-1); x <= Math.min(m, i+1); ++x) {
                    for (int y = Math.max(0, j-1); y <= Math.min(n, j+1); ++y) {
                        if (x != i || y != j) {
                            set.add(arr[x][y]);
                        }
                    }
                }
                System.out.println("All neighbors of " + arr[i][j] + ": " + set);
            }
        }
    }
}
