package com.company.xx.DP.T62_不同路径问题;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i] = dp[i - 1] + dp[i];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new Solution().uniquePaths2(3, 7);
    }
}
