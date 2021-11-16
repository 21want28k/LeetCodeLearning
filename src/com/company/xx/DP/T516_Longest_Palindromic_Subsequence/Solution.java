package com.company.xx.DP.T516_Longest_Palindromic_Subsequence;

import java.util.Arrays;

public class Solution {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n]; // 0~n-1

        // initialization
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][n - 1];
    }

    public static int longestPalindromeSubseq2(String s) {
        int n = s.length();

        int[][] dp = new int[n][n]; // 0~n-1

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char sc = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                if (sc == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq2(s));
    }
}
