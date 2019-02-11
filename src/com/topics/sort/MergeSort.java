package com.topics.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String... args) {
        System.out.println("merge sort");
        int[] arr = {3,8,2,9,1,6,9,5,0,1};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) >>> 1;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid+1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    static void merge(int[] arr, int lo, int mid, int hi) {
        int[] copy_arr = new int[hi - lo + 1];
        int l = lo, m = mid+1, k = 0;

        while (l <= mid && m <= hi) {
            if (arr[l] <= arr[m]) {
                copy_arr[k++] = arr[l++];
            } else {
                copy_arr[k++] = arr[m++];
            }
        }

        // copy any remaining elements
        while (l <= mid) {
            copy_arr[k++] = arr[l++];
        }
        while (m <= hi) {
            copy_arr[k++] = arr[m++];
        }

        // move elements from ordered copy array into original array
        for (int i : copy_arr) {
            arr[lo++] = i;
        }
    }
}
