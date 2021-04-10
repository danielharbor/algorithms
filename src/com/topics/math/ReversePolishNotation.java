package com.topics.math;

public class ReversePolishNotation {
    public static void main (String... args) {
        System.out.println("Reverse Polish Notation!");
        String[] expression = {"2", "1", "+", "3", "*"};
        // String[] expression = {"2", "3", "*"};
        // String[] expression = {"2"};
        int res = evalRPN(expression, expression.length - 1);
        System.out.println(res);
    }

    static int evalRPN(String[] expr, int idx) {
        int res = 0;
        switch (expr[idx]) {
            case "+":
                res = evalRPN(expr, idx-2) + Integer.parseInt(expr[idx-1]);
                break;
            case "-":
                res = evalRPN(expr, idx-2) - Integer.parseInt(expr[idx-1]);
                break;
            case "/":
                res = evalRPN(expr, idx-2) / Integer.parseInt(expr[idx-1]);
                break;
            case "*":
                res = evalRPN(expr, idx-2) * Integer.parseInt(expr[idx-1]);
                break;
            default:
                res = Integer.parseInt(expr[idx]);
                break;
        }
        return res;
    }
}
