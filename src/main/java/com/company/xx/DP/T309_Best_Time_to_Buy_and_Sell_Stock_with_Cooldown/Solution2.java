package com.company.xx.DP.T309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];// 持有
        dp[0][1] = 0; // 刚卖出
        dp[0][2] = 0; // 卖出状态，本来就没有
        dp[0][3] = 0; // 冷冻期
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][2], dp[i - 1][3]) - prices[i], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][3], dp[i - 1][2]);
            dp[i][3] = dp[i - 1][1];
        }
        return Stream.of(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2], dp[n - 1][3]).max(Comparator.comparingInt(value -> value)).get();
    }
}
