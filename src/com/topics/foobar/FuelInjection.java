package com.topics.foobar;

import java.util.Random;
import java.math.BigInteger;

/*
 * https://www.geeksforgeeks.org/reduce-a-number-to-1-by-performing-given-operations/
*/
public class FuelInjection {
    public static void main(String... args) {
        StringBuilder strB = new StringBuilder();
        Random rand = new Random();
        strB.append(rand.nextInt(8) + 1);
        for (int i = 0; i < 600; ++i) {
            strB.append(rand.nextInt(9));
        }
        String x = strB.toString();
        solution("4");
        solution("15");
        solution(x);
    }

    static int solution(String x) {
        System.out.println("input: " + x);
        final BigInteger zero = BigInteger.ZERO;
        final BigInteger one = BigInteger.ONE;
        final BigInteger two = BigInteger.TWO;
        final BigInteger three = new BigInteger("3");
        final BigInteger four = new BigInteger("4");
        BigInteger num = new BigInteger(x);
        int count = 0;

        while (num.compareTo(one) == 1) {
            ++count;

            if (num.mod(two).equals(zero)) {
                num = num.divide(two);
            } else if (num.mod(four).equals(one) || num.equals(three)) {
                num = num.subtract(one);
            } else {
                num = num.add(one);
            }
        }

        System.out.println("res: " + count);
        return count;
    }
}
