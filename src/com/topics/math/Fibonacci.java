package com.topics.math;

// Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
public class Fibonacci {
    public static void main(String... args) {
        System.out.println("Fibonacci");
        int n = 11;
        System.out.println(getNthFibonacciRecursive(n));
        System.out.println(getNthFibonacciTopDown(n, new Integer[n+1]));
        printFibonacciBottomUp(n);
    }

    static int getNthFibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return getNthFibonacciRecursive(n-1) + getNthFibonacciRecursive(n-2);
    }

    static int getNthFibonacciTopDown(int n, Integer[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = getNthFibonacciTopDown(n-1, memo) + getNthFibonacciTopDown(n-2, memo);
        return memo[n];
    }

    static void printFibonacciBottomUp(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i == 0 || i == 1 ? i : dp[i-1] + dp[i-2];
            System.out.print(dp[i] + " ");  // dp[n] will hold the nth fib
        }
    }
}
