package com.company.xx.DP.T115_Distinct_Subsequences;

import java.util.Arrays;

public class Solution {
    public static int numDistinct(String s, String t) {
        int n = t.length();
        int m = s.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < m + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    if (i == j) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }else {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        System.out.println(numDistinct(s, t));
    }
}
