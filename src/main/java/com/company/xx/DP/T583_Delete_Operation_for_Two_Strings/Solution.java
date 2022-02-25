package com.company.xx.DP.T583_Delete_Operation_for_Two_Strings;

import java.util.Arrays;

public class Solution {
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return n + m - 2 * dp[n][m];
    }

    public static int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[j][0] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1] + 2);
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";
        System.out.println(minDistance2(word1, word2));
    }
}
