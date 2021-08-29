package com.topics.array;

/*
 * You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5

Example 2:
Input: nums = [1], target = 1
Output: 1
 */

public class TargetSum {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 1, 1};
        System.out.println(targetSum(nums, 3));
    }

    static int targetSum(int[] nums, int target) {
        return targetSumHelper(nums, target, 0, 0);
    }

    static int targetSumHelper(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }

        int positive = targetSumHelper(nums, target, idx + 1, sum + nums[idx]);
        int negative = targetSumHelper(nums, target, idx + 1, sum - nums[idx]);

        return positive + negative;
    }
}
