package com.topics.random;

import java.io.*;
import java.util.*;

/*
Your previous Plain Text content is preserved below:

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.


Example 1:
Input: "()"
Output: 1

Example 2:
Input: "(())"
Output: 2

Example 3:
Input: "()()"
Output: 2

Example 4:
Input: "(()(()()))"
Output : 10

*/

class Parentheses {
  public static void main(String[] args) {
    String[] strs = {"()", "(())", "()()", "(()(()()))"};
    for (String str : strs) {
      String res = parentheses(str);
      if (isInteger(res)) {
        System.out.println(res);
      }
    }
  }

  static String parentheses(String str) {
    Deque<String> stack = new ArrayDeque<String>();

    for (char c : str.toCharArray()) {
      String cc = String.valueOf(c);
      if (cc.equals("(")) {
        stack.push(cc);
      } else if (!stack.isEmpty()) {
        String peeked = stack.peekFirst();
        if (peeked.equals("(")) {
          stack.pop();
          int cur = 1;
          cur += getCharacterSum(stack);
          stack.push(String.valueOf(cur));
        } else if (isInteger(peeked)) {
          int cur = Integer.parseInt(stack.pop());
          cur += getCharacterSum(stack);
          if (!stack.isEmpty() && stack.peek().equals("(")) {
            stack.pop();
          }
          stack.push(String.valueOf(cur * 2));
        }
      }
    }

    return stack.peek();
  }

  static int getCharacterSum(Deque<String> stack) {
    // while the current character on the stack is a number
    int cur = 0;
    while (!stack.isEmpty() && isInteger(stack.peek())) {
      cur += Integer.parseInt(stack.pop());
    }

    return cur;
  }

  static boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
    } catch(Exception ex) {
      return false;
    }
    return true;
  }
}
