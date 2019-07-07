package com.topics.array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    /**
    * Given a set of distinct integers, nums, return all possible subsets.
    * Note: The solution set must not contain duplicate subsets.
    * Example: Given input nums = [1,2,3], return [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
    */
    public static void main(String args[]) {
        System.out.println("Subsets");
        int[] nums = {3,1,2};
        System.out.println(getSubsets(nums));
    }

    static List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        backtrack(nums, subsets, new ArrayList(), 0);
        return subsets;
    }

    static void backtrack(int[] nums, List<List<Integer>> subsets, List<Integer> curSet, int start) {
        subsets.add(curSet);
        for (int i = start; i < nums.length; i++) {
            List<Integer> nextSet = new ArrayList(curSet);
            nextSet.add(nums[i]);
            backtrack(nums, subsets, nextSet, i + 1);
        }
    }

    // alternatively
    // static void backtrack(int[] nums, List<List<Integer>> subsets, List<Integer> curSet, int start) {
    //     subsets.add(new ArrayList(curSet));
    //     for (int i = start; i < nums.length; i++) {
    //         curSet.add(nums[i]);
    //         backtrack(nums, subsets, curSet, i + 1);
    //         curSet.remove(curSet.size() - 1);
    //     }
    // }
}
