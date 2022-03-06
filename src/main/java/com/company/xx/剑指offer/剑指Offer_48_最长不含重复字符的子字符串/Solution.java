package com.company.xx.剑指offer.剑指Offer_48_最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[n];
        dp[0] = 1;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < n; i++) {
            Integer j = map.getOrDefault(s.charAt(i), -1);
            if (i - j > dp[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = i - j;
            }
            map.put(s.charAt(i), i);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int max = 1;
        Set<Character> set = new HashSet<>();
        int[] dp = new int[n];
        dp[0] = 1;
        set.add(s.charAt(0));
        for (int i = 1; i < n; i++) {
            if (set.contains(s.charAt(i))) {
                dp[i] = 1;
                set.clear();
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            set.add(s.charAt(i));
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))){
                start = Math.max(map.get(s.charAt(i)), start);
            }
            max = Math.max(i - start, max);
            map.put(s.charAt(i), i);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcb";
        new Solution().lengthOfLongestSubstring3(s);
    }
}
