package com.topics.datastructures;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Arrays;

public class Heap {

    public static void main(String... args) {
        minHeapImplementation();
        maxHeapImplementation();
    }

    private static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }

    static void addNums(PriorityQueue<Integer> heap) {
        int[] nums = {3, 99, 25};
        Arrays.stream(nums).forEach(num -> heap.offer(num));
    }

    /*
    * Example of using PriorityQueue as min heap
    */
    static void minHeapImplementation() {
        System.out.println("==============================================================");
        System.out.println("Min Heap Start");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        addNums(minHeap);
        System.out.println("Backing array isn't necessarily ordered: " + minHeap);

        System.out.println("Iterating through elements doesn't guarantee any ordering:");
        Iterator<Integer> iter = minHeap.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("Poll elements from queue to get correct order:");
        while (minHeap.size() != 0) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        System.out.println("Min Heap End");
        System.out.println("==============================================================");
    }

    /*
    * Example of using PriorityQueue as max heap
    */
    static void maxHeapImplementation() {
        System.out.println("==============================================================");
        System.out.println("Max Heap Start");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        // Alternatively, using lambda or Comparator
        // var maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        // var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        addNums(maxHeap);
        System.out.println("Backing array isn't necessarily ordered: " + maxHeap);

        System.out.println("Iterating through elements doesn't guarantee any ordering:");
        Iterator<Integer> iter = maxHeap.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("Poll elements from queue to get correct order:");
        while (maxHeap.size() != 0) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();

        System.out.println("Max Heap End");
        System.out.println("==============================================================");
    }
}
