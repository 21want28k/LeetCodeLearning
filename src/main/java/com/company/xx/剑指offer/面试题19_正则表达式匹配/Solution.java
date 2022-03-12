package com.company.xx.剑指offer.面试题19_正则表达式匹配;

import java.util.Arrays;

public class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // normal char
                if (p.charAt(j - 1) != '*') {
                    if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                        dp[i][j] |= dp[i - 1][j - 1];
                    }
                } else {
                    if (j >= 2) {
                        dp[i][j] |= dp[i][j - 2];
                    }

                    if (i >= 1 && j >= 2 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][m];
    }

    public boolean isMatch2(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(f));
        return f[n][m];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        new Solution().isMatch(s, p);
    }
}
