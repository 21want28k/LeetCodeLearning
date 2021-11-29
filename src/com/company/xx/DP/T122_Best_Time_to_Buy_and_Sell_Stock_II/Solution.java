package com.company.xx.DP.T122_Best_Time_to_Buy_and_Sell_Stock_II;

import java.util.Arrays;

public class Solution {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        dp[0][0] = 0; // 第一天不持有股票
        dp[0][1] = -prices[0]; // 第一天持有股票

        for (int i = 1; i < n; i++) {
            int price = prices[i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + price);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - price);
        }
//        return Math.max(dp[n - 1][1], dp[n - 1][0]);
        return dp[n - 1][0];
    }

    public static int maxProfit3(int[] prices) {
        int n = prices.length;

        int have = -prices[0];
        int notHave = 0;
        int preHave;
        int preNotHave;
        for (int i = 2; i < n + 1; i++) {
            preHave = have;
            preNotHave = notHave;
            have = Math.max(preHave, preNotHave - prices[i - 1]);
            notHave = Math.max(preNotHave, preHave + prices[i - 1]);
        }

        return Math.max(have, notHave);
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;

        int have = -prices[0];
        int notHave = 0;

        for (int i = 2; i < n + 1; i++) {
            have = Math.max(have, notHave - prices[i - 1]);
            notHave = Math.max(notHave, have + prices[i - 1]);
            System.out.println("" + have + ";" + notHave);
        }

        return Math.max(have, notHave);
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit2(prices));
    }
}
