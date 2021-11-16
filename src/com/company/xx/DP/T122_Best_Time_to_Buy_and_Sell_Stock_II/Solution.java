package com.company.xx.DP.T122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2]; // dp[i][0] 代表第i天持有票的收入，dp[i][1] 代表第i天不持有股票第收入。

        dp[1][0] = -prices[0]; // 第一天持有股票，第一天花钱买入了。
        dp[1][1] = 0; // 第一天不持有股票

        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
        }
        return Math.max(dp[n][0], dp[n][1]);
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;

        int have = -prices[0];
        int notHave = 0;

        for (int i = 2; i < n + 1; i++) {
            have = Math.max(have, notHave - prices[i - 1]);
            notHave = Math.max(notHave, have + prices[i - 1]);
        }

        return Math.max(have, notHave);
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit2(prices));
    }
}
