package com.topics.random;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class AmazonSolution2
{
    public static void main(String[] args) {
        List<List<Integer>> foreground = new ArrayList();
        List<List<Integer>> background = new ArrayList();
        List<Integer> foreground1 = new ArrayList(Arrays.asList(1,1));
        List<Integer> foreground2 = new ArrayList(Arrays.asList(2,1));
        List<Integer> foreground3 = new ArrayList(Arrays.asList(3,1));
        List<Integer> background1 = new ArrayList(Arrays.asList(1,2));
        List<Integer> background2 = new ArrayList(Arrays.asList(2,2));
        List<Integer> background3 = new ArrayList(Arrays.asList(3,2));
        foreground.add(foreground1);
        foreground.add(foreground2);
        foreground.add(foreground3);
        background.add(background1);
        background.add(background2);
        background.add(background3);
        System.out.println(optimalUtilization(0, foreground, background));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<List<Integer>> optimalUtilization(
	                        int deviceCapacity,
                            List<List<Integer>> foregroundAppList,
                            List<List<Integer>> backgroundAppList)
	{
        // WRITE YOUR CODE HERE
        List<List<Integer>> optimalList = new ArrayList<List<Integer>>();
        Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
        int curMax = -1;

        // do a cross look up of both app lists
        for (List<Integer> foregroundApp : foregroundAppList) {
            for (List<Integer> backgroundApp : backgroundAppList) {
                int sum = foregroundApp.get(1) + backgroundApp.get(1);

                // invalid combination
                if (sum > deviceCapacity) {
                    continue;
                }
                if (sum > curMax) {
                    map.remove(curMax);
                }

                List<Integer> newCombination = new ArrayList<Integer>(Arrays.asList(foregroundApp.get(0), backgroundApp.get(0)));
                if (sum == curMax) {  // add new combination to result list
                    List<List<Integer>> curResult = map.get(sum);
                    curResult.add(newCombination);
                    map.put(sum, curResult);
                } else if (map.size() == 0) {
                    List<List<Integer>> newResult = new ArrayList<List<Integer>>();
                    newResult.add(newCombination);
                    map.put(sum, newResult);
                    curMax = sum;
                }
            }
        }

        return curMax != -1 ? map.get(curMax) : new ArrayList();
    }
    // METHOD SIGNATURE ENDS
}
