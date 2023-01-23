package com.company.xx.TOP100.T3无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int res = 0;
        while (right < n) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                res = Math.max(res, right - left + 1);
            } else {
                while (s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("abcabcbb");
    }
}
