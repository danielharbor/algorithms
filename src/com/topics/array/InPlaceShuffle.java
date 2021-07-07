package com.topics.array;

import java.util.*;
import java.util.Arrays;

public class InPlaceShuffle {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5}, n = arr.length;
        Random rand = new Random();
        System.out.println("Original: " + Arrays.toString(arr).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        for (int i = 0; i < n; ++i) {
            int randIdx = rand.nextInt(n - i) + i;
            int temp = arr[i];
            arr[i] = arr[randIdx];
            arr[randIdx] = temp;
        }

        System.out.println("Shuffled: " + Arrays.toString(arr).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }
}
