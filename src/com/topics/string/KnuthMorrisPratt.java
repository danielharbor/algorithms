package com.topics.string;

/*
 * Implementation of Knuth-Morris-Pratt algorithm as described here:
 * https://www.youtube.com/watch?v=BXCEFAzhxGY
 * Linear time string pattern matching.
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 *
 * Other linear time string matching algorithms are:
 * Rabin-Karp & Boyer-Moore
*/
public class KnuthMorrisPratt {
    public static void main(String... args) {
        String word = "awsgxawsgbo", pattern = "awsgbo";
        int[] lps = buildLPS(pattern);
        System.out.println(matchKMP(word, pattern, lps));
    }

    static int[] buildLPS(String pattern) {
        int i = 0, j = 1;
        int[] lps = new int[pattern.length()];
        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[j] = i + 1;
                ++i;
                ++j;
            } else {
                if (i != 0) {
                    i = lps[i-1];
                } else {
                    lps[j] = 0;
                    ++j;
                }
            }
        }

        return lps;
    }

    static boolean matchKMP(String word, String pattern, int[] lps) {
        int i = 0, j = 0;
        while (i < word.length()) {
            if (word.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
                if (i == pattern.length()) {
                    return true;
                }
            } else {
                if (j == 0) {
                    ++i;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        return false;
    }
}
