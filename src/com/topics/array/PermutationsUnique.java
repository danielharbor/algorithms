package com.topics.array;

import java.util.List;
import java.util.ArrayList;

/**
* Given a collection of distinct integers, return all possible permutations.
* e.g. Input: [1,2,3] Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/
public class PermutationsUnique {

    public static void main(String[] args) {
        System.out.println("permutations");
        int[] nums = {1,2,3};
        List<List<Integer>> permutations = new ArrayList();
        getPermutations(nums, new ArrayList(), permutations, 0);
        // getPermutations2(nums, new ArrayList(), permutations);
        System.out.println(permutations);
    }

    // Build the list from the ground up, adding each element to
    // each index of the current list.
    static void getPermutations(int[] nums, List<Integer> list, List<List<Integer>> permutations, int idx) {
        if (list.size() == nums.length) {
            permutations.add(list);
            return;
        }
        for (int i = 0; i <= list.size(); i++) {
            List<Integer> newList = new ArrayList(list);
            newList.add(i, nums[idx]);
            getPermutations(nums, newList, permutations, idx+1);
        }
    }

    // static void getPermutations2(int[] nums, List<Integer> list, List<List<Integer>> permutations) {
    //     if (list.size() == nums.length) {
    //         permutations.add(new ArrayList(list));
    //         return;
    //     }
    //
    //     for (int i = 0; i < nums.length; i++) {
    //         if (!list.contains(nums[i])) {
    //             list.add(nums[i]);
    //             getPermutations2(nums, list, permutations);
    //             list.remove(list.size() - 1);
    //         }
    //     }
    // }

}
