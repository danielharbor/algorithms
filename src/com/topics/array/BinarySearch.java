package com.topics.array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,3,5,9,11};

        for (int n : new int[]{3, 7, 9, 10}) {
            System.out.println(binarySearchIterative(nums, n));
            System.out.println(binarySearchRecursive(nums, n, 0, nums.length));
        }

        System.out.println(binarySearchLessThanOrEq(nums, 12));
        System.out.println(binarySearchGreaterThanOrEq(nums, 10));
    }

    /**
    * Returns the element's index if it exists in the input array and -1 otherwise - Iterative
    */
    static int binarySearchIterative(int[] nums, int target) {
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
                return mid;
            }
        }
        return -1;
    }

    /**
    * Returns the element's index if it exists in the input array and -1 otherwise - Recursive
    */
    static int binarySearchRecursive(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) >>> 1;
        if (nums[mid] < target) {
            return binarySearchRecursive(nums, target, mid+1, hi);
        } else if (nums[mid] > target) {
            return binarySearchRecursive(nums, target, lo, mid-1);
        } else {
            return mid;
        }
    }

    /**
    * Returns the minimum element closest to the input n. Returns -1 if there is no number lower than or equal to n in the input array.
    */
    static int binarySearchLessThanOrEq(int[] nums, int n) {
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
    static int binarySearchGreaterThanOrEq(int[] nums, int n) {
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

        return lo >= nums.length ? -1 : lo;
    }
}
