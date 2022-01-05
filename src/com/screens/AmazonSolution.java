package com.topics.random;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class AmazonSolution
{
    public static void main(String[] args) {
        int numDestinations = 3;
        List<Integer> location1 = new ArrayList(Arrays.asList(1,-3));
        List<Integer> location2 = new ArrayList(Arrays.asList(1,2));
        List<Integer> location3 = new ArrayList(Arrays.asList(3,4));
        List<List<Integer>> allLocations = new ArrayList();
        int numDeliveries = 0;
        allLocations.add(location1);
        allLocations.add(location2);
        allLocations.add(location3);
        System.out.println(ClosestXdestinations(numDestinations, allLocations, numDeliveries));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
	{
        // WRITE YOUR CODE HERE
        // Treemap will use natural ordering of keys to store them
        Map<Double, List<Integer>> map = new TreeMap<Double, List<Integer>>();
        List<List<Integer>> destinations = new ArrayList<List<Integer>>();

        for (List<Integer> list : allLocations) {
            double distance = Math.sqrt((list.get(0) * list.get(0)) +
                            (list.get(1) * list.get(1)));
            // this will override an existing location with the same distance,
            // but it doesn't matter because we can return any one
            map.put(distance, list);
        }

        // iterate over map and return the first X (numDeliveries) elements
        int count = 0;
        for (List<Integer> destination : map.values()) {
            if (count == numDeliveries) {
                break;
            }
            destinations.add(destination);
            count++;
        }

        return destinations;
    }
    // METHOD SIGNATURE ENDS
}
