package com.company.xx.DP.T309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

import java.util.Arrays;

public class Solution {
    public static int maxProfit(int[] prices) {
        int n = prices.length;


        // 当天持有股票状态（买入状态） - 0；
        // 当天不持有股票状态
        //      - 即将进入冷冻期 - 1（今天卖出的，明天就是冷冻期了）
        //      - 即将不进入冷冻期 - 2 (当天无操作，保持卖出)
        int[][] dp = new int[n + 1][3];
        dp[1][0] = -prices[0];
        dp[1][1] = 0;
        dp[1][2] = 0;
        for (int i = 2; i < n + 1; i++) {
            int price = prices[i - 1];
            // 第i天收盘的时候持有股票 = i-1天收盘的时候就有股票；i-1天收盘的时候即将不进入冷冻期（第i天不是冷冻期）+第i天买入了股票；如果i-1天收盘的时候进入了冷冻期（今天是冷冻期）dp[i-1][1]，今天就不能买了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - price);
            // 第i天收盘即将进入冷冻期 = i-1天手上有股票，第i天刚卖的
            dp[i][1] = dp[i - 1][0] + price;
            // 第i天收盘即将不进入冷冻期 = i-1天收盘不进入冷冻期；i-1天收盘进入冷冻期=》也就是，第i天可以是冷冻期，第i天过了就不会进入冷冻期，也就是第i+1天不会是冷冻期；
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        System.out.println(Arrays.deepToString(dp));
        return Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]);
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;

        // 当天持有股票状态（买入状态） - 0；
        // 当天不持有股票状态
        //      - 是冷冻期 - 1
        //      - 不是冷冻期 - 2
        int[][] dp = new int[n + 1][3];
        dp[1][0] = -prices[0];
        dp[1][1] = 0;
        dp[1][2] = 0;
        for (int i = 2; i < n + 1; i++) {
            int price = prices[i - 1];
            // 第i天持有股票=max(昨天持有，昨天不持有且不是冷冻期+今天买，昨天是冷冻期+今天买)
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][2] - price), dp[i - 1][1] - price);
            // 第i天不持有股票且是冷冻期，说明昨天刚卖
            dp[i][1] = dp[i - 1][2];
            // 第i天不持有股票且不是冷冻期 = max(昨天不是冷冻期,昨天冷冻期今天不是,昨天持有股票，今天刚卖)
            dp[i][2] = Math.max(Math.max(dp[i - 1][2], dp[i - 1][1]), dp[i - 1][0] + price);
        }
        System.out.println(Arrays.deepToString(dp));
        return Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit2(prices));
    }
}
