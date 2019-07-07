package com.topics.string;

import java.util.*;

public class WordBreak {

    public static void main(String args[]) {
        Map<String, List<String>> inputs = new HashMap() {{
            put("pineapples", Arrays.asList("pine", "apples", "eapples", "pin"));
            put("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
            put("gabyade", Arrays.asList("gab", "gaby", "byade"));
            put("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
            put("applepenapple", Arrays.asList("apple", "pen"));
            put("leetcode", Arrays.asList("leet", "code"));
        }};

        System.out.println("Word Break 1:");
        for (Map.Entry<String, List<String>> entry : inputs.entrySet()) {
            List<String> res = wordBreak(entry.getKey(), entry.getValue());
            System.out.println("\"" + entry.getKey() + "\": " + res);
        }

        System.out.println();
        System.out.println("Word Break 2:");
        for (Map.Entry<String, List<String>> entry : inputs.entrySet()) {
            List<String> res2 = wordBreak2(entry.getKey(), entry.getValue());
            System.out.println("\"" + entry.getKey() + "\": " + res2);
        }
    }

    static List<String> wordBreak(String str, List<String> dict) {
        boolean[] dp = new boolean[str.length() + 1];
        dp[0] = true;

        // stores start index of word ending at index (just in case you need
        // to return the corresponding words, instead of just a boolean that
        // shows that the break is possible)
        int[] memo = new int[str.length() + 1];
        memo[0] = -1;

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(str.substring(j, i))) {
                    dp[i] = true;
                    memo[i] = j;
                    break;
                }
            }
        }

        // This is where "memo" is used. Chain back up to form word combinations
        List<String> list = new ArrayList();
        if (dp[str.length()]) {
            int end = str.length();
            int start = memo[end];
            while (start != -1) {
                list.add(0, str.substring(start, end));
                end = start;
                start = memo[end];
            }
        }
        return list;
    }

    // Not fast enough to pass all leetcode tests (TLE) :(
    static List<String> wordBreak2(String word, List<String> dict) {
        List<String>[] dp = new ArrayList[word.length() + 1];
        dp[0] = new ArrayList(Arrays.asList(""));

        for (int i = 1; i <= word.length(); i++) {
            dp[i] = new ArrayList();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() != 0 && dict.contains(word.substring(j, i))) {
                    String suffix = word.substring(j, i);
                    for (String str : dp[j]) {
                        String prefix = str.length() != 0 ? str + " " : "";
                        dp[i].add(prefix + suffix);
                    }
                }
            }
        }
        return dp[word.length()];
    }
}
