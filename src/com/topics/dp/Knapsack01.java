package com.topics.dp;

import java.util.*;

/*
 * 0/1 Knapsack problem
 * Given a bag which can only take certain weight W and a list of items with their weights and prices, fill the bag to maximize value of items in the bag.
 * Solution: Bottom up dynamic programming - https://www.youtube.com/watch?v=8LusJS5-AGo
 */
public class Knapsack01 {
    public static void main(String... args) {
        int vals[] = {1, 4, 5, 7}, weights[] = {1, 3, 4, 5}, weight = 7;
        int dp[][] = new int[vals.length + 1][weight + 1];

        for (int i = 0; i < vals.length; ++i) {
            for (int j = 1; j <= weight; ++j) {
                if (weights[i] > j) {
                    dp[i+1][j] = dp[i][j];
                } else {
                    dp[i+1][j] = Math.max(dp[i][j-weights[i]] + vals[i], dp[i][j]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp).replace("[[", "[").replace("]]", "]").replace("], ", "]\n"));
        System.out.println("Final answer: " + dp[vals.length][weight]);
    }
}
