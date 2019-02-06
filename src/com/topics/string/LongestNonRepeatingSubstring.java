package com.topics.string;

import java.util.Map;
import java.util.HashMap;

// Get the longest substring without repeating characters
public class LongestNonRepeatingSubstring {
    public static void main(String[] args) {
        String s = "abcabcaa";
        System.out.println(getLongestNonRepeatingSubstring(s));
    }

    static int getLongestNonRepeatingSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            // -1 so we default to 0 if the value is not in the map
            // max(j, 0) is always j
            j = Math.max(j, map.getOrDefault(s.charAt(i), -1) + 1);
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
