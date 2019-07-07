package com.topics.string;

import java.util.*;

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

public class GroupAnagrams {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(anagrams(strs));
    }

    static List<List<String>> anagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap();

        for (String str : strs) {
            if (str != null) {
                Map<Character, Integer> strMap = getStrMap(str);
                List<String> list = map.containsKey(strMap) ? map.get(strMap) : new ArrayList();
                list.add(str);
                map.put(strMap, list);
            }
        }

        return new ArrayList<>(map.values());
    }

    static Map<Character, Integer> getStrMap(String str) {
        Map<Character, Integer> map = new HashMap();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
