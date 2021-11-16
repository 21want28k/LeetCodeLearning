package com.company.xx.DP.T_139_word_break;

import java.util.*;

public class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[s.length()];
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // the out is bag
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);
                boolean contains = dict.contains(subStr);
                if (dp[j] && contains) {
                    dp[i] = true;
                    break;
                } else {
                    dp[i] = false;
                }
//                dp[i] = dp[j] && contains;
//                break;
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // s = "leetcode", wordDict = ["leet","code"]
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        wordBreak2(s, list);
    }

}