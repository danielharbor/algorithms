package com.topics.string;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String[] words = {"a", "aa", "ab", "bbbab", "abubakar", "subsequence"};
        for (String s : words) {
            int len = s.length();
            System.out.println(subsequence(s, 0, len-1));
            System.out.println(subsequenceMemoized(s, 0, len-1, new Integer[len][len]));
            System.out.println(subsequenceDP(s));
            System.out.println(subsequenceDP2(s));
        }
    }

    // recursive: does unnecessary recomputation of values.
    // calculated values can be memoized to avoid this recomputation (see below)
    static int subsequence(String s, int i, int j) {
        if (i == j) {
            return 1;
        }

        if (s.charAt(i) == s.charAt(j) && i+1 == j) {
            return 2;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return subsequence(s, i+1, j-1) + 2;
        } else {
            return Math.max(subsequence(s, i+1, j), subsequence(s, i, j-1));
        }
    }

    // save values as we encounter them: Top Down
    // https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/
    static int subsequenceMemoized(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = subsequenceMemoized(s, i+1, j-1, memo) + 2;
        } else {
            memo[i][j] = Math.max(subsequenceMemoized(s, i+1, j, memo),
                                subsequenceMemoized(s, i, j-1, memo));
        }
        return memo[i][j];
    }

    // dp solution: bottom up
    static int subsequenceDP(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j <= len-1; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }

    // another dp solution: bottom up (https://www.youtube.com/watch?v=_nCsPn7_OgI)
    static int subsequenceDP2(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int gap = 0; gap < len; gap++) {
            for (int i = 0, j = i + gap; j < len; i++, j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][len-1];
    }
}
