package com.company.xx.string.T459重复的子字符串;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return find((s + s).substring(1,(s + s).length()-1), s) != -1;
    }

    public int find(String s, String target) {
        int[] next = getNext(target);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != target.charAt(j)) {
                j = next[j-1];
            }
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            if (j == target.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public int[] getNext(String target) {
        int n = target.length();
        int[] next = new int[n];
        int j = 0;
        for (int i = 1; i < target.length(); i++) {
            while (j > 0 && target.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }
            if (target.charAt(i) == target.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "aabaaba";
        new Solution().repeatedSubstringPattern(s);
    }
}
