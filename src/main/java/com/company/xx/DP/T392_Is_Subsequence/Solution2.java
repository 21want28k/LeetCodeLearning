package com.company.xx.DP.T392_Is_Subsequence;

import java.util.Arrays;

public class Solution2 {
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        int n = s.length();
        int m = t.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <=n ; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (j > i) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        new Solution2().isSubsequence(s, t);
    }
}
