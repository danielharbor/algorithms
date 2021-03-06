package com.topics.random;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Optional;

public class OptionalTest {

    static void playAroundWithOptional() {
        Deque<Optional<Integer>> stack = new ArrayDeque<>();
        stack.push(Optional.of(3));

        // ofNullable enables the use of null values with ArrayDeque
        stack.push(Optional.ofNullable(null));
        stack.push(Optional.empty()); // another way to add null

        while (!stack.isEmpty()) {
            // note what happens when you call without .orElse
            System.out.println("Wrapped: " + stack.peek());  // value is wrapped
            System.out.println("Unwrapped: " + stack.peek().orElse(-1));
            stack.pop();
        }
    }

    public static void main(String... args) {
        playAroundWithOptional();
    }
}
