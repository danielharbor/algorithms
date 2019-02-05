package com.topics.array;

import java.util.Arrays;

// Move all the zeroes in an array to one side while maintaining the relative
// order of all non-zero elements.
public class MoveZeroes {

    static void moveZeroesToTheLeft(int[] nums) {
        int i = nums.length, z = nums.length-1;
        while (--i >= 0) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[z];
                nums[z--] = temp;
            }
        }
    }

    static void moveZeroesToTheRight(int[] nums) {
        int i = -1, z = 0;
        while (++i < nums.length) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[z];
                nums[z++] = temp;
            }
        }
    }

    public static void main(String args[]) {
        int[] nums = {0,1,0,3,2,5};
        moveZeroesToTheLeft(nums);
        System.out.println(Arrays.toString(nums));
        moveZeroesToTheRight(nums);
        System.out.println(Arrays.toString(nums));
    }
}
