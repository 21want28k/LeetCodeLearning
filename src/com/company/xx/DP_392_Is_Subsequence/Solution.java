package com.company.xx.DP_392_Is_Subsequence;

import java.util.Arrays;

public class Solution {
    public static boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == 0) {
            return true;
        }
        if (m == 0 || n > m) {
            return false;
        }
        boolean[][] dp = new boolean[n][m];

        char c = s.charAt(0);
        for (int i = 0; i < m; i++) {
            if (t.charAt(i) == c) {
                for (int j = i; j < m; j++) {
                    dp[0][j] = true;
                }
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j < m; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][m - 1];
    }

    public static boolean isSubsequence2(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m] == n;
    }

    public static void main(String[] args) {
        String s = new String("axc");
        String t = new String("ahbgdc");

        System.out.println(isSubsequence(s, t));
    }
}