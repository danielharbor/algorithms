package com.topics.sort;

import java.util.Arrays;

// Quicksort implementation that arbitrarily picks the last element as pivot.
// There are other ways to pick a pivot, and the choice of pivot is most
// important in determining the average runtime of this algorithm.
public class QuickSort {

    public static void main(String args[]) {
        int[] arr = {3,8,2,9,1,6,9,5,0,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arr, lo, hi);
            quickSort(arr, lo, pivot - 1);
            quickSort(arr, pivot + 1, hi);
        }
    }

    static int partition(int[] arr, int lo, int hi) {
        // picking the last element in the partition as pivot.
        // Note that although the pivot doesn't have to be the first/last element, it should be moved
        // to either ends of the partition prior to the swapping. A more efficient pivot picker would
        // use some sort of algorithm to determine the pivot, and then move that element to either the
        // lo or hi position e.g. swap(pivot, hi), before starting the partition.
        int i = lo, pivot = arr[hi];

        for (int j = lo; j < hi; j++) {  // go up to one less than pivot/hi
            if (arr[j] < pivot) {
                swap(arr, i++, j);
            }
        }

        swap(arr, i, hi);
        return i;
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
