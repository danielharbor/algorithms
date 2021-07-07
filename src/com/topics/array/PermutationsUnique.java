package com.topics.array;

import java.util.*;

/**
* Given a collection of distinct integers, return all possible permutations.
* e.g. Input: [1,2,3] Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/
public class PermutationsUnique {

    public static void main(String[] args) {
        System.out.println("permutations");
        int[] nums = {1,2,3};
        // List<List<Integer>> permutations = new ArrayList();
        // getPermutations(nums, new ArrayList(), permutations, 0);
        // getPermutations2(nums, new ArrayList(), permutations);
        // System.out.println(permutations);
        getPermutations3(nums, nums.length); // Heap's algorithm
    }

    // Build the list from the ground up, adding each element to
    // each index of the current list.
    static void getPermutations(int[] nums, List<Integer> list, List<List<Integer>> permutations, int idx) {
        if (list.size() == nums.length) {
            permutations.add(list);
            System.out.println(list);
            return;
        }
        for (int i = 0; i <= list.size(); i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(i, nums[idx]);
            getPermutations(nums, newList, permutations, idx+1);
        }
    }

    static void getPermutations2(int[] nums, List<Integer> list, List<List<Integer>> permutations) {
        if (list.size() == nums.length) {
            permutations.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                getPermutations2(nums, list, permutations);
                list.remove(list.size() - 1);
            }
        }
    }

    // Heap's algorithm: https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
    static void getPermutations3(int[] nums, int n) {
        if (n == 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        for (int i = 0; i < n; ++i) {
            getPermutations3(nums, n - 1);
            if (n % 2 == 0) {
                swap(nums, i, n - 1);
            } else {
                swap(nums, 0, n - 1);
            }
        }
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
