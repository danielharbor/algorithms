package com.topics.array;

import java.util.*;
import java.util.Arrays;

// Fisher-Yates shuffle / Knuth Shuffle
public class InPlaceShuffle {
    public static void main(String[] args) {
        shuffleLeftToRight();
        shuffleRightToLeft();
    }

    static void shuffleLeftToRight() {
        System.out.println("left to right:");
        Random rand = new Random();
        int arr[] = {1,2,3,4,5}, n = arr.length;
        System.out.println("Original: " + Arrays.toString(arr));

        for (int i = 0; i < n; ++i) {
            int randIdx = rand.nextInt(n - i) + i;
            int temp = arr[i];
            arr[i] = arr[randIdx];
            arr[randIdx] = temp;
        }

        System.out.println("Shuffled: " + Arrays.toString(arr));
    }

    static void shuffleRightToLeft() {
        System.out.println("right to left:");
        Random rand = new Random();
        int arr[] = {1,2,3,4,5}, n = arr.length;
        System.out.println("Original: " + Arrays.toString(arr));

        for (int i = n - 1; i >= 0; --i) {
            int randIdx = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[randIdx];
            arr[randIdx] = temp;
        }

        System.out.println("Shuffled: " + Arrays.toString(arr));
    }
}
