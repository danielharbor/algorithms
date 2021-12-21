package com.topics.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*

Power Hungry
============

Commander Lambda's space station is HUGE. And huge space stations take a LOT of power. Huge space stations with doomsday devices take even more power. To help meet the station's power needs, Commander Lambda has installed solar panels on the station's outer surface. But the station sits in the middle of a quasar quantum flux field, which wreaks havoc on the solar panels. You and your team of henchmen have been assigned to repair the solar panels, but you'd rather not take down all of the panels at once if you can help it, since they do help power the space station and all!

You need to figure out which sets of panels in any given array you can take offline to repair while still maintaining the maximum amount of power output per array, and to do THAT, you'll first need to figure out what the maximum output of each array actually is. Write a function solution(xs) that takes a list of integers representing the power output levels of each panel in an array, and returns the maximum product of some non-empty subset of those numbers. So for example, if an array contained panels with power output levels of [2, -3, 1, 0, -5], then the maximum product would be found by taking the subset: xs[0] = 2, xs[1] = -3, xs[4] = -5, giving the product 2*(-3)*(-5) = 30.  So solution([2,-3,1,0,-5]) will be "30".

Each array of solar panels contains at least 1 and no more than 50 panels, and each panel will have a power output level whose absolute value is no greater than 1000 (some panels are malfunctioning so badly that they're draining energy, but you know a trick with the panels' wave stabilizer that lets you combine two negative-output panels to produce the positive output of the multiple of their power values). The final products may be very large, so give the solution as a string representation of the number.

Test cases
==========
Your code should pass the following test cases.
Note that it may also be run against hidden test cases not shown here.

Input:
[2, 0, 2, 2, 0]
Output:
8

Input:
[-2, -3, 4, -5]
Output:
60

*/

public class GoogleMaxProduct {
    public static void main(String... args) {
        Map<int[], String> nums = new HashMap<>();
        nums.put(new int[]{0}, "0");
        nums.put(new int[]{0, -1}, "0");
        nums.put(new int[]{-2, -3, 4, -5}, "60");
        nums.put(new int[]{2, 0, 2, 2, 0}, "8");
        nums.put(new int[]{0, 0, 0, 0, 1}, "1");
        nums.put(new int[]{123232323, 122332, 123322, 13234343, 1223322, -11232343, -1123434344}, "379810088551875632600617859204414815692128828544");
        nums.put(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, -2147483648}, "2085924831995838196100731849789837824062879604224266406034974605029173652865921331108767596544");
        nums.put(new int[]{-2147483647, -1}, "2147483647");
        nums.put(new int[]{-2147483648, -1}, "2147483648");
        nums.put(new int[]{Integer.MIN_VALUE, -1}, "2147483648");
        nums.put(new int[]{-2147483648}, "-2147483648");
        nums.put(new int[]{-1}, "-1");

        for (int[] num : nums.keySet()) {
            System.out.println("Expected: " + nums.get(num) + ", Got: " + getMaxProduct(num));
        }
    }

    static String getMaxProduct(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        PriorityQueue<Long> negativeHeap = new PriorityQueue<>(Comparator.reverseOrder());
        boolean productIsZero = true;
        String product = "1";
        for (int num : nums) {
            if (num < 0) {
                negativeHeap.offer((long)num * -1); // using long to avoid integer overflow (INT_MIN * -1)
            } else if (num > 0) {
                productIsZero = false;
                product = multiply(product, String.valueOf(num));
            }
        }

        while (negativeHeap.size() >= 2) {
            productIsZero = false;
            String negativeProduct = multiply(String.valueOf(negativeHeap.poll()), String.valueOf(negativeHeap.poll()));
            product = multiply(product, negativeProduct);
        }

        if (productIsZero) {
            product = "0";
        }

        return product;
    }

    private static String multiply(String num1, String num2) {
        if (num1.equals("1")) {
            return num2;
        }

        if (num2.equals("1")) {
            return num1;
        }

        // ensure num1 is the longer string
        if (num2.length() > num1.length()) {
            return multiply(num2, num1);
        }

        StringBuilder[] rows = new StringBuilder[num2.length()];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        StringBuilder zeroPad = new StringBuilder("");
        int row = 0, carry = 0;

        for (int i = num2.length()-1; i >= 0; i--) {
            for (int j = num1.length()-1; j >= 0; j--) {
                int x = num2.charAt(i) - '0';
                int y = num1.charAt(j) - '0';
                int product = x * y + carry;
                int val = product % 10;
                carry = product / 10;
                rows[row].insert(0, val);
            }
            if (carry != 0) {
                rows[row].insert(0, carry);
                carry = 0;  // Important: reset carry
            }

            rows[row++].append(zeroPad);
            zeroPad.append("0");
        }

        // Sum all rows
        StringBuilder res = new StringBuilder();
        res.append(rows[0]);

        for (int i = 1; i < rows.length; i++) {
            res = add(res, rows[i]);
        }

        return res.toString();
    }

    private static StringBuilder add(StringBuilder a, StringBuilder b) {
        StringBuilder res = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1, carry = 0; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = x + y + carry;
            int val = sum % 10;
            carry = sum / 10;
            res.append(val);
        }
        return res.reverse();
    }
}
