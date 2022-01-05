package com.phonescreens;

import java.util.Arrays;

// https://www.youtube.com/embed/kk-_DDgoXfk
// https://www.geeksforgeeks.org/pancake-sorting/
class Square2019Phone1 {
    public static void main(String args[]) {
        int[] arr = {3,1,5,4,2};
        pancakeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void pancakeSort(int[] A) {
        for (int flipIndex = A.length-1; flipIndex >= 0; flipIndex--) {
            int maxIndex = findMaxIndex(A, flipIndex);

            // no need to flip if the element is already in the right position
            if (maxIndex == flipIndex) {
                continue;
            }

            flip(A, maxIndex);  // flip to get max element to the top of the list
            flip(A, flipIndex);  // flip to get max element back to the bottom of the list
        }
    }

    static void flip(int[] arr, int k) {
        for (int beg = 0, end = k; beg < end; beg++, end--) {
            int temp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = temp;
        }
    }

    static int findMaxIndex(int[] arr, int flipIndex) {
        int max = arr[flipIndex], maxIndex = flipIndex;
        for (int i = flipIndex; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
