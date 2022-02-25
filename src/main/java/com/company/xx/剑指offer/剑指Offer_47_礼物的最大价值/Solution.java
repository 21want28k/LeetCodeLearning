package com.company.xx.剑指offer.剑指Offer_47_礼物的最大价值;

import com.company.xx.utils.MyStringUtils;

import java.util.Arrays;

public class Solution {
    public int maxValue(int[][] grid) {
        // m * n
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] += dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m - 1][n - 1];
    }

    public int maxValue2(int[][] grid) {
        // m * n
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }

    public int maxValue3(int[][] grid) {
        // m * n
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            dp[i] = dp[i - 1] + grid[0][i - 1];
//        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j + 1] = Math.max(dp[j], dp[j + 1]) + grid[i][j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "[[1,3,1],[1,5,1],[4,2,1]]";
        System.out.println(MyStringUtils.replaceBracketsToBraces(s1));
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        s.maxValue(grid);
    }
}
