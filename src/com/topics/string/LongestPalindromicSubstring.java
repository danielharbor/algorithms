package com.topics.string;

public class LongestPalindromicSubstring {
    public static void main(String args[]) {
        String s = "bababac";
        System.out.println(longestPalindromeLeftToRight(s));
    }

    static String longestPalindromeRightToLeft(String s) {
        int maxLen = 0, start = 0, end = 1, strLen = s.length();
        boolean[][] dp = new boolean[strLen][strLen];

        for (int i = strLen-1; i > 0; i--) {
            for (int j = i; j < strLen; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1]);
                if (dp[i][j]) {
                    maxLen = Math.max(maxLen, j-i+1);
                    start = i;
                    end = j+1;
                }
            }
        }

        return s.substring(start, end);
    }

    static String longestPalindromeLeftToRight(String s) {
        int maxLen = 0, start = 0, end = 1, strLen = s.length();
        boolean[][] dp = new boolean[strLen][strLen];

        for (int i = 0; i < strLen-1; i++) {
            for (int j = i; j >= 0; j--) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && (i-j <= 2 || dp[j+1][i-1]);
                if (dp[j][i]) {
                    maxLen = Math.max(maxLen, i-j+1);
                    start = j;
                    end = i+1;
                }
            }
        }

        return s.substring(start, end);
    }
}
