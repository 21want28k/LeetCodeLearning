package com.company.xx.剑指offer.剑指Offer_50_第一个只出现一次的字符;

public class Solution {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] counts = new int[26];
        for (char c : chars) {
            counts[c - 'a']++;
        }
        for (char aChar : chars) {
            if (counts[aChar - 'a'] == 1) {
                return aChar;
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Solution().firstUniqChar(s));
    }
}
