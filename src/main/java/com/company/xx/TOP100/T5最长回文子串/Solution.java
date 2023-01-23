package com.company.xx.TOP100.T5最长回文子串;

import java.util.Arrays;

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        String res = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 <= j - 1) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] == true && (j - i + 1) > max) {
                    res = s.substring(i, j + 1);
                    max = j - i + 1;
                }
            }
        }
        return res;
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (res.length() < right - left + 1) {
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (res.length() < right - left + 1) {
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        new Solution().longestPalindrome2("babad");
    }
}
