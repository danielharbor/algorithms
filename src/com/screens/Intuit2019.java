package com.phonescreens;

import java.util.*;

class Intuit2019 {
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        // int[] res = specialSum(nums);
        int[] res = specialSumNoDivision(nums);
        // int[] res = specialSumNoClone(nums);
        System.out.println(Arrays.toString(res));
    }

    /**
    * Returns an array such that output[i] = (product of all input elements)/input[i]
    * input will contain non-zero non-sorted integer array
    **/
    // 2 * O(n)
    // O(n) n -> size of input
    public static int[] specialSum(int []Input) {
        int[] res = new int[Input.length];
        int multiplier = 1;
        for (int i = 0; i < Input.length; i++) {
            multiplier *= Input[i];  // multiply all elements
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = multiplier / Input[i];
        }

        return res;
    }

    public static int[] specialSumNoDivision(int[] input) {
        int[] arrCopy = input.clone();
        int prev = 1;
        for (int i = 1; i < input.length; i++) {
            int temp = input[i];
            input[i] = prev * input[i-1];  // input[i] holds multiplication of all values on the left of i (i.e. from left to right)
            prev = temp;
        }

        for (int i = input.length-2; i > 0; i--) {  // don't go up to idx 0 as it still holds it original value
            input[i] *= prev;
            prev *= arrCopy[i];  // prev holds multiplication of all values on the right of i (i.e. from right to left)
        }
        input[0] = prev;
        return input;
    }

    public static int[] specialSumNoClone(int[] input) {
        int[] res = new int[input.length];
        res[0] = 1;

        for (int i = 1; i < input.length; i++) {
            res[i] = res[i-1] * input[i-1];
        }

        int prev = 1;
        for (int i = res.length-2; i >= 0; i--) {
            prev *= input[i+1];
            res[i] *= prev;
        }
        return res;
    }

    public static int[] specialSumRecursive(int[] input) {
        int[] multiplier = {1};  // single element array to hold the multiplier
        getMultiplier(input, input.length-1, multiplier);
        return input;
    }

    public static void getMultiplier(int[] input, int curIdx, int[] res) {
        if (curIdx >= 0) {
            res[0] *= input[curIdx];
            getMultiplier(input, curIdx-1, res);
            input[curIdx] = res[0] / input[curIdx];
        }
    }
}
