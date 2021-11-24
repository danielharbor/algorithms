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
        if (nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length], longest = 1;
        java.util.Arrays.fill(dp, 1); // Each element is a non-decreasing subsequence of length 1
        for (int fixed = 0; fixed < nums.length; ++fixed) {
            for (int runner = 0; runner < fixed; ++runner) {
                if (nums[fixed] >= nums[runner]) {
                    dp[fixed] = Math.max(dp[fixed], dp[runner] + 1);
                    longest = Math.max(longest, dp[fixed]);
                }
            }
        }

        return longest;
    }
}
