package com.company.xx.DP.T714Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;


public class Solution {
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];
        // 不持有
        dp[1][0] = -prices[0];
        // 持有
        dp[1][1] = 0;

        for (int i = 2; i < n + 1; i++) {
            int price = prices[i - 1];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - price);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + price - fee);
        }
        return Math.max(dp[n][1], 0);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(maxProfit(prices, fee));
    }
}
