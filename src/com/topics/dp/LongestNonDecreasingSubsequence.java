package com.topics.dp;

/*
 * Reference: https://www.youtube.com/watch?v=fV-TF4OvZpk
 * O(n^2) time and O(n) space complexity
 */
public class LongestNonDecreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {-1,2,4,5,2,2,2};
        System.out.println(findLongestNonDecreasingSubsequence(nums));
    }

    static int findLongestNonDecreasingSubsequence(int[] nums) {
        int dp[] = new int[nums.length], longest = 0;
        java.util.Arrays.fill(dp, 1); // Each element is a non-decreasing subsequence of length 1
        for (int j = 0; j < nums.length; ++j) {
            for (int i = 0; i < j; ++i) {
                if (nums[j] >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    longest = Math.max(longest, dp[j]);
                }
            }
        }

        return longest;
    }
}
