package com.topics.math;

/**
* Find the Greatest Common Divisor (GCD) or Highest Common Factor (HCF) of two
* or more numbers using Euclidian algorithm
*/

public class GCD {

    // gets GCD of two integers
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        System.out.println("GCD of 2 & 3 = " + gcd(2, 3));

        int[] nums = {8, 4, 10, 2, 6};
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = gcd(nums[i], result);
        }

        System.out.println("GCD of [8, 4, 10, 2, 6] = " + result);
    }
}
