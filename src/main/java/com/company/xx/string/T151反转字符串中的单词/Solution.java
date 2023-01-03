package com.company.xx.string.T151反转字符串中的单词;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        int end = 0;
        int start = 0;
        while (end < n) {
            while (end < n && chars[end] != ' ') {
                end++;
            }
            reverse(chars, start, end - 1);
            while (end < n && chars[end] == ' ') {
                end++;
                start = end;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0 && chars[i] == ' ' && chars[i] == chars[i - 1]) {
                continue;
            }
            builder.append(chars[i]);
        }
        return builder.toString();
    }

    public void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char temp = chars[high];
            chars[high] = chars[low];
            chars[low] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        String s = "a good   example";
        new Solution().reverseWords(s);
    }
}
