package com.company.xx.DP_T1143_Longest_Common_Subsequence;

import java.util.Arrays;

public class Solution {
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char a = text1.charAt(i - 1);
                char b = text2.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char a = text1.charAt(i - 1);
                char b = text2.charAt(j - 1);
                if (a == b) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[m];
    }


    public static void main(String[] args) {
//        String text2 = "abcde";
//        String text1 = "ace";


        String text1 = "abcba";
        String text2 = "abcbcba";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
