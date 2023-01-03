package com.company.xx.string.T28找出字符串中第一个匹配项的下标;

import java.util.Arrays;

public class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        System.out.println(Arrays.toString(next));
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) { // 前后缀不相等的情况
                j = next[j - 1]; // 向前一直回退，也是找最长相等前后缀的过程
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return (i - j + 1);
            }
        }
        return -1;
    }

    public int[] getNext(String s) {
        int n = s.length();
        int j = 0; // 前缀的末尾
        int[] next = new int[s.length()];
        // i代表后缀的末尾
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) { // 前后缀不相等的情况
                j = next[j - 1]; // 向前一直回退，也是找最长相等前后缀的过程
            }
            if (s.charAt(i) == s.charAt(j)) {  // 前后缀相等的情况
                j++;
            }
            next[i] = j; // 更新
        }
        return next;
    }

    public static void main(String[] args) {
        String h = "mississippi";
        String n = "issip";
        new Solution().strStr(h,n);
    }
}
