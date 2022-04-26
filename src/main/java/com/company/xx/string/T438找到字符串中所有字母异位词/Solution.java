package com.company.xx.string.T438找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        if (pLength > sLength) {
            return res;
        }

        //  initial status
        int left = 0;
        int right = pLength - 1;
        int[] sCounts = new int[26];
        int[] pCounts = new int[26];

        for (int i = 0; i < pLength; i++) {
            sCounts[s.charAt(i) - 'a']++;
            pCounts[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCounts, sCounts)) {
            res.add(0);
        }


        // loop
        while (right < sLength - 1) {
            sCounts[s.charAt(left) - 'a']--;
            left++;
            right++;
            sCounts[s.charAt(right) - 'a']++;
            if (Arrays.equals(pCounts, sCounts)) {
                res.add(left);
            }
        }
        return res;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int[] cnt = new int[26];
        List<Integer> res = new ArrayList<>();

        for (char c : p.toCharArray()) {
            cnt[c-'a']++;
        }


        int low = 0, high = 0;
        while (high < s.length()) {
            char charHigh = s.charAt(high);
            if (cnt[charHigh - 'a'] > 0) {
                cnt[charHigh - 'a']--;
                high++;
                if (high - low == p.length()) {
                    res.add(low);
                }
            } else {
                char charLow = s.charAt(low);
                cnt[charLow - 'a']++;
                low++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abb";
        String p = "ab";
        new Solution().findAnagrams2(s, p);
    }
}