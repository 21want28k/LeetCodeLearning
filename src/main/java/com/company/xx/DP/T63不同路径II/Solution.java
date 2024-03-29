package com.company.xx.DP.T63不同路径II;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                if (i >= 2 && obstacleGrid[i - 1 - 1][j - 1] == 0) {
//                    dp[i][j] += dp[i - 1][j];
//                }
//                if (j >= 2 && obstacleGrid[i - 1][j - 1 - 1] == 0) {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                }
            }
        }
        return dp[m][n];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[j] = 0;
                    continue;
                }
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n];
    }
}
