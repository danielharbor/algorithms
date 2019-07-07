package com.topics.array;

import java.util.*;

/**
* Given a collection of numbers that might contain duplicates, return all possible unique permutations.
* Input: [1,2,2] Output: [[1,2,2],[2,1,2],[2,2,1]]
*/
public class PermutationsNonUnique {
    public static void main(String args[]) {
        List<List<Integer>> permutations = new ArrayList();
        int[] nums = {1,2,2};
        Arrays.sort(nums);
        getPermutations(nums, permutations, new ArrayList(), new boolean[nums.length]);
        System.out.println(permutations);
    }

    static void getPermutations(int[] nums, List<List<Integer>> permutations, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            permutations.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && (nums[i] == nums[i-1] && !used[i-1])) continue;
            List<Integer> newList = new ArrayList(list);
            used[i] = true;
            newList.add(nums[i]);
            getPermutations(nums, permutations, newList, used);
            used[i] = false;
        }
    }
}
