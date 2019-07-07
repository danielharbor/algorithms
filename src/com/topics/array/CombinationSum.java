package com.topics.array;

import java.util.*;

/**
* Given a set of candidate numbers (candidates) (without duplicates) and a target
* number (target), find all unique combinations in candidates where the candidate
* numbers sums to target.
* The same repeated number may be chosen from candidates unlimited number of times.
*/
public class CombinationSum {
    public static void main(String... args) {
        int[] nums = {1,2,3};
        int target = 3;
        List<List<Integer>> permutations = new ArrayList();
        Arrays.sort(nums);
        getCombinations(nums, permutations, new ArrayList(), target, 0);
        System.out.println(permutations);
    }

    static void getCombinations(int[] nums, List<List<Integer>> res, List<Integer> list, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            List<Integer> newList = new ArrayList(list);
            newList.add(nums[i]);
            getCombinations(nums, res, newList, target - nums[i], i);
        }
    }
}
