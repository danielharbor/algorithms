package com.topics.array;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,3,5,9,11};
        System.out.println("Input array: " + Arrays.toString(nums));

        for (int n : new int[]{3, 7, 9, 10}) {
            System.out.println(iterative(nums, n));
            System.out.println(recursive(nums, n, 0, nums.length));
        }

        int n = 30;
        System.out.println("Nearest index less than or equal to " + n + ": " + lessThanOrEqual(nums, n));
        System.out.println("Nearest index less than or equal to " + n + ": " + lessThanOrEqual2(nums, n));
        System.out.println("Nearest index greater than or equal to " + n + ": " + greaterThanOrEqual(nums, n));
    }

    /**
    * Returns the element's index if it exists in the input array and -1 otherwise - Iterative
    */
    static int iterative(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            // Alternatives for getting mid. Don't use (lo + hi) / 2
            // https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
            // tldr; array size can be >= 2^30 and (lo + hi)) can result in an overflow
            int mid = lo + ((hi - lo) / 2);
            // Alternatively
            // int mid = (lo + hi) >>> 1;  // my favorite

            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                System.out.println("iterative value index");
                return mid;
            }
        }
        return -1;
    }

    /**
    * Returns the element's index if it exists in the input array and -1 otherwise - Recursive
    */
    static int recursive(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) >>> 1;
        if (nums[mid] < target) {
            return recursive(nums, target, mid+1, hi);
        } else if (nums[mid] > target) {
            return recursive(nums, target, lo, mid-1);
        } else {
            System.out.println("recursive value index");
            return mid;
        }
    }

    /**
    * Returns the minimum element closest to the input n. Returns -1 if there is no number lower than or equal to n in the input array.
    */
    static int lessThanOrEqual(int[] nums, int n) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] < n) {
                lo = mid + 1;
            } else if (nums[mid] > n) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return hi;
    }

    /**
    * Returns the maximum element closest to the input n. Returns -1 if there is no number greater than or equal to n in the input array.
    */
    static int greaterThanOrEqual(int[] nums, int n) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] < n) {
                lo = mid + 1;
            } else if (nums[mid] > n) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        int idx = lo >= nums.length ? -1 : lo;
        return idx;
    }

    /**
    * Returns the minimum element closest to the input n. The first element is returned if all elements are greater than n.
    */
    static int lessThanOrEqual2(int[] nums, int n) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;
            if (nums[mid] > n) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }

        return lo;
    }
}
