package com.company.xx.DP.T123_Best_Time_to_Buy_and_Sell_Stock_III;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = 0; // 第一天没有买卖
        dp[0][1] = -prices[0]; // 第一天持有股票
        dp[0][2] = 0; // 第一天不持有股票
        dp[0][3] = -prices[0]; // 第二天持有股票
        dp[0][4] = 0;  // 第二天不持有股票
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }
        return Stream.of(dp[n-1][0],dp[n-1][1],dp[n-1][2],dp[n-1][3],dp[n-1][4]).max(Comparator.comparingInt(o -> o)).get();
    }
}
