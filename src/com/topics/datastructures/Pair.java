package com.topics.datastructures;

import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.HashSet;
import java.util.Set;

/*
 * Reference: https://www.techiedelight.com/five-alternatives-pair-class-java/
 */
public class Pair {
    static <T, U> Entry<T, U> of(T first, U second) {
        return new AbstractMap.SimpleEntry<>(first, second);
    }

    public static void main(String... args) {
        Set<Entry<String, Integer>> set = new HashSet<>();
        set.add(Pair.of("abc", 1));
        System.out.println(set);
    }
}
