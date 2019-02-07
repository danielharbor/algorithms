package com.topics.string;

import java.util.List;
import java.util.ArrayList;

// Return all valid parentheses combinations for a given integer k
public class GenerateParentheses {
    public static void main(String... args) {
        List<String> res = new ArrayList();
        int k = 4;
        generateParenthesesHelper(res, "", k, k);
        System.out.println(res);
    }

    static void generateParenthesesHelper(List<String> res, String str, int open, int close) {
        if (open == 0 && close == 0) {
            res.add(str);
        }

        if (open > 0) {
            generateParenthesesHelper(res, str + "(", open-1, close);
        }

        if (close > open) {
            generateParenthesesHelper(res, str + ")", open, close-1);
        }
    }
}
